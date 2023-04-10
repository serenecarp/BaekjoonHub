package prob005215;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
//	static final int tas = 0, cal = 1;
	static int N, L;
	static int[][] info, dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			L = sc.nextInt();
//			info = new int[N + 1][2];
			dp = new int[N + 1][L + 1];
			for (int i = 1; i <= N; i++) {
				int tas = sc.nextInt();
				int cal = sc.nextInt();
				// 칼로리(j)에서의 기존 최적해: dp[i-1][j]
				// i가 커지면서 추가된 재료로 dp[i-1][j-cal] + tas값이 최적이 될수도 아닐수도
				for (int j = 0; j <= L; j++) {
					if (cal > j)
						dp[i][j] = dp[i - 1][j];
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cal] + tas);
				}
			}
			int answer = 0;
			// 어쩔수없이 최대치 칼로리를 딱 못채웠을 수도 있어서 거꾸로 짚어가며 최댓값 찾아옴
			for (int i = L; i >= 0; i--) {
				if(dp[N][i] != 0) {
					answer = dp[N][i];
					break;
				}
			}
			System.out.printf("#%d %d\n", testCase, answer);

		} // tc
	}
}
