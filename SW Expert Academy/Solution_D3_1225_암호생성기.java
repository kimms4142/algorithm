import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input1225.txt")));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine()); // 테스트 번호
			sb.append("#").append(T).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			LinkedList<Integer> arr = new LinkedList<Integer>();

			for (int i = 0; i < 8; i++) {
				arr.offer(Integer.parseInt(st.nextToken()));
			}

			Outter: while (true) {
				for (int j = 1; j <= 5; j++) {
					int first = arr.peek(); // 첫번째 element
					first -= j;
					// 첫번째 element를 감소하였을때 값이 0보다 작은 경우
					if (first <= 0) {
						first = 0;
						arr.add(first);
						arr.remove();
						break Outter;
					}
					arr.add(first);
					arr.remove();
				}
			}
			
			Iterator<Integer> iter = arr.iterator();
			while(iter.hasNext()) {				
				sb.append(iter.next()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
