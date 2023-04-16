package prob015652;

import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		selectNum(1, 0);
	}

	public static void selectNum(int num, int select) {
		if (select == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		if (num == N + 1)
			return;

		arr[select] = num;
		selectNum(num, select + 1);
		selectNum(num + 1, select);
	}
}
