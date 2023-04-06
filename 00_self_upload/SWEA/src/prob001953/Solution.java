package prob001953;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	static int timeLim;
	static int[][] under;
	static boolean[][] visited;
	static int[][] timeTaken;
	static Queue<int[]> queue;

	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 지하도 세로, 가로
			N = sc.nextInt();
			M = sc.nextInt();
			// 지하도 정보 배열, 방문확인 배열, 해당 좌표까지 걸린 시간 배열
			under = new int[N][M];
			visited = new boolean[N][M];
			timeTaken = new int[N][M];
			// 탈주범의 시작지점
			int si = sc.nextInt();
			int sj = sc.nextInt();
			// 탈출 후 소요 시간
			timeLim = sc.nextInt();
			// 지하도 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					under[i][j] = sc.nextInt();
				}
			}

			// BFS 시작
			queue = new LinkedList<>();
			answer = 1;
			BFS(si, sj);

			System.out.printf("#%d %d\n", testCase, answer);
		} // tc
	}

	static void BFS(int si, int sj) {
		// 탈주범 시작지점을 queue에 삽입
		int[] st = { si, sj };
		queue.offer(st);
		visited[si][sj] = true;
		timeTaken[si][sj] = 1;

		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		// 큐가 빌 때까지 BFS 실행
		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			int i = curr[0];
			int j = curr[1];
			// 만약 시간이 다 됐다면 멈추기
			if (timeTaken[i][j] == timeLim)
				return;

			// 탐색 시작
			for (int dir = 0; dir < 4; dir++) {
				int ni = i + di[dir];
				int nj = j + dj[dir];

				// 범위 밖이거나, 터널이 없거나, 이미 방문한 곳이면 continue
				if (ni >= N || nj >= M || ni < 0 || nj < 0 || under[ni][nj] == 0 || visited[ni][nj])
					continue;

				// 현재 지점, 다음 이동할 지점
				int now = under[i][j];
				int next = under[ni][nj];
				// 갈 수 있는 곳이면 간다.
				if (goodFrom(dir, now) && goodTo(dir, next)) {
					int[] go = { ni, nj };
					queue.offer(go);
					visited[ni][nj] = true;

					// 탈주범 영역++
					answer++;

					// 걸린 시간 (== 시작점으로부터의 거리) +1
					timeTaken[ni][nj] = timeTaken[i][j] + 1;

				}
			}

		}
	}

	// 현재 지점의 터널모양 now에서 dir방향으로 간다고 할 때
	// 갈 수 있는지 여부
	static boolean goodFrom(int dir, int now) {
		switch (dir) {
		case 0:
			if (now == 2 || now == 6 || now == 7)
				return false;
			break;
		case 1:
			if (now == 3 || now == 4 || now == 7)
				return false;
			break;
		case 2:
			if (now == 2 || now == 4 || now == 5)
				return false;
			break;
		case 3:
			if (now == 3 || now == 5 || now == 6)
				return false;
			break;
		}
		return true;
	}

	// dir방향으로 다음 지점의 터널모양 next로 간다고 할 때
	// 갈 수 있는지 여부
	static boolean goodTo(int dir, int next) {
		switch (dir) {
		case 0:
			if (next == 2 || next == 4 || next == 5)
				return false;
			break;
		case 1:
			if (next == 3 || next == 5 || next == 6)
				return false;
			break;
		case 2:
			if (next == 2 || next == 6 || next == 7)
				return false;
			break;
		case 3:
			if (next == 3 || next == 4 || next == 7)
				return false;
			break;
		}
		return true;
	}
}
