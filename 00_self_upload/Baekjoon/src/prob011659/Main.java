package prob011659;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] partialSum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			partialSum[i] = partialSum[i - 1] + sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			System.out.println(partialSum[ed] - partialSum[st - 1]);
		}
	}

}
