
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
	static int[][] box;
	static boolean[][] visited;
	static int[][] day;

	static Queue<int[]> queue;
	static int tomLeft;

	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		visited = new boolean[N][M];
		day = new int[N][M];

		tomLeft = 0;
		queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				box[i][j] = tmp;
				switch (tmp) {
				case 0:
					tomLeft++;
					break;
				case 1:
					int[] tomRipe = { i, j };
					queue.offer(tomRipe);
					visited[i][j] = true;
				}
			}
		}
		answer = 0;
		BFS();
		answer = dayCheck();
		if (tomLeft != 0)
			answer = -1;
		
		System.out.println(answer);
	}

	static void BFS() {

		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		while (!queue.isEmpty()) {

			if (tomLeft == 0)
				break;

			int[] tomRipe = queue.poll();
			int i = tomRipe[0];
			int j = tomRipe[1];

			for (int dir = 0; dir < 4; dir++) {
				int ni = i + di[dir];
				int nj = j + dj[dir];

				if (ni >= N || nj >= M || ni < 0 || nj < 0 || visited[ni][nj] || box[ni][nj] == -1)
					continue;

				int[] tomNext = { ni, nj };
				queue.offer(tomNext);
				visited[ni][nj] = true;
				day[ni][nj] = day[i][j] + 1;

				tomLeft--;
			}
		}
	}

	static int dayCheck() {
		int maxDay = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (day[i][j] > maxDay)
					maxDay = day[i][j];
			}
		}
		return maxDay;
	}
}
