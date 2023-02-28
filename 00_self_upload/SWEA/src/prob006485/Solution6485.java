package prob006485;

import java.util.Scanner;

public class Solution6485 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		// 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 버스가 지나가는 루트 개수 입력
			int routes = sc.nextInt();
			// 버스 루트의 시작점과 끝점을 각각 입력 받는다.
			int[] start = new int[routes];
			int[] end = new int[routes];
			for (int i = 0; i < routes; i++) {
				start[i] = sc.nextInt();
				end[i] = sc.nextInt();
			}

			// 정류장의 개수와 정류장 위치 입력
			int stations = sc.nextInt();
			int[] station = new int[stations];
			for (int i = 0; i < stations; i++) {
				station[i] = sc.nextInt();
			}

			// 버스 루트들의 시작점과 끝점들을 오름차순 sorting
			// 얼마 전에 배운 insertion sort 활용
			insertionSort(start);
			insertionSort(end);

			// 각 버스 정류장이 몇 개의 버스 루트에 포함되는지
			int[] answer = new int[stations];
			for (int i = 0; i < stations; i++) {

				int startPoint = 0;
				int endPoint = 0;

				// 1.
				// 어떤 버스 루트 하나의 시작점이 내 정류장값보다 작거나 같으면
				// 이 정류장을 지나는 루트++
				// 2.
				// 어떤 버스 루트 하나의 끝점이 내 정류장값보다 작으면
				// 이 정류장을 지나는 루트 --
				while (startPoint < start.length && station[i] >= start[startPoint]) {
					answer[i]++;
					startPoint++;
				}
				while (endPoint < end.length && station[i] > end[endPoint]) {
					answer[i]--;
					endPoint++;
				}

			}
			System.out.printf("#%d ", test_case);
			for (int i = 0; i < answer.length; i++) {
				System.out.printf("%d ", answer[i]);
			}
			System.out.println();

		}
	}

	// Insertion Sort
	static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int myLoc = i;
			int temp = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					myLoc = j;
					continue;
				} else {
					break;
				}
			}
			for (int k = i; k > myLoc; k--) {
				arr[k] = arr[k - 1];
			}
			arr[myLoc] = temp;
		}
	}
}
