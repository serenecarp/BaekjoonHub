package prob001873;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1873 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			String[] field = new String[H];
			for(int i=0; i<H; i++) {
				field[i] = sc.next();
			}
			System.out.println(Arrays.toString(field));
			
		}
	}
}
