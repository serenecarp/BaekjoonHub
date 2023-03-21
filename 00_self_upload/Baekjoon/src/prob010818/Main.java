package prob010818;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int maxVal = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num > maxVal) {
				maxVal = num;
			}
			if (num < minVal) {
				minVal = num;
			}
		}
		System.out.println(minVal + " " + maxVal);
	}
}
