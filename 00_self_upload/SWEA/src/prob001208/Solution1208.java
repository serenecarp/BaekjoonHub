package prob001208;

import java.util.Scanner;

class Solution1208 {
	public static void main(String args[]) throws Exception {
//		 System.setIn(new FileInputStream("C:\\Users\\SSAFY\\Desktop\\input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = 10;

		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// dump를 몇 번 할지 입력
			int dumpRepeat = sc.nextInt();
			// 상자 열(column)의 수, 각 열의 상자 높이를 담은 배열
			int column = 100;
			int[] boxes = new int[column];
			// 각 상자 높이 입력 (1~100)
			for (int i = 0; i < boxes.length; i++) {
				boxes[i] = sc.nextInt();
			}

			// 초기 상자 정렬
			selectionSort(boxes);

			for (int i = 0; i < dumpRepeat; i++) {
				if (isComplete(boxes)) {
					break;
				} else {
					dump(boxes);
					selectionInsert(boxes);
				}
			}
//			System.out.println(Arrays.toString(boxes));
			System.out.printf("#%d %d\n", test_case, boxes[boxes.length - 1] - boxes[0]);
		}
	}

	// selectionSort: 초기 상자들을 정렬
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			swap(arr, i, minIdx);
		}
	}

	// swap: 두 column의 상자를 바꾸는 메소드
	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	// dump: 제일 큰 애가 제일 작은 애한테 상자 하나 떼어 주라는 메소드
	public static void dump(int[] arr) {
		arr[arr.length - 1]--;
		arr[0]++;
	}

	// selectionInsert: dump이후 키가 바뀐 column들을 제 위치로 찾아가도록 하는 메소드
	public static void selectionInsert(int[] arr) {
		// 맨 왼쪽에서 한 상자 더한 column을 제 위치로
		for (int i = 0; i < arr.length - 1; i++) {
			// 나보다 크거나 같은 녀석이 나타나면 그 전녀석과 자리를 바꾼다
			if (arr[0] <= arr[i + 1]) {
				swap(arr, 0, i);
				break;
			}
		}
		// 맨 오른쪽에서 한 상자 빠진 column을 제 위치로
		for (int i = arr.length - 1; i > 0; i--) {
			// 나보다 작거나 같은 녀석이 나타나면 그 전 녀석과 자리를 바꾼다
			if (arr[arr.length - 1] >= arr[i - 1]) {
				swap(arr, arr.length - 1, i);
				break;
			}
		}
	}

	// isComplete: dump가 완료되었는지 판단하는 메소드
	public static boolean isComplete(int[] arr) {
		if (arr[arr.length - 1] - arr[0] <= 1) {
			return true;
		} else {
			return false;
		}
	}
}