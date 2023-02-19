package prob010757;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] num1 = sc.next().toCharArray();
		char[] num2 = sc.next().toCharArray();

		int maxLen = num1.length;
		if (maxLen < num2.length)
			maxLen = num2.length;
		int[] rNum1 = new int[maxLen];
		int[] rNum2 = new int[maxLen];
		int[] sum = new int[maxLen + 1];

		for (int i = 0; i < num1.length; i++) {
			rNum1[i] = num1[num1.length - 1 - i] - 48;
		}
		for (int i = 0; i < num2.length; i++) {
			rNum2[i] = num2[num2.length - 1 - i] - 48;
		}
		
		for (int i = 1; i < maxLen; i++) {
			int partialSum = rNum1[i] + rNum2[i];
			sum[maxLen - i] = partialSum % 10 + (rNum1[i - 1] + rNum2[i - 1]) / 10;
		}
		sum[maxLen] = (rNum1[0] + rNum2[0]) % 10;
		sum[0] = (rNum1[maxLen - 1] + rNum2[maxLen - 1]) / 10;
		System.out.println(Arrays.toString(sum));
		if (sum[0] != 0) {
			System.out.print(sum[0]);
		}
		for (int i = 1; i < sum.length; i++) {
			System.out.print(sum[i]);
		}
	}

}
