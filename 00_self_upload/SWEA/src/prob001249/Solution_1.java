package prob001249;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1 {
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] field;
	static boolean[][] visited;
	static int[][] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			field = new int[N][N];
			visited = new boolean[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				String row = sc.next();
				for (int j = 0; j < N; j++) {
					field[i][j] = row.charAt(j) - '0';
				}
			}

			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], INF);
			}
		} // tc
	}

	static void dijkstra(int i, int j) {
		dist[i][j] = 0;
		int[] di = { 1, 0, -1, 0 };
		int[] dj = { 0, 1, 0, -1 };

		for (int k = 0; k < N * N - 1; k++) {
			int min = INF;
			
			// 방문하지 않은 곳 중 dist가 가장 짧은 곳 선택
			
		}

	}
}
