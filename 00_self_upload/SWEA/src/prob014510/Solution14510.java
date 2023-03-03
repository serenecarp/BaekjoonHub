package prob014510;

import java.util.Scanner;

public class Solution14510 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			int trees = sc.nextInt();
			int maxH = Integer.MIN_VALUE;

			int[] height = new int[trees];
			for (int i = 0; i < trees; i++) {
				height[i] = sc.nextInt();
				if (maxH < height[i])
					maxH = height[i];
			}
			int n = 1;
			int answer = 0;
			int evenCnt = 0;
			int oddCnt = 0;
			int i = 0; // ~trees-1
			while (height[i] < maxH) {
//				System.out.println(height[i] + " zz " + maxH);
				int k = (n % 2 == 0) ? 2 : 1;
				boolean keepGo = true;
				if (maxH - height[i] == 2 && k == 1) {
					evenCnt++;
					keepGo = false;
				} else if (maxH - height[i] == 1 && k == 2) {
					oddCnt++;
					keepGo = false;
				}
				n++;
				if (keepGo) {
					height[i] += k;
					answer++;
					continue;
				}
				
				
				

				if (height[i] == maxH || !keepGo) {
					i++;
				}

			}
			if (evenCnt != 0 || oddCnt != 0) {
				if (evenCnt > oddCnt) {
					answer += evenCnt * 2;
					if (n % 2 == 0) {
						answer -= 1;
					}
				} else {
					answer += oddCnt * 2;
					if (n % 2 == 1) {
						answer -= 1;
					}
				}
			}
//			if (sumToGrow == 2) {
//				answer += 2;
//			} else if (sumToGrow % 3 == 2) {
//				answer += (sumToGrow / 3 + 1) * 2;
//			} else {
//				answer += (sumToGrow / 3) * 2 + sumToGrow % 3;
//			}

			System.out.printf("#%d %d\n", testCase, answer);
		}
	}
}
