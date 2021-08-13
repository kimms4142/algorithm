
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_브론즈2_3040_백설공주와일곱난쟁이 {

	static int N = 9, R = 7; // 9C7 조합 문제
	static int[] dwarf;
	static int[] selectDwarf = new int[7];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dwarf = new int[N];
		for (int i = 0; i < N; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}

		Combination(0, 0);

	}

	private static void Combination(int cnt, int start) {
		if (cnt == R) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += selectDwarf[i];
			}
			if (sum == 100) {
				for (int j : selectDwarf)
					System.out.println(j);
			}
			return;
		}

		for (int i = start; i < N; i++) {
			selectDwarf[cnt] = dwarf[i];
			Combination(cnt + 1, i + 1);
		}

	}

}
