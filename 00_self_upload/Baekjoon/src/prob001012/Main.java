package prob001012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] garden;
	static boolean[][] visited;
	static int answer;
	static int M;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			garden = new int[N][M];
			visited = new boolean[N][M];
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int j = Integer.parseInt(st.nextToken());
				int i = Integer.parseInt(st.nextToken());

				garden[i][j] = 1;
			}

			answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && garden[i][j] == 1) {
						DFS(i, j);
						answer++;
					}
				}
			}
			System.out.println(answer);

		} // tc
	}

	public static void DFS(int i, int j) {
		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] { i, j });

		while (!stack.isEmpty()) {
			int[] current = stack.pop();
			int ci = current[0];
			int cj = current[1];

			if (visited[ci][cj]) {
				continue;
			}

			visited[ci][cj] = true;

			for (int dir = 0; dir < 4; dir++) {
				int ni = ci + di[dir];
				int nj = cj + dj[dir];
				if (ni >= N || nj >= M || ni < 0 || nj < 0 || garden[ni][nj] == 0)
					continue;
				stack.push(new int[] { ni, nj });
			}
		}
	}
}
