import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("src/input1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] arr = new int[100][100];

		for (int tc = 1; tc <= 10; tc++) {

			int T = Integer.parseInt(br.readLine()); // 입력 TestCase 번호
			sb.append("#" + T + " ");

			// X = 2인 좌표
			int destX = 0;
			int destY = 0;
			char direction = 0;

			// 배열에 수 입력
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {
						destY = i;
						destX = j;
						direction = 'U';
					}
				}
			}

			// destY가 0이 될때까지 반복
			while (destY != 0) {
				// 윗 방향
				if (direction == 'U') {
					destY--;
					if (destX - 1 > 0 && arr[destY][destX - 1] == 1) {
						direction = 'L';
					} else if (destX + 1 < 100 && arr[destY][destX + 1] == 1) {
						direction = 'R';
					}
				}
				// 왼쪽 방향
				if (direction == 'L') {
					destX--;
					if (arr[destY - 1][destX] == 1) {
						direction = 'U';
					}
				}
				// 오른쪽 방향
				if (direction == 'R') {
					destX++;
					if (arr[destY - 1][destX] == 1) {
						direction = 'U';
					}
				}
			}
			sb.append(destX);
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
