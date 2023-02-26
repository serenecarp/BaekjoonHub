package boj0226_hjroh;

import java.util.Scanner;

public class MainA2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[N];
		long serialSum = 0;

		arr = sc.nextLine().split(" ");
		for (int i = 0; i < N; i++) {
			if (!arr[i].equals("0"))
				serialSum += Long.parseLong(arr[i]);
		}
		long answer = 1;
		while (answer * 2 <= serialSum) {
			answer *= 2;
		}
		System.out.println(answer);
	}
}
