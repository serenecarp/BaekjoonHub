
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] maze, dist;
	static boolean[][] visited;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {

				maze[i][j] = line.charAt(j) - '0';

			}
		}
		queue = new LinkedList<>();
		int[] s = { 0, 0 };
		queue.offer(s);
		visited[0][0] = true;
		dist[0][0] = 1;
		BFS();
		System.out.println(dist[N - 1][M - 1]);
	}

	static void BFS() {
		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int i = now[0];
			int j = now[1];
			for (int dir = 0; dir < 4; dir++) {
				int ni = i + di[dir];
				int nj = j + dj[dir];
				if (ni >= N || nj >= M || ni < 0 || nj < 0 || visited[ni][nj] || maze[ni][nj] == 0)
					continue;
				int[] next = { ni, nj };
				visited[ni][nj] = true;
				queue.offer(next);
				dist[ni][nj] = dist[i][j] + 1;

			}
		}
	}
}
