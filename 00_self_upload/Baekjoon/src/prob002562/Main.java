package prob002562;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxVal = Integer.MIN_VALUE;
		int maxIdx = 0;
		for (int i = 1; i <= 9; i++) {
			int num = sc.nextInt();
			if (maxVal < num) {
				maxVal = num;
				maxIdx = i;
			}
		}
		System.out.println(maxVal);
		System.out.println(maxIdx);
	}
}
