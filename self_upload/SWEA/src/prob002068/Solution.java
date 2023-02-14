package prob002068;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		// 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 크기 10짜리 배열에 숫자들을 담을 예정
			int[] arr = new int[10];
			int maxVal = Integer.MIN_VALUE;

			// 배열에 수들을 담음과 동시에 최대값을 탐색함
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				if (maxVal < arr[i]) {
					maxVal = arr[i];
				}
			}

			System.out.printf("#%d %d\n", test_case, maxVal);

		}
		sc.close();
	}

}