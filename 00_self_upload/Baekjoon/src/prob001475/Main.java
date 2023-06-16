package prob001475;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] roomNo = sc.next().toCharArray();
		int[] countArr = new int[10];
		for (int i = 0; i < roomNo.length; i++) {
			countArr[roomNo[i] - '0']++;
		}
		int maxCnt = 0;
		for (int i = 0; i < 10; i++) {
			if (i == 6 || i == 9) {
				continue;
			}
			if (countArr[i] > maxCnt) {
				maxCnt = countArr[i];
			}
		}
		int tmp = (countArr[6] + countArr[9]) / 2 + (countArr[6] + countArr[9]) % 2;
		int answer = maxCnt > tmp ? maxCnt : Math.round(tmp);
		System.out.println((int) answer);
	}
}
