package prob001204;

import java.util.Scanner;

class Solution1204 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 0점~100점 (101칸) 빈도수 체크용 배열
			int[] scoreFrq = new int[101];
			// 테스트케이스 번호를 입력받는데, 별 의미는 없어서 그냥 한 번 입력만 받음
			sc.nextInt();
			// 학생들 수 (만큼 반복해서 입력)
			int std = 1000;
			// 학생들 1000명 점수 입력 및 빈도수 count
			for (int i = 0; i < std; i++) {
				scoreFrq[sc.nextInt()]++;
			}

			// 최빈값 탐색
			// mode: 최빈값
			int mode = 0;
			// maxFrq: 최대 빈도수
			int maxFrq = 0;
			// 빈도수가 같으면 더 큰 수 넣어야 해서 index 거꾸로 돌림
			for (int i = 100; i >= 0; i--) {
				if (maxFrq < scoreFrq[i]) {
					maxFrq = scoreFrq[i];
					mode = i;
				}
			}
			System.out.printf("#%d %d\n", test_case, mode);
		}
	}
}