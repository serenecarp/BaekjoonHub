package prob004613;

import java.util.Scanner;

class Solution4613 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 깃발 높이, 폭
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 초기 색깔 입력
			char[][] russianFlag = new char[N][M];
			for (int i = 0; i < N; i++) {
				russianFlag[i] = sc.next().toCharArray();
			}

			// 각 줄에 w, b, r의 분포 파악
			// => 각 줄을 해당 색으로 칠한다고 할 때 추가해야 할 해당 색의 수
			int[][] colorCount = new int[N][3];
			for (int i = 0; i < N; i++) {
				int w = 0;
				int b = 0;
				int r = 0;
				for (int j = 0; j < M; j++) {
					if (russianFlag[i][j] == 'W') {
						w++;
					} else if (russianFlag[i][j] == 'B') {
						b++;
					} else {
						r++;
					}
				}
				// 0: White // 1: Blue // 2: Red
				colorCount[i][0] = M - w;
				colorCount[i][1] = M - b;
				colorCount[i][2] = M - r;
			}

			// 줄 i까지 해당 색을 칠한다고 했을 때
			// 칠해야 하는 누적 칸 수 (white, red)
			int[] totW = new int[N];
			int[] totR = new int[N];
			totW[0] = colorCount[0][0];
			for (int i = 1; i < N - 1; i++) {
				totW[i] = totW[i - 1] + colorCount[i][0];
			}
			totR[N - 1] = colorCount[N - 1][2];
			for (int i = N - 2; i >= 1; i--) {
				totR[i] += totR[i + 1] + colorCount[i][2];
			}

			// i번째 한 줄을 b로 칠한다고 가정
			// 초기값: b 없이 i번째 전까지 w로 칠하고, i번째부터 끝까지 r로 칠했을 때
			// 변화: i에서 b줄의 두께를 1부터 끝-1까지 늘림(j)
			// - 위 변화에 따라 늘어나는 b와 줄어드는 r을 계산 후 최솟값 갱신
			int answer = Integer.MAX_VALUE;
			int totColor = 0;
			for (int i = 1; i < N - 1; i++) {
				totColor = totW[i - 1] +totR[i];
				for (int j = i; j < N - 1; j++) {
					totColor += colorCount[j][1] - colorCount[j][2];
					if (answer > totColor) {
						answer = totColor;
					}
				}
			}
			// 최종 최솟값 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}