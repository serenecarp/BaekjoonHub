package prob001949;

import java.util.Scanner;

public class Solution {
	static int N;
	static int K;
	static int[][] mountain;
	static boolean[][] visited;
	static int maxH;
	static int maxTrail;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 산 크기 N, 팔 수 있는 땅 한계 K
			N = sc.nextInt();
			K = sc.nextInt();
			// 산 정보, 방문배열
			mountain = new int[N][N];
			visited = new boolean[N][N];
			// 산의 가장 큰 봉우리 높이
			maxH = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int h = sc.nextInt();
					mountain[i][j] = h;
					if (maxH < h)
						maxH = h;
				}
			}

			// 등산로 최대길이 초기값 1
			maxTrail = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 산의 최대 높이에서 낮은 곳으로 탐색할 예정
					if (mountain[i][j] == maxH) {
						visited[i][j] = true;
						DFS(i, j, false, 1);
						visited[i][j] = false;
					}
				}
			}
			
			// 정답 출력
			System.out.printf("#%d %d\n", testCase, maxTrail);
		} // tc
	}

	// 산의 최대 높이에서 점점 낮은 쪽으로 DFS
	// 현재까지 땅을 판 적이 있는지를 알려주는 digged 변수.
	public static void DFS(int i, int j, boolean digged, int trail) {

		// 탐색중 경로의 길이가 최댓값을 넘었다면 갱신
		if (maxTrail < trail)
			maxTrail = trail;

		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		for (int dir = 0; dir < 4; dir++) {
			int ni = i + di[dir];
			int nj = j + dj[dir];
			// 탐색 범위가 산 바깥이면 continue
			if (ni >= N || nj >= N || ni < 0 || nj < 0 || visited[ni][nj])
				continue;
			
			// 현재 높이, 다음 갈 곳의 높이
			int now = mountain[i][j];
			int next = mountain[ni][nj];

			// 1. 만약 현재까지 땅을 판 적이 없고,
			// 2. 다음 땅이 지금 땅보다 높거나 같지만,
			// 3. 다음 땅을 파서 지금 땅보다 낮게 만들 수 있다면
			// 땅을 파고 다음 땅으로 진행한다. 단, 이제 땅을 팠으므로 digged = true
			if (!digged && next >= now && K >= next - (now - 1)) {
				visited[ni][nj] = true;
				mountain[ni][nj] = now - 1;
				DFS(ni, nj, true, trail + 1);
				visited[ni][nj] = false;
				mountain[ni][nj] = next;
			}

			// 만약 다음 땅이 지금보다 낮다면
			// 특별한 것 없이 바로 진행한다.
			else if (next < now) {
				visited[ni][nj] = true;
				DFS(ni, nj, digged, trail + 1);
				visited[ni][nj] = false;
			}
		}
	}
}
