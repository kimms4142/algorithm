import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int maxDumpCnt = Integer.parseInt(in.readLine());
//			String s = in.readLine();
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int result = 0;
			int max = 0;
			int min = 0;
			for (int i = 0; i < maxDumpCnt; i++) {
				Arrays.sort(arr);
				arr[0] += 1;
				arr[99] -= 1;
				Arrays.sort(arr);
				max = arr[99];
				min = arr[0];
				if (max - min <= 1) {
					break;
				}
			}
			result = max - min;
			sb.append(result);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
