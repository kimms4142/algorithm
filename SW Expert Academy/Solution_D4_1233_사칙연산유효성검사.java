import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input1233.txt")));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int vertex = Integer.parseInt(br.readLine()); // 정점의 수
			String[] input = new String[vertex + 1]; // 1번 index부터 사용
			

			// Data 입력
			for (int i = 0; i < vertex; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				input[Integer.parseInt(st.nextToken())] = st.nextToken(); // input[1] == - , input[2] == -, ...
			}

			int result = 1;
			for (int i = 1; i < vertex + 1; i++) {
				// *(42), +(43), -(45), /(47)
				if (input[i].charAt(0) == 42 || input[i].charAt(0) == 43 || input[i].charAt(0) == 45 || input[i].charAt(0) == 47) {
					if (i > vertex / 2) {
						result = 0;
						break;
					} 
				}
				// 0부터 9의 숫자
				if(input[i].charAt(0) >= '0' && input[i].charAt(0) <= '9') {
					if(i < vertex /2) {
						result = 0;
						break;
					}
				}
			}

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
