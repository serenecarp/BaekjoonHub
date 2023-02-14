package prob005215;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		List<Integer> testCase = new ArrayList<>();

		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 재료 개수
			int L = sc.nextInt(); // 제한 칼로리
			// flavor, calories, and happiness
			double[][] fcHappy = new double[3][N];
			double totFlav = 0;

			for (int material = 0; material < N; material++) {
				// 맛
				fcHappy[0][material] = sc.nextInt();
				// 칼로리
				fcHappy[1][material] = sc.nextInt();
				// 행복~
				fcHappy[2][material] = fcHappy[0][material] / fcHappy[1][material];
			}
			
			// 행복 내림차순 정렬
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if(fcHappy[2][i]<fcHappy[2][j]) {
						for (int k = 0; k<3; k++) {
							double tmp = fcHappy[k][j];
							fcHappy[k][j] = fcHappy[k][i];
							fcHappy[k][i] = tmp;
						}
						// 행복이 같으면 맛이 더 좋은걸 우선으로
					} else if (fcHappy[2][i]==fcHappy[2][j] && fcHappy[0][i]<fcHappy[0][j]){
						for (int k = 0; k<3; k++) {
							double tmp = fcHappy[k][j];
							fcHappy[k][j] = fcHappy[k][i];
							fcHappy[k][i] = tmp;
						}
					}
				}
			}
			
			// 만족감이 큰것부터 차례대로 먹어보기, 칼로리가 넘어버린다면 continue
			for (int i=0; i<N; i++) {
				if(L - fcHappy[1][i] < 0) continue;
				L -= fcHappy[1][i];
				totFlav += fcHappy[0][i];
			
			}
			
			testCase.add((int) totFlav);
		}
		for(int i=0; i<T; i++) {
			System.out.printf("#%d %d\n", i+1, testCase.get(i));
		}
		sc.close();
	}
}