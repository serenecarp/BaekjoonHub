package prob002105;

import java.util.Scanner;

public class Solution_1 {
	static int N, answer;
	static int[][] cafe;
	static boolean[][] visited;
	static boolean[] dessert;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			cafe = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sort = sc.nextInt();
					cafe[i][j] = sort;
				}
			}

			answer = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dessert = new boolean[101];
					dessert[cafe[i][j]] = true;
					goAround(i, j);
				}
			}

			System.out.printf("#%d %d\n", testCase, answer);
		} // tc
	}

	static void goAround(int i, int j) {
		int[] di = { 1, 1, -1, -1 };
		int[] dj = { 1, -1, -1, 1 };
		int originLine = i + j;
		int count = 1;
		for (int dir = 0; dir < 4; dir++) {
			int side = 0;
			while (true) {
				if (dir == 2 && originLine == i + j) {
					dir = 3;
					break;
				}
				int ni = i + di[dir];
				int nj = j + dj[dir];

				if (ni >= N || nj >= N || ni < 0 || nj < 0 || dessert[cafe[ni][nj]]) {
					if (side == 0)
						return;
					break;
				}

				dessert[cafe[ni][nj]] = true;
				side++;
				count++;
			}
		}
		if (answer < count)
			answer = count;
	}

}
