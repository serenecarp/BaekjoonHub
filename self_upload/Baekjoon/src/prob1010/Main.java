package prob1010;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			long answer = 1;
			for (int i = M; i > M - N; i--) {
				answer *= i;
			}
			for (int i = 1; i <= N; i++) {
				answer /= i;
			}
			System.out.println(answer);
		}
	}
}
