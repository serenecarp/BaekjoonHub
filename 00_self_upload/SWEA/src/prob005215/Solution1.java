package prob005215;

import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 재료 개수, 제한 칼로리
			int N = sc.nextInt();
			int limCal = sc.nextInt();

			// 햄버거 재료 정보를 담은 배열, [0]에 맛, [1]에 칼로리
			int[][] ingred = new int[N][2];
			int tas = 0;
			int cal = 1;
			for (int i = 0; i < N; i++) {
				ingred[i][tas] = sc.nextInt();
				ingred[i][cal] = sc.nextInt();
			}
			// 맛점수의 최댓값
			int maxTas = Integer.MIN_VALUE;

			// 모든 경우의 수(부분집합의 수)를 고려하기
			for (int i = 0; i < (1 << N); i++) {
				int myTas = 0;
				int myCal = 0;
				boolean ok = true;
				for (int j = 0; j < N; j++) {
					// 해당 경우의 수에서 맛의 총합과 칼로리의 총합을 구한다.
					// 칼로리의 총합이 넘어갈 경우 break, 해당 경우는 따져주지 않는다.
					// 맛의 총합이 maxTas보다 크면 갱신한다.
					if ((i & (1 << j)) != 0) {
						myTas += ingred[j][tas];
						myCal += ingred[j][cal];
					}

					if (myCal > limCal) {
						ok = false;
						break;
					}
				}

				if (ok && maxTas < myTas) {
					maxTas = myTas;
				}
			}
			System.out.printf("#%d %d\n", testCase, maxTas);

		} // tc
	}
}
