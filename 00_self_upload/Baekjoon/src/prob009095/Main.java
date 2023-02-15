package prob009095;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] partition = new int[T][];
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			
			partition[i] = new int[(int) Math.pow(2, n - 1)];
		}
		// i는 partition 개수 (=T), 각 길이는 n-1의 제곱(경우의수 = 2^(n-1))
		for (int i = 0; i < T; i++) {
			
			// n = 1로 지정했을 때만 예외 발생
			if(partition[i].length==1) {
				System.out.println(1);
				continue;
			}
			
			// 포함하면 안되는 경우를 세어주는 변수
			int notCase = 0;

			for (int j = 0; j < partition[i].length; j++) {
				// 0,1,2,..,칸막이 최대개수제곱까지 순서대로 '2진수모양인 10진수'로 담기
				// n=5이면.. 0000, 0001, 0010, ... , 1111
				partition[i][j] = Integer.parseInt(Integer.toBinaryString(j));

				// 연속으로 0이 3개(이상) 오는 경우 탐색
				for (int k = 0; k < log2((double)partition[i].length)-2; k++) {
					int one = (int) ((partition[i][j] % Math.pow(10, k + 1)) / Math.pow(10, k));
					int two = (int) ((partition[i][j] % Math.pow(10, k + 2)) / Math.pow(10, k + 1));
					int three = (int) ((partition[i][j] % Math.pow(10, k + 3)) / Math.pow(10, k + 2));
					if (one == 0 && two == 0 && three == 0) {
						notCase++;
						break;
					}
				}
			}
		// 전체 경우의 수 - 안되는 경우의 수
			System.out.println(partition[i].length - notCase);
		}
	}
	// 밑이 2인 로그함수
	static double log2(double x) {
		return Math.log10(x)/Math.log10(2);
	}
}