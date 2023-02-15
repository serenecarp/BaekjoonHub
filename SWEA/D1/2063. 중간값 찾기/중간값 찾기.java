
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N - 1; i++) {
			int minIdx = i;
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