import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_골드5_10026_적록색약 {
	static int N, normal, colorBlind;
	static char[][] grid1, grid2;
	static boolean[][] visitedNormal, visitedColorBlind;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 1 <= N <= 100
		grid1 = new char[N][N];
		grid2 = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char ch = str.charAt(j);
				grid1[i][j] = ch;
				if (ch == 'G')
					ch = 'R';
				grid2[i][j] = ch;
			}
		}
		normal = 0;
		visitedNormal = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitedNormal[i][j]) {
					normal++;
					DFS(i, j, visitedNormal, grid1);
				}

			}
		}
		colorBlind = 0;
		visitedColorBlind = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitedColorBlind[i][j]) {
					colorBlind++;
					DFS(i, j, visitedColorBlind, grid2);
				}
			}
		}
		System.out.println(normal + " " + colorBlind);

	}

	private static void DFS(int x, int y, boolean[][] visited, char[][] grid) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		char color = grid[x][y];
		visited[x][y] = true;

		// 상하좌우 돌면서 같은색이면 visited = true로 만들기
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (visited[nx][ny])
				continue;
			if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && color == grid[nx][ny]) {
				DFS(nx, ny, visited, grid);
			}
		}

	}
}
