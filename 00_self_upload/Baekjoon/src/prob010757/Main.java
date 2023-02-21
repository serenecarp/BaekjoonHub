package prob010757;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 5432
		// 7777
		char[] num1 = sc.next().toCharArray();
		char[] num2 = sc.next().toCharArray();

		// maxLen==4
		int maxLen = num1.length;
		if (maxLen < num2.length)
			maxLen = num2.length;
		// 00000 배열
		int[] rNum1 = new int[maxLen + 1];
		int[] rNum2 = new int[maxLen + 1];
		int[] sum = new int[maxLen + 1];

		// 거꾸로
		// 23450
		// 77770
		for (int i = 0; i < num1.length; i++) {
			rNum1[i] = num1[num1.length - 1 - i] - 48;
		}
		for (int i = 0; i < num2.length; i++) {
			rNum2[i] = num2[num2.length - 1 - i] - 48;
		}
		// 올림
		int formerSumUp = 0;
		// 자리 더한거 + 올림 ==> 해당 자리 결과
		// 9+0 ==> 9
		// 10+0 ==> 0
		// 11+1 ==> 2
		// 12+1 ==> 3
		// 0+1 ==> 1
		// ======> 13209
		for (int i = 0; i <= maxLen; i++) {
			int partialSum = rNum1[i] + rNum2[i];
			sum[i] = (partialSum % 10 + formerSumUp) % 10;
			formerSumUp = (partialSum + formerSumUp) / 10;
		}

		if (sum[sum.length - 1] != 0) {
			System.out.print(sum[sum.length - 1]);
		}
		for (int i = sum.length - 2; i >= 0; i--) {
			System.out.print(sum[i]);
		}
	}
}
