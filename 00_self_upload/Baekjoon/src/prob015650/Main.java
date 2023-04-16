package prob015650;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] printer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		printer = new int[M];
		combination(0, 1);
	}

	static void combination(int selected, int idx) {
		if (selected == M) {
			printAnswer();
			return;
		}

		if (idx == N + 1) {
			return;
		}
		
		printer[selected] = idx;
		combination(selected + 1, idx + 1);
		combination(selected, idx + 1);

	}

	static void printAnswer() {
		for (int i = 0; i < printer.length; i++) {
			System.out.print(printer[i] + " ");
		}
		System.out.println();
	}
}
