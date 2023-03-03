package prob004613;

import java.util.Scanner;

// 이승재 교수님 풀이
// 재귀

public class Solution4613_recur {
	static char[][] map;
	static int N, M, min;
	static char[] colors; // 재귀적으로 선택된 행별 색깔을 담을 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			M = sc.nextInt();

			map = new char[N][M];
			colors = new char[N]; // 행의 정보만 가지면 되므로.

			for (int r = 0; r < N; r++) {
				String str = sc.next();
				char[] arr = str.toCharArray();
				for (int c = 0; c < M; c++) {
					map[r][c] = arr[c];
				}
			}
			min = Integer.MAX_VALUE; // 최솟값 초기화
			// select 재귀적으로 행의 색깔을 선택하는 함수
			// 각 선택은 이전 색깔의 영향을 받음
			// select(i): i번째 행의 색을 선택 ... (x)
			// =>i번째 행의 선택은 i-1번째 행의 색깔에 의존.
			// select(i, prevColor): i-1번째 색이 prevColor일 때, i번째 행의 색을 선택
			select(1, 'W');
			// 0번 행은 어차피 W
			for (int j = 0; j < M; j++) {
				if (map[0][j] != 'W') {
					min++;
				}

				// N-2번 행은 어차피 R
				if (map[N - 1][j] != 'R') {
					min++;
				}
			}
		}
	}

	private static void select(int idx, char c) {
		// 기저 조건
		if (idx == N - 1) { // N-2까지는 선택을 하고, N-2일 때 멈춤
			int colorCnt = 0;

			for (int i = 1; i < N - 1; i++) {
				int cnt = 0;
				for (int j = 0; j < M; j++) {
					if (map[i][j] != colors[i])
						cnt++;
				}
				colorCnt += cnt;
			}
			min = (min > colorCnt) ? colorCnt : min;
			return;
		}

		// i가 N-2번째를 선택하려고 했는데..
		// N-3번째 색이 'W'였으면.. => N-2번째는 무조건 'B'가 되도록 선택
		if (idx == N - 2 && c == 'W') {
			colors[idx] = 'B';
			select(idx + 1, 'B');
			return;
		}

		// 유도 조건
		if (c == 'W') {
			colors[idx] = 'W';
			select(idx + 1, 'W');
			colors[idx] = 'B';
			select(idx + 1, 'B');
		} else if (c == 'B') {
			colors[idx] = 'B';
			select(idx + 1, 'B');
			colors[idx] = 'R';
			select(idx + 1, 'R');
		} else {
			colors[idx] = 'R';
			select(idx + 1, 'R');
		}
	}
}
