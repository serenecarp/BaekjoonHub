package prob001249;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] field;
	static int[][] timeTaken;
	static boolean[][] visited;
	static PriorityQueue<Road> way;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			// 인접행렬
			field = new int[N][N];
			visited = new boolean[N][N];

			// 인접행렬 정보 입력
			for (int i = 0; i < N; i++) {
				String row = sc.next();
				for (int j = 0; j < N; j++) {
					field[i][j] = row.charAt(j) - '0';
				}
			}

			// 해당 좌표까지 도달하는 데 걸리는 시간, 무한대로 초기화
			for (int i = 0; i < N; i++) {
				Arrays.fill(timeTaken[i], INF);
			}

			Road start = new Road(0, 0, field[0][0]);
			dijkstra(start);

		} // tc
	}

	static void dijkstra(Road start) {

		visited[start.i][start.j] = true;
		timeTaken[start.i][start.j] = 0;

		addPq(start);
		Road currRoad = start;

		while (true) {
			Road nextRoad = way.poll();
			visited[nextRoad.i][nextRoad.j] = true;
			timeTaken[nextRoad.i][nextRoad.j] = timeTaken[currRoad.i][currRoad.j] + nextRoad.depth;
			currRoad = nextRoad;
		}

	}

	static void addPq(Road currRoad) {
		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };
		for (int dir = 0; dir < 4; dir++) {
			int ni = currRoad.i + di[dir];
			int nj = currRoad.j + dj[dir];

			if (ni >= N || nj >= N || ni < 0 || nj < 0 || visited[ni][nj]) {
				continue;
			}
			Road newRoad = new Road(ni, nj, field[ni][nj]);
			way.add(newRoad);

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
