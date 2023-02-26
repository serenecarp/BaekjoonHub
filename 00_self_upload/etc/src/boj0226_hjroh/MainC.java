package boj0226_hjroh;

import java.util.Arrays;
import java.util.Scanner;

public class MainC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hjrohX = sc.nextInt();
		int hjrohY = sc.nextInt();
		int n = sc.nextInt();
		double[][] target = new double[n][2];
		for (int i = 0; i < n; i++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			if (y - hjrohY < 0) {
				target[i][0] = x - hjrohX;
				target[i][1] = y - hjrohY;
			} else {
				target[i][0] = 0;
				target[i][1] = 0;
			}
			// target에 모든 (x, y)를 다 담아줬음

		}

		int answer = 0;
		for (int i = 0; i < n - 1; i++) {
			if (target[i][1] == 0)
				continue;
			double a = target[i][1] / (target[i][0] * target[i][0]);
			target[i][1] = 0;
			int temp = 1;
			for (int j = i + 1; j < n; j++) {

				if (target[j][1] != 0) {
					if (target[j][1] / (target[j][0] * target[j][0]) == a) {
						temp++;
						target[j][1] = 0;
					}
				}
			}
			
			if (answer < temp) {
				answer = temp;
			}
		}
		System.out.println(answer);
	}
}
