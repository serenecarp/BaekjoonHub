
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H;
	static int N;
	static int M;
	static int[][][] box;
	static boolean[][][] visited;
	static int[][][] day;

	static Queue<int[]> queue;
	static int totZero;

	static int maxDay;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		visited = new boolean[H][N][M];
		day = new int[H][N][M];
		totZero = 0;
		queue = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int tom = Integer.parseInt(st.nextToken());
					if (tom == 0)
						totZero++;
					if (tom == 1) {
						int[] ripen = { h, i, j };
						queue.add(ripen);
						visited[h][i][j] = true;
					}
					box[h][i][j] = tom;
				}
			}
		}
		maxDay = 0;
		BFS();
//		print();
		if (totZero != 0)
			maxDay = -1;
		System.out.println(maxDay);

	}

	static void BFS() {
		int[] dh = { -1, 0, 0, 0, 0, 1 };
		int[] di = { 0, -1, 1, 0, 0, 0 };
		int[] dj = { 0, 0, 0, -1, 1, 0 };
		while (!queue.isEmpty()) {
			int[] ripen = queue.poll();
			int h = ripen[0];
			int i = ripen[1];
			int j = ripen[2];
			for (int dir = 0; dir < 6; dir++) {
				int nh = h + dh[dir];
				int ni = i + di[dir];
				int nj = j + dj[dir];
				if (nh >= H || ni >= N || nj >= M || nh < 0 || ni < 0 || nj < 0 || visited[nh][ni][nj]
						|| box[nh][ni][nj] == -1)
					continue;
				visited[nh][ni][nj] = true;
				box[nh][ni][nj] = 1;
				int[] next = { nh, ni, nj };
				queue.offer(next);
				day[nh][ni][nj] = day[h][i][j] + 1;
				maxDay = day[nh][ni][nj];
				totZero--;
			}
		}
	}

	static void print() {
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(day[h][i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
