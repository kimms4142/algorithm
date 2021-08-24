import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합 {
	static int n, m;
	static int[][] input;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken()); // 1 <= n <= 1,000,000
			m = Integer.parseInt(st.nextToken()); // 1 <= m <= 1,000,000
			input = new int[m][3];
			parents = new int[n + 1];

			// make set : 자신 자신을 대표자로 만듬
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 3; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
				if (input[i][0] == 0) {
					union(input[i][1], input[i][2]);
				}
				if (input[i][0] == 1) {
					if (find(input[i][1]) == find(input[i][2]))
						sb.append("1");
					else
						sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// find set (1, a, b)
	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	// union set (0, a, b)
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return;

		parents[bRoot] = aRoot;
		return;

	}
}
