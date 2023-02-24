package prob002805;

import java.util.Scanner;

class Solution2805 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			char[][] crop = new char[N][N];
			// 농작물 입력
			for (int i = 0; i < N; i++) {
				crop[i] = sc.next().toCharArray();
			}
			// 별 찍기 느낌으로..
			// i좌표 + j좌표 합에 따라 더하지 않는 조건 추가
			// 위에서 걸러지지 않은 애들만 더하기
			int cropSum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i + j < N / 2 || (N - 1 - i) + (N - 1 - j) < N / 2 || (N - 1 - i) + j < N / 2
							|| i + (N - 1 - j) < N / 2) {
						continue;
					}

					cropSum += crop[i][j] - '0';
				}
			}

			System.out.printf("#%d %d\n", test_case, cropSum);
		}
	}
}