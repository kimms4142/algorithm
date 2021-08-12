import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input2805.txt")));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine()); // 테스트케이스 수
		for (int test_case = 1; test_case <= tc; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String msg = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = msg.charAt(j) - '0';
				}

			}
			
			// 결과
			int result = 0; 
			
			// 윗 삼각형 ( N / 2 포함)
			for (int i = 0; i <= N / 2; i++) {
				for (int j = N / 2 - i; j <= N / 2 + i; j++) {
					result += arr[i][j];
				}
			}
			// 아래 삼각형
			int temp = 1;
			for (int i = N / 2 + 1; i < N; i++) {
				for (int j = temp; j <= N - 1 - temp; j++) {
					result += arr[i][j];
				}
				temp++;
			}

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}