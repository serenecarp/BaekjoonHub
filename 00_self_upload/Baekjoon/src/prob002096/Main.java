package prob002096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arrMin, arrMax;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][3];
		arrMin = new int[N + 1][3];
		arrMax = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			arrMax[i][0] = Math.max(arrMax[i - 1][0], arrMax[i - 1][1]) + arr[i][0];
			arrMax[i][1] = Math.max(arrMax[i - 1][2], Math.max(arrMax[i - 1][0], arrMax[i - 1][1])) + arr[i][1];
			arrMax[i][2] = Math.max(arrMax[i - 1][1], arrMax[i - 1][2]) + arr[i][2];

			arrMin[i][0] = Math.min(arrMin[i - 1][0], arrMin[i - 1][1]) + arr[i][0];
			arrMin[i][1] = Math.min(arrMin[i - 1][2], Math.min(arrMin[i - 1][0], arrMin[i - 1][1])) + arr[i][1];
			arrMin[i][2] = Math.min(arrMin[i - 1][1], arrMin[i - 1][2]) + arr[i][2];
		}
		int realMax = Math.max(Math.max(arrMax[N][0], arrMax[N][1]), arrMax[N][2]);
		int realMin = Math.min(Math.min(arrMin[N][0], arrMin[N][1]), arrMin[N][2]);

		System.out.println(realMax + " " + realMin);
	}
}
