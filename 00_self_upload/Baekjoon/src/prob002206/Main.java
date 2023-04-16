package prob002206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] board, dist;
	static boolean[][] visited;

	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				int x = line.charAt(j) - '0';
				board[i][j] = x;
			}
		}
		int[] start = { 0, 0 };
		queue.add(start);
		BFS();
		if (dist[N - 1][M - 1] == 0)
			System.out.println(-1);
		else
			System.out.println(dist[N - 1][M - 1]);
	}

	private static void BFS() {
		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		dist[0][0] = 1;
		visited[0][0] = true;

		boolean broke = false;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int i = now[0];
			int j = now[1];

			for (int dir = 0; dir < 4; dir++) {
				int ni = i + di[dir];
				int nj = j + dj[dir];
				if (ni >= N || nj >= M || ni < 0 || nj < 0 || visited[ni][nj])
					continue;

				int[] next = { ni, nj };
				if (board[ni][nj] == 0) {
					System.out.println("방문함  " + ni + " " + nj);
					visited[ni][nj] = true;
					dist[ni][nj] = dist[i][j] + 1;
					queue.offer(next);
				} else {
					if (!broke) {
						System.out.println("벽 부숨 " + ni + " " + nj);
						visited[ni][nj] = true;
						dist[ni][nj] = dist[i][j] + 1;
						broke = true;
						queue.offer(next);
					}
				}
			}
		}
	}
}
