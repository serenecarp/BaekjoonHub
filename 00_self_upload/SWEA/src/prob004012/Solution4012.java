package prob004012;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4012 {
	static int[][] synergy;
	static int minTasDiff;
	static int N;
	static int[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			synergy = new int[N][N];
			minTasDiff = Integer.MAX_VALUE;
			selected = new int[N / 2];
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					synergy[i][j] = sc.nextInt();
//				}
//			}
			combination(0, 0);
		}
	}

	static void combination(int selectdx, int ingredx) {
		// base case
		if (ingredx == N / 2) {
			System.out.println(Arrays.toString(selected));
			return;
		}

		// recursion case
		for (int i = ingredx; i <= N - (N / 2) + selectdx; i++) {
			selected[selectdx] = i;
			combination(selectdx + 1, ingredx + 1);
		}
	}
}
