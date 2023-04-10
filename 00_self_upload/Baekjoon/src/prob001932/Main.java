package prob001932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] pyramid;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		pyramid = new int[N][];
		int base = Integer.parseInt(br.readLine());
		// 피라미드 꼭대기
		pyramid[0] = new int[1];
		pyramid[0][0] = base;

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pyramid[i] = new int[i + 1];
			for (int j = 0; j < pyramid[i].length; j++) {
				int num = Integer.parseInt(st.nextToken());
				// 피라미드의 양쪽 끝은 따져줄 것 없이, 이전 라인의 가장자리에 값을 더해준다.
				if (j == 0)
					pyramid[i][j] = pyramid[i - 1][0] + num;
				else if (j == pyramid[i].length - 1)
					pyramid[i][j] = pyramid[i - 1][pyramid[i - 1].length - 1] + num;
				// 이전 라인의 양쪽 값 중 더 큰 값과 더해줌
				else {
					pyramid[i][j] = Math.max(pyramid[i - 1][j - 1], pyramid[i - 1][j]) + num;
				}
			}
		}
		// 최댓값 출력
		int maxVal = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (maxVal < pyramid[N - 1][i])
				maxVal = pyramid[N - 1][i];
		}
		System.out.println(maxVal);
	}
}
