package prob004615;

import java.util.Scanner;

public class Solution4615 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int b = 1;
		int w = 2;
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 판 사이즈, 놓는 횟수
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if ((i == N / 2 - 1 && j == N / 2 - 1) || (i == N / 2 && j == N / 2)) {
						board[i][j] = w;
					} else if ((i == N / 2 - 1 && j == N / 2) || (i == N / 2 && j == N / 2 - 1)) {
						board[i][j] = b;
					}
				}
			}
			for (int turn = 1; turn <= M; turn++) {
				int j = sc.nextInt() - 1;
				int i = sc.nextInt() - 1;
				int bw = sc.nextInt();
				land(board, i, j, bw);
			}

			int bCnt = 0;
			int wCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == b) {
						bCnt++;
					} else if (board[i][j] == w) {
						wCnt++;
					}
				}
			}
			System.out.printf("#%d %d %d\n", testCase, bCnt, wCnt);

		}
	}

	static void land(int[][] board, int i, int j, int bw) {
		board[i][j] = bw;
		int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 };
		for (int k = 0; k < 8; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			while (ni >= 0 && ni < board[0].length && nj >= 0 && nj < board[0].length && board[ni][nj] != 0) {

				if (board[ni][nj] == bw) {
					while (board[ni - di[k]][nj - dj[k]] != bw) {

						ni -= di[k];
						nj -= dj[k];
						board[ni][nj] = bw;
					}
					break;
				}
				ni += di[k];
				nj += dj[k];
			}
		}
	}
}
