package prob001486;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 인원수, 목표 높이 입력
			int N = sc.nextInt();
			int goalH = sc.nextInt();

			// 인원들 키 입력
			int[] height = new int[N];
			for (int i = 0; i < N; i++) {
				height[i] = sc.nextInt();
			}
			// 다합친 키의 최솟값을 구하기

			int minH = Integer.MAX_VALUE;

			// 모든 경우를 다 따지겠다
			// 해당 직원을 넣을지 말지를 모두 고려
			for (int i = 0; i < (1 << N); i++) {
				int sumH = 0;
				for (int j = 0; j < N; j++) {
					// 해당 케이스에서
					// j 직원이 포함되어있다면, 그 직원의 키를 더한다.
					if ((i & (1 << j)) != 0) {
						sumH += height[j];
					}
					// 현재 고려중인 경우의 sumH가 지나치게 커져서
					// minH보다 커지면 종료, 다음 케이스로
					if (sumH >= minH) {
						break;
					}
					// minH보다 작으면 갱신한다는 조건은 사실상
					// 이미 위에서 break로 걸러줬으므로 없어도 될듯.
					if (sumH >= goalH) {
						minH = sumH;
					}
				}
			}

			// 최솟값과 목푯값의 차이를 출력
			System.out.printf("#%d %d\n", testCase, minH - goalH);
		} // tc
	}

//	백트래킹 재귀함수 => 시간초과!!
//	public static void backTrack(int sumH) {
//
//		// base
//		// 목표 키를 넘은 것 중에서
//		if (sumH >= goalH) {
//			// 최솟값보다 작으면 최솟값 갱신
//			if (minH >= sumH) {
//				minH = sumH;
//			}
//			return;
//		}
//
//		// recursive
//		// 모든 경우의 수를 탐색하되..
//		for (int i = 0; i < N; i++) {
//			// 이미 방문한 사람키면 패스
//			if (visited[i])
//				continue;
//			// 방문체크
//			visited[i] = true;
//			backTrack(sumH + height[i]);
//			// 재귀 돌아오면 방문 원상복구
//			visited[i] = false;
//		}
//	}
}
