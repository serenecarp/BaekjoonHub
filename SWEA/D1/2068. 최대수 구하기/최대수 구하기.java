
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[10];
			int maxVal = Integer.MIN_VALUE;

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