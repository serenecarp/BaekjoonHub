package boj230326_UDP;

import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] card = new int[N];
		int[] flipOrder = new int[N];

		int cur = N % 2 == 0 ? N / 2 - 1 : N / 2;

		card[cur] = N;

		for (int i = 1; i < N; i++) {
			int pm = i % 2 == 0 ? -1 : 1;
			card[cur + i * pm] = i;
			cur = cur + i * pm;

		}

		if (N % 2 != 0) {
			flipOrder[0] = 1;
			int flipIndex = 1;
			for (int i = 1; i < N; i++) {
				int pm = i % 2 == 0 ? -1 : 1;

				flipIndex += (N - i) * pm;
				flipOrder[i] += flipIndex;
			}
		} else {
			flipOrder[0] = N;
			int flipIndex = N;

			for (int i = 1; i < N; i++) {
				int pm = i % 2 == 0 ? 1 : -1;
				flipIndex += (N - i) * pm;
				flipOrder[i] += flipIndex;
			}
		}

		System.out.println("YES");
		for (int i = 0; i < N; i++) {
			System.out.print(card[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print(flipOrder[i] + " ");
		}
	}

}
