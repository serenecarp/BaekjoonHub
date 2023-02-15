package prob009095;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[] dp = new int[10]; // 문제에서 n이 11보다 작다고 주어짐
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		
		for(int i=3; i<dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		while(T-- >0) {
			System.out.println(dp[sc.nextInt()-1]);
		}
	}
}
