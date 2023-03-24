package prob001920;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int M = sc.nextInt();
		int[] myArr = new int[M];
		for (int i = 0; i < M; i++) {
			myArr[i] = sc.nextInt();
		}

		int idx = 0;

		while (idx != M) {
			int st = 0;
			int ed = N - 1;
			int mid = 0;
			while (true) {
				mid = (st + ed) / 2;
				if (st > ed) {
					System.out.println(0);
					idx++;
					break;
				}

				if (arr[mid] == myArr[idx]) {
					System.out.println(1);
					idx++;
					break;
				} else if (arr[mid] < myArr[idx]) {
					st = mid + 1;
					continue;
				} else {
					ed = mid - 1;
					continue;
				}
			}
		}

	}
}
