package prob002001;

import java.util.Scanner;

class Solution2001 {
	public static void main(String args[]) throws Exception {

		// 1. 파리 개수(2차원 배열)와 파리채 크기를 입력받는다.
		// 2. 파리채 크기만큼 파리 배열을 적당히 덜 순회하면서,
		// 3. 파리채 델타로 파리채 영역 내 파리 수를 구한다.
		// 4. 그 중 최댓값을 출력한다.

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 파리 수, 파리채 크기 입력
			int[][] fly = new int[N][N];
			int[] flapper = new int[M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					fly[i][j] = sc.nextInt();
				}
			}
			// 파리채라는 이름의 델타 (0, 1, 2, .. , M-1)
			for (int i = 0; i < M; i++) {
				flapper[i] = i;
			}

			// 잡을 수 있는 파리의 최댓값 변수
			int maxKill = 0;

			// 파리를 잡자
			// 지정 index로부터 (오른쪽, 아래)로 파리채 크기만큼 확장해서
			// 그 영역 내 파리의 수를 합해서
			// maxKill보다 크면 갱신
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int killable = 0;
					// 파리채 델타를 배열 한개로 때우기
					// 0 ~ (M*M-1)로 수를 증가시키며
					// 가로 방향은 그 수를 M으로 나눈 나머지 (0 1 2 0 1 2 0 1 2 ..)
					// 세로 방향은 그 수를 M으로 나눈 몫 (0 0 0 1 1 1 2 2 2 ..)
					for (int k = 0; k < M * M; k++) {
						int newJ = j + flapper[k % M];
						int newI = i + flapper[k / M];
						killable += fly[newI][newJ];
					}

					// 더 크면 max값 갱신
					if (maxKill < killable) {
						maxKill = killable;
					}
				}
			}
			// 정답 출력
			System.out.printf("#%d %d\n", test_case, maxKill);
		}
	}
}