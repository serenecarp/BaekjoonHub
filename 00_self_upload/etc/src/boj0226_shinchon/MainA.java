package boj0226_shinchon;

import java.util.Arrays;
import java.util.Scanner;

public class MainA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] record = new String[8][4];
		String[] temp = new String[3];
		int[][] sortedRec = new int[8][2];
		for (int i = 0; i < 8; i++) {

			temp = sc.next().split(":");
			for (int j = 0; j < 3; j++) {
				record[i][j] = temp[j];
			}
			record[i][3] = sc.next();
		}
		for (int i = 0; i < 8; i++) {
			// R:0, B:1
			sortedRec[i][0] = (record[i][3].equals("R")) ? 0 : 1;
			sortedRec[i][1] = Integer.parseInt(record[i][0]) * 100000 + Integer.parseInt(record[i][1]) * 1000
					+ Integer.parseInt(record[i][2]);
		}

		for (int i = 0; i < 7; i++) {
			int minIdx = i;
			for (int j = i + 1; j < 8; j++) {
				if (sortedRec[minIdx][1] > sortedRec[j][1]) {
					minIdx = j;
				}
			}
			swap(sortedRec, i, minIdx);
		}
//		System.out.println(Arrays.deepToString(sortedRec));
		int score = 0;
		int scoreB = 0;
		int scoreR = 0;
		String winner;
		for (int i = 7; i >=0; i--) {
			score ++;
			if (i == 1) {
				score = 8;
			} else if (i == 0) {
				score = 10;
			}
			if (sortedRec[i][0] == 0) {
//				System.out.printf("R이 이김, %d점\n", score);
				scoreR += score;
			} else {
//				System.out.printf("B이 이김, %d점\n", score);
				scoreB += score;
			}
			

		}

		winner = (scoreR > scoreB) ? "Red" : "Blue";
//		System.out.println(scoreR + " " +scoreB);
		System.out.println(winner);
	}

	static void swap(int[][] arr, int a, int b) {
		int[] temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
