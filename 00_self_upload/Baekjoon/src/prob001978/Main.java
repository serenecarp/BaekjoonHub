package prob001978;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		boolean[] isPrime = new boolean[1001];
		// 소수면 false, 아니면 true (기본값이 false라서)
		// 0, 1 제외
		isPrime[0] = true;
		isPrime[1] = true;

		// 2~100까지 수 중에서
		// 2의 배수를 거르고: 4, 6, 8, 10, ...
		// 3의 배수를 거르고: (6), 9, 12, 15, ...
		// 5의 배수를 거르고: (10), (15), (20), 25, 30, ...
		// ..
		// 97의 배수를 거르고: 97, .
		for (int i = 2; i <= Math.sqrt(1000); i++) {
			// 이미 이전에서 처리해버린 하위호환(?)인 수는 건너뛴다.
			if (isPrime[i]) {
				continue;
			}
			// i*i 이전 수들은 이미 다 따져진 수들이므로 i제곱부터 시작
			for (int j = i * i; j <= 1000; j += i) {
				isPrime[j] = true;
			}
		}

		for (int i = 0; i < N; i++) {
			if (!isPrime[sc.nextInt()]) {
				count++;
			}
		}
		System.out.println(count);
	}
}
