package prob001209;

import java.util.Scanner;

class Solution1209 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt();
			int n = 100;
			// 배열 입력 받기
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 가로세로 최강자 중 진짜 최강자
			int maxSum1 = 0;
			// 대각선 합 중 최강자
			int maxSum2 = 0;

			// 대각선1, 대각선2, 가로최강, 세로최강
			int diag1Sum = 0;
			int diag2Sum = 0;
			int maxRowSum = 0;
			int maxColSum = 0;

			// 누가 최강인가
			for (int i = 0; i < n; i++) {
				int rowSum = 0;
				int colSum = 0;
				// 가로 최강자, 세로 최강자 결정전
				for (int j = 0; j < n; j++) {
					rowSum += arr[i][j];
					colSum += arr[j][i];

				}
				// 가로 최강자, 세로 최강자 계속 갱신
				maxRowSum = Math.max(maxRowSum, rowSum);
				maxColSum = Math.max(maxColSum, colSum);

				// 대각선1, 대각선2 합 구하기
				diag1Sum += arr[i][i];
				diag2Sum += arr[n - 1 - i][i];
			}

			// 가로최강자 vs. 세로최강자
			maxSum1 = Math.max(maxRowSum, maxColSum);
			// 대각선1 vs. 대각선2
			maxSum2 = Math.max(diag1Sum, diag2Sum);
			// 결승전
			int maxSum = Math.max(maxSum1, maxSum2);
			// 출력
			System.out.printf("#%d %d\n", test_case, maxSum);
		}
	}
}