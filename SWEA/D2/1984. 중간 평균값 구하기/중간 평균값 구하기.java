
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 크기 10짜리 배열에 숫자들을 담음
			int[] arr = new int[10];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			// 이 바깥 for문은 배열이 완성되었는지를 검증하는 swapped를 위해 만들어줌.
			for (int j = 0; j < arr.length - 1; j++) {
				// Bubbling이 일어났는가? 를 세어주는 변수 선언
				boolean swapped = false;

				// Bubble sort (오름차순)
				for (int i = 0; i < arr.length - 1; i++) {

					// 앞녀석이 뒷녀석보다 크면 자리 바꾸기
					if (arr[i] > arr[i + 1]) {
						int tmp = arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = tmp;
						// 버블링 했으니 swapped를 true로
						swapped = true;
					}

				}
				// 자리 바꾼 적 없으면 이미 다 정렬됐다는 뜻이므로 sorting 종료
				if (!swapped) {
					break;
				}
			}
			// 총합
			// 나누기할 때 버려지는거 방지해서 double로 선언
			double sum = 0;
			// 처음, 끝(최소, 최대)만 빼고 다 더하기
			for (int i = 1; i < arr.length - 1; i++) {
				sum += arr[i];
			}
			// 총 개수 - 2개(최대최소)로 나누어 평균 출력
			System.out.printf("#%d %d\n", test_case, (int)Math.round(sum / (double)(arr.length - 2)));
		}
	}
}