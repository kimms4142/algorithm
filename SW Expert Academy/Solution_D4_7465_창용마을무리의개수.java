import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_7465_창용마을무리의개수 {
	static int N, M, result;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input7465.txt")));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = 0;
			parents = new int[N + 1];

			// make set
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}

			// 마을사람들 union
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int person1 = Integer.parseInt(st.nextToken());
				int person2 = Integer.parseInt(st.nextToken());
				union(person1, person2);
			}

			// 마을사람들 전부 find해서 배열에 부모 담기
			int[] check = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				check[i] = find(i);
				
			}
			// 오름차순 정렬
			Arrays.sort(check);
			
			int temp = 0;
			// 부모가 다를때마다 result 수 1 증가
			for (int i = 1; i <= N; i++) {
				if(temp != check[i]) { 
					temp = check[i];
					result++;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	// find set
	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return find(parents[a]);
	}

	// union set
	private static void union(int person1, int person2) {
		int p1Root = find(person1);
		int p2Root = find(person2);
		if (p1Root == p2Root) {
			return;
		}
		parents[p1Root] = p2Root;
	}
}
