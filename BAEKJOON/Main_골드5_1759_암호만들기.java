import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_골드5_1759_암호만들기 {
	static int L, C;
	static String[] msg;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken()); // 3 <= L <= C <= 15
		C = Integer.parseInt(st.nextToken()); // 3 <= L <= C <= 15
		msg = br.readLine().split(" ");

		Arrays.sort(msg); // sorting하면 자동으로 알파벳 순서가 증가하는 순서로 배열
		visited = new boolean[C];
		String pw = "";
		dfs(0, pw); // 0번째 index부터 시작, 만들어낼 pw
	}

	private static void dfs(int index, String pw) {
		
		// pw의 길이가 4글자가 되고, "a","e","i","o","u"인 모음이 1개이상 포함되고
		if (pw.length() == L && (pw.contains("a") || pw.contains("e") || pw.contains("i") || pw.contains("o") || pw.contains("u"))) {
			int len = pw.length();
			
			for (int i = 0; i < pw.length(); i++) { // 문자길이를 돌면서 자음을 제거했을때 
				if (pw.charAt(i) == 'a' || pw.charAt(i) == 'e' || pw.charAt(i) == 'i' || pw.charAt(i) == 'o' || pw.charAt(i) == 'u') {
					len--;
				}
			}
			if (len >= 2) { // 모음이 2개 이상인 조건을 만족할때만 print
				System.out.println(pw);
			}
		}
		if (pw.length() > L) {
			return;
		}
		for (int i = index; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, pw + msg[i]);
				visited[i] = false;
			}
		}

	}

}
