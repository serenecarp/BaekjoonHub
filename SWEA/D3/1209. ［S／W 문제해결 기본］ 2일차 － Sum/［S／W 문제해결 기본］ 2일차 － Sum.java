
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt();
			int n = 100;
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int maxSum1 = Integer.MIN_VALUE;
			int maxSum2 = Integer.MIN_VALUE;

			int diag1Sum = 0;
			int diag2Sum = 0;
			int maxRowSum = 0;
			int maxColSum = 0;


			for (int i = 0; i < n; i++) {
				int rowSum = 0;
				int colSum = 0;
				
				for (int j = 0; j < n; j++) {

					rowSum += arr[i][j];
					colSum += arr[j][i];

				}
				maxRowSum = Math.max(maxRowSum, rowSum);
				maxColSum = Math.max(maxColSum, colSum);
				diag1Sum += arr[i][i];
				diag2Sum += arr[n - 1 - i][i];
			}
//			System.out.println(maxRowSum);
//			System.out.println(maxColSum);
//			System.out.println(diag1Sum);
//			System.out.println(diag2Sum);
			
			maxSum1 = Math.max(maxRowSum, maxColSum);
			maxSum2 = Math.max(diag1Sum, diag2Sum);
			int maxSum = Math.max(maxSum1, maxSum2);
			System.out.printf("#%d %d\n", test_case, maxSum);
		}
	}
}