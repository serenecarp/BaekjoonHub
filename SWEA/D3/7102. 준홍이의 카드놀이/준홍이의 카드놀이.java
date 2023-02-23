
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		// 두 숫자가 같다면
		// 1 2 3 4 5 6
		// 6 5 4 3 2 1 => 7 (== 최대+1)
		// 하나가 더 작으면
		// 1 2 3 4 5 6
		//     4 3 2 1 => 7 (== 최대+1)
		//   4 3 2 1   => 6
		// 4 3 2 1     => 5 (== 최소+1)
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.printf("#%d ", test_case);
			int N = sc.nextInt();
			int M = sc.nextInt();
			int bigger = (N > M) ? N : M;
			int smaller = (N <= M) ? N : M;
			for (int num = smaller + 1; num <= bigger + 1; num++)
				System.out.printf("%d ", num);
			System.out.println();
		}
	}
}