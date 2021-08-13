import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main_실버4_1244_스위치켜고끄기 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
		int swi = sc.nextInt();
		int[] swiArr = new int[swi + 1]; // 1번 index부터 사용을 위해 +1

		// 1번 배열부터 집어넣는다
		for (int i = 1; i <= swi; i++) {
			swiArr[i] = sc.nextInt();
		}

		int stuNo = sc.nextInt();
		for (int i = 1; i <= stuNo; i++) {
			int person = sc.nextInt();
			int num = sc.nextInt();
			// 남자
			if (person == 1) {
				for (int j = num; j <= swi; j += num) {
					swiArr[j] ^= 1;
				}
			}

			// 여성
			if (person == 2) {
				int left = num - 1;
				int right = num + 1;
				while (true) {
					if (left < 1 || right > swi)
						break;
					// xor : 같으면 0 다를 경우 1 반환
					if (swiArr[left] != swiArr[right])
						break;
					left--;
					right++;
				}
				left++;
				right--;
				for (; left <= right; left++) {
					swiArr[left] ^= 1;
				}

			}

		}
		for (int i = 1; i < swiArr.length; i++) {
			System.out.print(swiArr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}

	}

}
