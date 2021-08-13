import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_실버5_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input2563.txt")));

		int[][] map = new int[101][101];
		int confetti = Integer.parseInt(br.readLine()); // 색종이

		for (int i = 1; i <= confetti; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // x = 3
			int y = Integer.parseInt(st.nextToken()); // y = 7
			for (int j = y; j < y + 10; j++) { // y = 7 에서 17까지
				for (int k = x; k < x + 10; k++) { // x= 3에서 13까지
					map[j][k] = 1;
				}
			}
		}

		int result = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
//				System.out.print(map[i][j]);
				result += map[i][j];
			}
//			System.out.println();
		}
		sb.append(result);
		System.out.println(sb);
	}

}
