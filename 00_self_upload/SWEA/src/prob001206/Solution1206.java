package prob001206;

import java.util.Scanner;

class Solution1206 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 건물 개수 N
			int N = sc.nextInt();
			// 4보다 작거나 1000보다 크면 종료
			if (N < 4 || N > 1000) return;
			
			// N개의 건물 높이
			int[] building = new int[N];

			// 빌딩 높이 입력
			for (int i = 0; i < building.length; i++) {
				building[i] = sc.nextInt();
				// 높이는 255 이하
				if (building[i] > 255) return;
			}
			
			
			
			int viewSum = 0;
			// 두번째 ~ 끝에서 세번째까지 세어주기
			for (int i = 2; i < building.length - 2; i++) {
				// 조건을 만족하는 전망 좋은 집 개수
				
				// 빌딩이 주변보다 큰 경우에만 세어 주기
				if (building[i] > building[i - 2] && building[i] > building[i - 1] && building[i] > building[i + 1]
						&& building[i] > building[i + 2]) {
					// 주변 건물 중 가장 큰 건물의 높이 구하기
					int leftMax = Math.max(building[i-2], building[i-1]);
					int rightMax = Math.max(building[i+2], building[i+1]);
					int maxHeight = Math.max(leftMax, rightMax);
					// 현재 건물 층수 - 주변 중 제일 높은 건물 층수 == 전망좋은 세대 수
					viewSum += building[i] - maxHeight;
				}
			}
			System.out.printf("#%d %d\n", test_case, viewSum);
		}
	}
}