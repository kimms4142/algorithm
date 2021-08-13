package hwalgo04_서울_07반_김명섭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_골드5_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tower = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>(); // Stack에 int 형 배열을 저장

		for (int i = 1; i <= tower; i++) {
			int height = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty()) {
				if (stack.peek()[1] < height) { // height 보다 작으면 stack에서 제거
					stack.pop();
				} else { // height 보다 크면
					sb.append(stack.peek()[0]).append(" ");
					break;
				}

			}

			// 탑이 비어있으면 0 출력
			if (stack.isEmpty()) {
				sb.append("0 ");
			}
			stack.push(new int[] { i, height }); // 배열에 탑의 높이, 탑의 번호 장
		}
		System.out.println(sb);

	}

}
