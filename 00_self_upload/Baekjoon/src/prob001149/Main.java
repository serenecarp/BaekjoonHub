package prob001149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int R = 0, G = 1, B = 2;
	static int[][] costRGB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		costRGB = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int costR = Integer.parseInt(st.nextToken());
			int costG = Integer.parseInt(st.nextToken());
			int costB = Integer.parseInt(st.nextToken());

			// i번쨰를 R/G/B로 칠했을 때, 이전에 칠한 색에 따라 dynamic programming
			costRGB[i][R] = Math.min(costRGB[i - 1][G], costRGB[i - 1][B]) + costR;
			costRGB[i][G] = Math.min(costRGB[i - 1][B], costRGB[i - 1][R]) + costG;
			costRGB[i][B] = Math.min(costRGB[i - 1][R], costRGB[i - 1][G]) + costB;

		}
		
		int costMin = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			if(costRGB[N][i] < costMin)
				costMin = costRGB[N][i];
		}
		
		System.out.println(costMin);
	}

}
