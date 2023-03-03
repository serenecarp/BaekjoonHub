package prob001767;

import java.util.Scanner;

public class Solution1767 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[][] mexinos = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mexinos[i][j] = sc.nextInt();
				}
			}

			int lenSum = 0;
			int ccwSum = 0;
			int cwSum = 0;
			for (int lv = 1; lv <= (N - 1) / 2; lv++) {
				// 뭔가 잘못된 경우 반시계방향으로 돌리겠다.
				boolean ccw = true;
				boolean cw = true;
				outLoop: for (int j = lv; j <= N - 2 - lv; j++) {

					int count = 0;
					if (mexinos[lv][j] == 1) {

						// 시계방향으로 검색 중에, 앞서 뭐가 이미 나온 적 있다면
						// 수틀릴 때 반시계로는 돌리지 못한다는 뜻
						count++;
						if (count >= 2) {
							ccw = false;
						}

						int ni = lv;
						while (ni >= 0) {
							ni--;
							if (mexinos[ni][j] == 1) {
								cwSum += N - j - 1;
								ccwSum += j;
								break outLoop;
							}
						}

						// 안만났으면 그대로 연결
						lenSum += lv;

					}
				}

				outLoop: for (int i = lv; i <= N - 2 - lv; i++) {
					int count = 0;

					if (mexinos[i][N - 1 - lv] == 1) {
						// 시계방향으로 검색 중에, 앞서 뭐가 이미 나온 적 있다면
						// 수틀릴 때 반시계로는 돌리지 못한다는 뜻
						count++;
						if (count >= 2) {
							ccw = false;
						}

						int nj = N - 1 - lv;
						while (nj < N) {
							nj++;
							if (mexinos[i][nj] == 1) {
								cwSum += N - i - 1;
								ccwSum += i;
								break outLoop;

							}
						}

						// 안만났으면 그대로 연결
						lenSum += lv;
					}
				}

				outLoop: for (int j = N - 1 - lv; j >= lv + 1; j--) {
					int count = 0;

					if (mexinos[N - 1 - lv][j] == 1) {
						// 시계방향으로 검색 중에, 앞서 뭐가 이미 나온 적 있다면
						// 수틀릴 때 반시계로는 돌리지 못한다는 뜻
						count++;
						if (count >= 2) {
							ccw = false;
						}

						int ni = N - 1 - lv;
						while (ni < N) {
							ni++;
							if (mexinos[ni][j] == 1) {
								cwSum += j;
								ccwSum += N - j - 1;
								break outLoop;

							}
						}
						// 안만났으면 그대로 연결
						lenSum += lv;
					}
				}

				outLoop: for (int i = N - 1 - lv; i >= lv + 1; i--) {
					int count = 0;

					if (mexinos[i][lv] == 1) {
						// 시계방향으로 검색 중에, 앞서 뭐가 이미 나온 적 있다면
						// 수틀릴 때 반시계로는 돌리지 못한다는 뜻
						count++;
						if (count >= 2) {
							ccw = false;
						}
						int nj = lv;
						while (nj >= 0) {
							nj--;
							if (mexinos[i][nj] == 1) {
								cwSum += i;
								ccwSum += N - i - 1;
								break outLoop;

							}
						}
						// 안만났으면 그대로 연결
						lenSum += lv;
						if(ccw) {
							lenSum += ccwSum;
						} else if(!ccw && cw) {
							lenSum += cwSum;
						} else if(!ccw && !cw) {
							
						}
					}
				}

				System.out.println(lenSum);

			}

			System.out.println(lenSum);
		}
	}
}
