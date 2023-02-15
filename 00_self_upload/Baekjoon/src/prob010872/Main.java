package prob010872;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(recursion(sc.nextInt()));
	}

	// 재귀함수
	public static int recursion(int N) {
		if (N == 0) {
			return 1;
		}

		return N * recursion(N - 1);
	}
}
