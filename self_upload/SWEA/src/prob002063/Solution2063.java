package prob002063;

import java.util.Scanner;

class Solution2063 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		// 입력 받을 정수 개수(홀수)
		int N = sc.nextInt();
		int[] arr = new int[N];
		// 정수 입력
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// selection sort
		for (int i = 0; i < N - 1; i++) {
			int minIdx = i;
			// i와 j번째를 비교해서 더 작으면 맨 앞에 놓기 -> 반복
			for (int j = i + 1; j < N; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			swap(arr, i, minIdx);
		}
		System.out.println(arr[N / 2]);
	}

	// 배열 자리 바꾸는 메소드
	// 배열은 주소값을 주므로 파라미터로 받아도 잘 바뀜
	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
}