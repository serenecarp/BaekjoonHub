package boj230325_GEC;

import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fount = sc.nextInt();
		int time = sc.nextInt();

		for (int i = 0; i < time; i++) {
			if (fount % 2 == 0) {
				fount = fount / 2 ^ 6;
			} else {
				fount = fount * 2 ^ 6;
			}
		}
		System.out.println(fount);
	}
}
