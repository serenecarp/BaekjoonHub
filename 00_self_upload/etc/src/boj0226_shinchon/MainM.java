package boj0226_shinchon;

import java.util.Scanner;

public class MainM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		String[][] rawClock = new String[M][];
		int[] clock = new int[M];
		for (int i = 0; i < M; i++) {
			rawClock[i] = sc.next().split(":");
			clock[i] = Integer.parseInt(rawClock[i][0]) * 60 + Integer.parseInt(rawClock[i][1]);
		}
		int[] dif = new int[M];
		for (int i = 0; i < M; i++) {
			dif[i] = dif[i] - dif[0];
		}
	}
}
