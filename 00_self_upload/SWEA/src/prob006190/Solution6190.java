package prob006190;

import java.util.Scanner;
import java.util.Stack;

class Solution6190 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] seq = new int[N];
			for (int i = 0; i < N; i++) {
				seq[i] = sc.nextInt();
			}
			// 없는 경우 기본값 -1
			int maxMonoIncr = -1;
			// 완전탐색으로 단조증가수가 존재하는지 찾기
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int multResult = seq[i] * seq[j];
					if (isMonoIncr(multResult)) {
						// 최댓값이면 갱신
						if (maxMonoIncr < multResult) {
							maxMonoIncr = multResult;
						}
					}

				}
			}
			// 출력
			System.out.printf("#%d %d\n", test_case, maxMonoIncr);
		}

	}
	// 단조증가하는 수인지 검사하는 메소드
	static boolean isMonoIncr(int n) {
		boolean yes = true;
		while (n != 0) {
			// 맨 끝자리와 그 앞자리를 비교
			// 맨 끝자리가 더 작으면 아닌 것으로 판명 -> false 반환
			int digit = n % 10;
			n /= 10;
			if (digit < n % 10) {
				yes = false;
				break;
			}
		}
		return yes;
	}
}
