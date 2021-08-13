import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_실버2_16935_배열돌리기3 {
	static int N, M, R;
	static int[][] map;
	static int[] command;
	static int[][] move;
	static int nMid,mMid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		command = new int[R];

		// map 데이터 할당
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			command[i] = Integer.parseInt(st.nextToken());
			execute(command[i]);
		}

		for (int[] i : move) {
			for (int j : i) {
				sb.append(j).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void execute(int e) {
		
		switch (e) {
		case 1: // 상하 반전
			move = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					move[i][j] = map[N - 1 - i][j];
				}
			}
			map = move;
			break;
		case 2: // 좌우 반전
			move = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					move[i][j] = map[i][M - 1 - j];
				}
			}
			map = move;
			break;
		case 3: // 오른쪽 90도 회전
			move = new int[M][N];
			int a = N-1;
			for(int i =0; i<N;i++) {
				for(int j =0; j<M;j++) {
					move[j][a] = map[i][j];
				}
				a--;
			}
			
			int temp1 = N;
			N = M;
			M= temp1;
			
			map = move;
			break;
		case 4: // 왼쪽 90도 회전
			move = new int[M][N];
			for(int i =0;i<N;i++) {
				for(int j =0;j<M;j++) {
					move[M-j-1][i] = map[i][j];
				}
			}
			
			int temp2 = N;
			N = M;
			M = temp2;
			map = move;
			break;
		case 5: // N / 2 × M / 2 배열 시계방향
			move = new int[N][M];
			nMid = N / 2;
			mMid = M / 2;
			// 1번을 2번으로
			for (int i = 0; i < nMid; i++) {
				for (int j = 0; j < mMid; j++) {
					move[i][mMid + j] = map[i][j];
				}
			}
			// 2번을 3번으로
			for (int i = 0; i < nMid; i++) {
				for (int j = mMid; j < M; j++) {
					move[nMid + i][j] = map[i][j];
				}
			}
			// 3번을 4번으로
			for (int i = nMid; i < N; i++) {
				for (int j = mMid; j < M; j++) {
					move[i][j - mMid] = map[i][j];
				}
			}
			// 4번을 1번으로
			for (int i = nMid; i < N; i++) {
				for (int j = 0; j < mMid; j++) {
					move[i - nMid][j] = map[i][j];
				}
			}
			map = move;
			break;
		case 6: // N / 2 × M / 2 배열 반시계방향
			move = new int[N][M];
			nMid = N / 2;
			mMid = M / 2;
			// 1번을 4번으로
			for (int i = 0; i < nMid; i++) {
				for (int j = 0; j < mMid; j++) {
					move[nMid + i][j] = map[i][j];
				}
			}
			// 4번을 3번으로
			for (int i = nMid; i < N; i++) {
				for (int j = 0; j < mMid; j++) {
					move[i][mMid + j] = map[i][j];
				}
			}
			// 3번을 2번으로
			for (int i = nMid; i < N; i++) {
				for (int j = mMid; j < M; j++) {
					move[i - nMid][j] = map[i][j];
				}
			}
			// 2번을 1번으로
			for (int i = 0; i < nMid; i++) {
				for (int j = mMid; j < M; j++) {
					move[i][j-mMid] = map[i][j];
				}
			}
			map = move;
			break;
		}

	}

}
