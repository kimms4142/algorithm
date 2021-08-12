import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D4_5432_쇠막대기자르기 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input5432.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int tot = 0;

			int[] ia = { 1, 2, 3 };
			for (int i = 0; i < ia.length; i++) {
				int j = ia[i];

			}
			String s = sc.next();
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(') {
					cnt++;
				} else { // c == ')'
					cnt--;
					if (s.charAt(i-1) == '(') // 레이저면
						tot+= cnt;
					else
						tot++;
				}

			}
			System.out.println("#" + tc + " " + tot);

		}

	}
}
