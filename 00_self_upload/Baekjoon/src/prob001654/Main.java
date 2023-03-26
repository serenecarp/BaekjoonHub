package prob001654;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();

		int[] LANline = new int[K];
		for (int i = 0; i < K; i++) {
			LANline[i] = sc.nextInt();
		}
		int answer = 0;
		Arrays.sort(LANline);
		int idx = K - 1;
		int len = 1;
		int count = 0;
		int tmp;
		while (count != N || len != LANline[K - 1]) {
			count = 0;
			tmp = LANline[idx];
			while (tmp >= 0) {
				tmp -= len;
				if (tmp <= 0) {
					break;
				}
				count++;
				if (count == N) {
					answer = len;
					len++;
					break;
				}
			}
			idx--;
			if(idx < 0) {
				break;
			}
		}
		System.out.println(answer);
	}
}
