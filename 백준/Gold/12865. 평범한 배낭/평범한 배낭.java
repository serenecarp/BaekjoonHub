
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int limW = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][limW + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= limW; j++) {
				if (j >= w)
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		int maxVal = 0;
		for (int i = 1; i <= limW; i++) {
			if (maxVal < dp[N][i])
				maxVal = dp[N][i];
		}
		System.out.println(maxVal);
	}
}
