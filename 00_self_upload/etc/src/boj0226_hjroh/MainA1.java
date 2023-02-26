package boj0226_hjroh;

import java.util.Scanner;

public class MainA1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (n * m % 2 == 0)
			System.out.println(n * m);
		else
			System.out.println(n * m - 1);
	}
}
