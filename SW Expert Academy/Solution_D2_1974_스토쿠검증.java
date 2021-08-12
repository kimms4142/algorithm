import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1974_스토쿠검증 {
	static int[][] map = new int[9][9];

	static int valid() {
		// 가로 체크
		for (int i = 0; i < 9; i++) {
			int vsum = 0;
			int hsum = 0;
			for (int j = 0; j < 9; j++) {
				hsum += map[i][j];
				vsum += map[j][i];
			}
			if (hsum != 45)
				return 0;
			if (vsum != 45)
				return 0;
		}

		// 3 * 3 체크
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int sum = 0;
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						sum += map[3 * i + k][3 * j + l];
					}
				}
				if (sum != 45)
					return 0;
			}
		}
		return 1;

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input1974.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int result = valid();
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}

}
