package prob009465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] sticker, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			sticker = new int[2][N];
			dp = new int[2][N];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					dp[i][j] = sticker[i][j];
				}
			}
			dp[0][1] = dp[1][0] + dp[0][1];
			dp[1][1] = dp[0][0] + dp[1][1];

			for (int j = 2; j < N; j++) {
				dp[0][j] = Math.max(sticker[1][j - 1], sticker[1][j - 2]) + sticker[0][j];
				dp[1][j] = Math.max(sticker[0][j - 1], sticker[0][j - 2]) + sticker[1][j];
			}
			System.out.println(Arrays.deepToString(sticker));
			System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
		} // tc
	}
}
