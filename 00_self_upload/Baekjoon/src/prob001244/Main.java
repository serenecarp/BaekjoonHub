package prob001244;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] mySwitch = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			mySwitch[i] = (sc.nextInt() == 0) ? false : true;
		}
		int students = sc.nextInt();
		for (int i = 0; i < students; i++) {
			switch (sc.nextInt()) {
			case 1:
				int boySwitch = sc.nextInt();
				for (int j = boySwitch; j <= N; j += boySwitch) {
					mySwitch[j] = !mySwitch[j];
				}
				break;

			case 2:
				int girlSwitch = sc.nextInt();
				int d = 1;
				mySwitch[girlSwitch] = !mySwitch[girlSwitch];
				while (girlSwitch - d >= 1 && girlSwitch + d <= N) {
					if (mySwitch[girlSwitch + d] != mySwitch[girlSwitch - d]) {
						break;
					}
					mySwitch[girlSwitch + d] = !mySwitch[girlSwitch + d];
					mySwitch[girlSwitch - d] = !mySwitch[girlSwitch - d];
					d++;
				}
				break;
			}
		}
		int count = 0;
		for (int i = 1; i <= N; i++) {

			if (mySwitch[i] == true) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}
			count++;
			if (count == 20) {
				System.out.println();
				count = 0;
			}
		}
	}
}
