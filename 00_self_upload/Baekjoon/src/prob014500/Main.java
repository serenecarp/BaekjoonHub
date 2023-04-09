package prob014500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, maxCnt;
	static int[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		maxCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
//					System.out.println("시작" + i + " " + j);
				visited[i][j] = true;
				DFS(i, j, 1, board[i][j]);
				visited[i][j] = false;

			}
		}
		System.out.println(maxCnt);
	}

	static void DFS(int i, int j, int depth, int score) {
		// base
		if (depth == 4) {
			if (score > maxCnt)
				maxCnt = score;
			return;
		}

		// recur
		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };
		for (int dir = 0; dir < 4; dir++) {
			int ni = i + di[dir];
			int nj = j + dj[dir];
			if (ni >= N || nj >= M || ni < 0 || nj < 0 || visited[ni][nj])
				continue;
//			System.out.println(ni + " " + nj + " " + board[ni][nj] + " " + depth + " " + score);
			if(depth == 2) {
				visited[ni][nj] = true;
				DFS(i, j, depth + 1, score + board[ni][nj]);
				visited[ni][nj] = false;
			}
			visited[ni][nj] = true;
			DFS(ni, nj, depth + 1, score + board[ni][nj]);
			visited[ni][nj] = false;

		}
	}

//	static void exceptCase(int i, int j) {
//		int val = board[i][j];
//		int[] di = { 0, 1, 0, -1 };
//		int[] dj = { 1, 0, -1, 0 };
//		for (int dir = 0; dir < 4; dir++) {
//			int ni = i + di[dir];
//			int nj = j + dj[dir];
//			if (ni >= N || nj >= M || ni < 0 || nj < 0)
//				continue;
//			val += board[ni][nj];
//		}
//		for (int dir = 0; dir < 4; dir++) {
//			int ni = i + di[dir];
//			int nj = j + dj[dir];
//			if (ni >= N || nj >= M || ni < 0 || nj < 0)
//				continue;
//			val -= board[ni][nj];
//			if (val > maxCnt)
//				maxCnt = val;
//			val += board[ni][nj];
//		}
//	}
}
