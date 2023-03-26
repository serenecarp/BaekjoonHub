package boj230326_UDP;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int scoreD = 0;
		int scoreP = 0;
		int streak = 0;
		for (int i = 0; i < N; i++) {
			char winner = sc.next().charAt(0);
			switch (winner) {
			case 'D':
				scoreD++;
				break;
			case 'P':
				scoreP++;
				break;
			}
			if (scoreD == scoreP + 2 || scoreP == scoreD + 2) {
				break;
			}
		}
		System.out.println(scoreD + ":" + scoreP);
	}
}
