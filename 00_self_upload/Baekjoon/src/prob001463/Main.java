package prob001463;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] dp;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dp = new int[1000001];

		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;

		N = sc.nextInt();

		// 기본 베이스인 1, 2, 3이면 바로 출력
		if (N == 1 || N == 2 || N == 3) {
			System.out.println(dp[N]);	
		}
		// 4 이상이면 4부터 N까지 하나하나 다 만들어가며 dp[N]을 계산
		else {
			makeOne(4);
			System.out.println(dp[N]);
		}
	}

	static void makeOne(int k) {

		if (k == N + 1) {
			return;
		}

		// 일단 이전꺼에 1 더한 걸 기본 베이스로 하되
		dp[k] = dp[k - 1] + 1;

		// 숫자가 2의 배수면
		// 2로 나눈 값에 2만 곱하면 되므로, +1
		if (k % 2 == 0) {
			dp[k] = Math.min(dp[k], dp[k / 2] + 1);
		}
		// 숫자가 3의 배수면
		// 3으로 나눈 값에 3만 곱하면 되므로, +1
		if (k % 3 == 0) {
			dp[k] = Math.min(dp[k], dp[k / 3] + 1);
		}
		// 다음 숫자 고려
		makeOne(k + 1);
	}
}
