
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 수열 입력
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			// Insertion Sort
			// 앞의 첫 원소는 정렬이 되었다고 가정
			// 뒤에서부터 하나씩, 앞의 정렬된 그룹들과 비교함
			// 뒤의 원소를, 책을 꽂아 넣듯이 알맞은 자리에 꽂아 넣는 방식
			for (int i = 1; i < N; i++) {
				for (int j = i; j > 0; j--) {
					// 근데 내가 쓴 이건 버블소트의 느낌이?
					
					if (arr[j] < arr[j - 1]) {
						int temp = arr[j];
						arr[j] = arr[j - 1];
						arr[j - 1] = temp;
					}
//					System.out.println(Arrays.toString(arr));
				}

			}
			System.out.printf("#%d ", test_case);
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}

	}
}
