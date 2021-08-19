import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_실버2_3109_빵집 {
	static int R, C, pipe;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		// map 입력
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			DFS(i, 0);
		}

		System.out.println(pipe);
	}

	private static boolean DFS(int i, int j) {
		// 빵집에 도착
		if (j == C - 1) {
			pipe++;
			return true;
		}

		// 오른쪽 위, 오른쪽, 오른쪽 아래
		int[] di = { -1, 0, 1 };
		for (int k = 0; k < 3; k++) {
			int ni = i + di[k];
			int nj = j + 1;
			if (ni >= 0 && ni < R && nj < C) {
				if (map[ni][nj] == 'x') {
					continue;
				}
				else {
					map[ni][nj] = 'x';
					if (DFS(ni, nj))
						return true;
				}
			}
		}
		return false;
	}
}
