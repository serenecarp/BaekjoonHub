package prob001217;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int testCase = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.printf("#%d %d\n", testCase, square(N, M));
		}
	}

	public static int square(int N, int M) {
		if (M == 1) {
			return N;
		}
		return N * square(N, M - 1);
	}
}
