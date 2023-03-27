
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

		if (N == 1 || N == 2 || N == 3) {
			System.out.println(dp[N]);
		} else {
			makeOne(4);
			System.out.println(dp[N]);
		}
	}

	static void makeOne(int k) {

		if (k == N + 1) {
			return;
		}

		dp[k] = dp[k - 1] + 1;

		if (k % 2 == 0) {
//			System.out.println("여기");
//			System.out.println(dp[k] + "와 " + (dp[k / 2] + 1) + " 중 최소");
			dp[k] = Math.min(dp[k], dp[k / 2] + 1);
		}
		if (k % 3 == 0) {
//			System.out.println("저기");
//			System.out.println(dp[k] + "와 " + (dp[k / 3] + 1) + " 중 최소");
			dp[k] = Math.min(dp[k], dp[k / 3] + 1);
		}
//		System.out.println("****");
		makeOne(k + 1);
	}
}
