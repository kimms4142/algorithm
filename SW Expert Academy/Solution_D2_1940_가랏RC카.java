import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D2_1940_가랏RC카 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/input1940.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			int N = sc.nextInt(); // 2 <= N <= 30
			int v = 0;
			for (int i = 0; i < N; i++) {
				int c = sc.nextInt();
				switch (c) {
				case 0:
					break;
				case 1:
					v += sc.nextInt();
					break;
				case 2:
					v -= sc.nextInt();
					if (v < 0)
						v = 0;
					break;
				}
				sum += v;
			}
			System.out.println("#" + tc + " " + sum);
		}
		sc.close();

	}
}
