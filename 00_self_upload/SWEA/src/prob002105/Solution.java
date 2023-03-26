package prob002105;

import java.util.Scanner;

public class Solution {
	static int[][] cafe;
	static boolean[][] visited;
	static int[] dessert;
	static int N;

	static int maxD;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {

			N = sc.nextInt();
			cafe = new int[N][N];
			visited = new boolean[N][N];

			maxD = -1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cafe[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) {
						continue;
					}
					System.out.println("현재 조사중: " + i + " " + j);

					dessert = new int[101];

					goAround(i, j);
				}
			}

			System.out.println(maxD);

		} // tc
	}

	static void goAround(int i, int j) {
		int[] di = { 1, 1, -1, -1 };
		int[] dj = { 1, -1, -1, 1 };
		int dir = 0;

		// 현재까지 디저트 종류
		int kindOfD = 0;

		int ni = i;
		int nj = j;

		int count = 0;
		boolean flag = true;
		while (flag) {

			System.out.println("돌아요 " + cafe[ni][nj] + "[" + ni + ", " + nj + "]");

			// 처음으로 돌아왔으면 종료
			if (ni == i && nj == j) {
				break;
			}
			// 다음칸이 범위 밖이거나, 중복된 디저트일 경우 방향전환
			if (ni >= N || nj >= N || ni < 0 || ni < 0 || dessert[cafe[ni][nj]] != 0) {
				// 한 칸도 안갔는데 count 0이면 변이 없다는 것이므로 break;
				if (!flag) {
					System.out.println(" 다음으로 갑시다");
					break;
				}
				// 방향전환하면 변의 길이 새로 측정
				ni -= di[dir];
				nj -= di[dir];
				dir++;
				count = 0;
			}
			count++;
			// 다음 칸으로 이동
			ni += di[dir];
			nj += dj[dir];
			
			kindOfD++;
			dessert[cafe[ni][nj]]++;
			visited[ni][nj] = true;
		}

		if (kindOfD > maxD) {
			maxD = kindOfD;
		}
	}
}
