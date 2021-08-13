import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/input2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int M = Integer.parseInt(st.nextToken());

			// Data 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// M * M 완전 탐색
			int fly = 0, result = 0;
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					fly = 0;
					for(int k = 0; k < M; k++) {
						for(int l = 0; l <  M; l++){
							fly += map[i+k][j+l];
						}
					}
					if(result < fly) result = fly;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}

}
