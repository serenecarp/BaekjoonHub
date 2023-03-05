package prob016817;

import java.util.Scanner;

public class Solution16817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] mySwitch = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			mySwitch[i] = sc.nextInt() == 0 ? false : true;
		}
		int students = sc.nextInt();
		for (int i = 0; i < students; i++) {
			int bg = sc.nextInt();
			int num = sc.nextInt();
			switch (bg) {
			case 1:
				while (num <= N) {
					mySwitch[num] = !mySwitch[num];
					num += num;
				}
				break;
			case 2:
				mySwitch[num] = !mySwitch[num];
				int d = 1;
				while (num - d >= 1 && num + d <= N) {
					if (mySwitch[num - d] == mySwitch[num + d]) {
						mySwitch[num - d] = !mySwitch[num - d];
						mySwitch[num + d] = !mySwitch[num + d];
						d++;
					}
				}

			}

		}

		for (int i = 1; i <= N; i++) {
			if (mySwitch[i]) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}
		}

	}
}
