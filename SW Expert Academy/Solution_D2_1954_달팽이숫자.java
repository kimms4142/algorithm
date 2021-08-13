import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input1954.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			sb.append("#").append(tc).append("\n");


			int dy = 0; // 현재 행
			int dx = 0; // 현재 열
			int d = 0; // direction
			
			// 우 하 좌 상
			int[] di = { 0, 1, 0, -1 };
			int[] dj = { 1, 0, -1, 0 };
			
			for (int i = 1; i <= N * N; i++) {
				arr[dy][dx] = i;
				// arr[dy+0][dx+1] : 우 , arr[dy+1][dx+0] : 하 , arr[dy+0][dx-1] : 좌 , arr[dy-1][dx+0] : 상 
				dy += di[d];
				dx += dj[d];
				
				// dy, dx가 array의 index를 벗어 나는 경우 || 배열의 값이 0이 아닌 경우 => 방향 change
				if (dy >= N || dy < 0 || dx >= N || dx < 0 || arr[dy][dx] != 0) {
					dy -= di[d];
					dx -= dj[d];
					d = (d + 1) % 4;
					dy += di[d];
					dx += dj[d];
				}
			}
			for(int i =0; i <N;i++) {
				for(int j= 0 ; j<N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}
}
