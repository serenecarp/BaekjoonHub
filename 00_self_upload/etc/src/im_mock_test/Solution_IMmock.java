package im_mock_test;

import java.util.Scanner;

class Solution_IMmock {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// N: 신입사원 수
			// kMin: 각 분반별 최소 인원
			// kMax: 각 분반별 최대 인원
			// score: 사원별 점수 입력
			int N = sc.nextInt();
			int kMin = sc.nextInt();
			int kMax = sc.nextInt();
			int[] score = new int[N];
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
			}
			// 점수를 빈도수로 배열에 담기
			int[] scoreDis = new int[101];
			for (int i = 0; i < N; i++) {
				scoreDis[score[i]]++;
			}

			// 각 분반의 인원 수
			int classA = 0;
			int classB = 0;
			int classC = 0;
			// 답(분반별 인원 차이의 최솟값)
			int answer = Integer.MAX_VALUE;
			// 답이 없으면 -1 출력, 있으면 해당 값 출력할 예정
			boolean isAnswer = false;

			// 첫 번째 칸막이
			// classA 선별
			for (int i = 0; i < N - 1; i++) {

				if (scoreDis[i] != 0) {
					classA += scoreDis[i];
					// 최소 인원보다 적으면 인원 충원
					// 최대 인원보다 많으면 망한 케이스, break
					if (classA < kMin) {
						continue;
					} else if (classA > kMax) {
						break;
					}

				} else {
					continue;
				}
				classB = 0;
				// 두 번째 칸막이
				// classB 선별
				for (int j = i + 1; j < N; j++) {

					if (scoreDis[j] != 0) {
						classB += scoreDis[j];
						// 최소 인원보다 적으면 인원 충원
						// 최대 인원보다 많으면 망한 케이스, break
						if (classB < kMin) {
							continue;
						} else if (classB > kMax) {
							break;
						}

					} else {
						continue;
					}

					// classC 선별 (남은 인원)
					// 최소 인원보다 적으면 인원 충원
					// 최대 인원보다 많으면 망한 케이스, break
					if (N - classA - classB < kMin) {
						continue;
					} else if (N - classA - classB > kMax) {
						break;
					}

					classC = N - classA - classB;

					// 반 인원의 최대, 반 인원의 최소를 구하고
					// 두 값의 차이의 최솟값을 출력
					int maxPeople = 0;
					int minPeople = Integer.MAX_VALUE;
					isAnswer = true;
					// A 최대최소 처리
					if (maxPeople < classA)
						maxPeople = classA;
					if (minPeople > classA)
						minPeople = classA;
					// B 최대최소 처리
					if (maxPeople < classB)
						maxPeople = classB;
					if (minPeople > classB)
						minPeople = classB;
					// C 최대최소 처리
					if (maxPeople < classC)
						maxPeople = classC;
					if (minPeople > classC)
						minPeople = classC;
					if (answer > maxPeople - minPeople) {
						answer = maxPeople - minPeople;
					}
				}

			}
			// 출력
			if (isAnswer)
				System.out.printf("#%d %d\n", test_case, answer);
			else
				System.out.printf("#%d %d\n", test_case, -1);
		}
	}
}