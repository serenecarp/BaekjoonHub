package prob007576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		// 백준 풀 때는 BufferedReader를 주로 사용한다..
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로, 세로
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// 토마토박스 정보 배열, 방문배열, 경과 일수 배열
		box = new int[N][M];
		visited = new boolean[N][M];
		day = new int[N][M];
		// 남은 안익은 토마토의 개수: 마지막에 -1을 출력할지 말지 판별
		tomLeft = 0;
		// BFS용 큐
		queue = new LinkedList<>();

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				box[i][j] = tmp;
				switch (tmp) {
				// 0의 개수++
				case 0:
					tomLeft++;
					break;
				// 1을 우선 queue에 저장
				case 1:
					int[] tomRipe = { i, j };
					queue.offer(tomRipe);
					visited[i][j] = true;
				}
			}
		}
		// BFS 실행
		answer = 0;
		BFS();
		answer = dayCheck();
		// 토마토가 다 익지 않았다면 -1을 출력
		if (tomLeft != 0)
			answer = -1;

		// 정답 출력
		System.out.println(answer);
	}

	// 1의 좌표들에서 BFS를 실행
	static void BFS() {

		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		// 큐가 빌 때까지
		while (!queue.isEmpty()) {

			// 토마토 다 익혔으면 break - 이거 안해도 될듯
			if (tomLeft == 0)
				break;

			int[] tomRipe = queue.poll();
			int i = tomRipe[0];
			int j = tomRipe[1];

			for (int dir = 0; dir < 4; dir++) {
				int ni = i + di[dir];
				int nj = j + dj[dir];

				// 범위 밖이거나, 이미 방문했거나, -1이면 continue
				if (ni >= N || nj >= M || ni < 0 || nj < 0 || visited[ni][nj] || box[ni][nj] == -1)
					continue;

				// 다음 토마토를 방문한다. queue에 삽입.
				int[] tomNext = { ni, nj };
				queue.offer(tomNext);
				visited[ni][nj] = true;
				day[ni][nj] = day[i][j] + 1;

				// 남은 토마토 개수 --
				tomLeft--;
			}
		}
	}

	// 경과한 일수 최댓값을 판별 (이거 위에서 잘~했으면 없어도 됐겠다.)
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
