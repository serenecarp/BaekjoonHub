package boj0311_jungang;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int half = N / 2 + N % 2;
		int app = 0;
		int rej = 0;
		int inv = 0;
		for (int i = 0; i < N; i++) {
			int vote = sc.nextInt();
			switch(vote) {
			case 1:
				app++;
				break;
			case -1:
				rej++;
				break;
			case 0:
				inv++;
			}
		}

		if(inv >= half) {
			System.out.println("INVALID");
		} else if(app > rej) {
			System.out.println("APPROVED");
		} else {
			System.out.println("REJECTED");
		}
	}
}
