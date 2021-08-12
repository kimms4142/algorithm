import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6808_규영이와인영이의카드게임 {
	static int win, lose;
	static int[] gyu; // 규영이
	static int[] in; // 인영이
	static int[] inSelect; // 인영이가 고른 패
	static int[] total;// 총패
	static boolean[] isVisited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input6808.txt")));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			gyu = new int[9]; // 규영이
			in = new int[9]; // 인영이
			total = new int[19]; // 총패

			// 규영이 패
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				gyu[i] = num;
				total[num] = num;
			}

			// 인영이 패
			int index = 0;
			for (int i = 1; i < 19; i++) {
				if (total[i] == 0) {
					in[index++] = i;
				}
			}

			win = 0;
			lose = 0;

			inSelect = new int[9];
			isVisited = new boolean[9];

			Permutation(0);
			sb.append(win).append(" ").append(lose).append("\n");

		}
		System.out.println(sb);
	}

	private static void Permutation(int r) {
		if (r == 9) {
			int gyuScore = 0; // 규영이 점수 합
			int inScore = 0; // 인영이 점수 합
			for (int i = 0; i < 9; i++) {
				if (gyu[i] > inSelect[i])
					gyuScore += (gyu[i] + inSelect[i]);
				else
					inScore += (gyu[i] + inSelect[i]);
			}

			if (gyuScore > inScore)
				win++;
			else
				lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isVisited[i])
				continue;
			inSelect[r] = in[i];
			isVisited[i] = true;
			Permutation(r + 1);
			isVisited[i] = false;

		}
	}

}
