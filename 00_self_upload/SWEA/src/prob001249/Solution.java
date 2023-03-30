package prob001249;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] field;
	static int[][] timeTaken;
	static PriorityQueue<Road> way;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			// 인접행렬
			field = new int[N][N];

			// 인접행렬 정보 입력
			for (int i = 0; i < N; i++) {
				String row = sc.next();
				for (int j = 0; j < N; j++) {
					field[i][j] = row.charAt(j) - '0';
				}
			}

			Road start = new Road(0, 0, field[0][0]);
			dijkstra(start);

		} // tc
	}

	static void dijkstra(Road start) {
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;

		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 4방 델타
				for (int dir = 0; dir < 4; dir++) {
					int ni = i + di[dir];
					int nj = j + dj[dir];
					Road road = new Road(ni, nj, field[ni][nj]);

					if (ni >= N || nj >= N || ni < 0 || nj < 0) {
						continue;
					}
					way.add(road);

				}
			}
		}
	}
}

class Road implements Comparable<Road> {
	int i;
	int j;
	int depth;

	public Road(int i, int j, int depth) {
		this.i = i;
		this.j = j;
		this.depth = depth;
	}

	@Override
	public int compareTo(Road o) {
		return Integer.compare(this.depth, o.depth);
	}

}
