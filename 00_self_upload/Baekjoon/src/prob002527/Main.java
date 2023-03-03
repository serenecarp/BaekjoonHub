package prob002527;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 4;
		for (int testCase = 1; testCase <= T; testCase++) {
			int[][] square = new int[2][4];
			char type;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					square[i][j] = sc.nextInt();
				}
			}
			if (square[0][0] > square[1][0]) {
				int[] temp = square[0];
				square[0] = square[1];
				square[1] = temp;
			}
			// x1 <= x2
			int A = square[0][2] - square[1][0];
			int B;

			// y1 <= y2
			if (square[0][1] < square[1][1]) {
				B = square[0][3] - square[1][1];
			} else {
				B = square[1][3] - square[0][1];
			}

			if (A < 0 || B < 0) {
				type = 'd';
			} else if (A > 0 && B > 0) {
				type = 'a';
			} else if (A == 0 && B == 0) {
				type = 'c';
			} else {
				type = 'b';
			}
			
			System.out.println(type);

		}
	}
}
