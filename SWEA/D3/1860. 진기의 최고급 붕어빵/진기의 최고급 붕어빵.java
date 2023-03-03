
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int customers = sc.nextInt();
			int sec = sc.nextInt();
			int buns = sc.nextInt();
			int[] timeline = new int[11112];

			for (int i = 0; i < customers; i++) {
				timeline[sc.nextInt()]--;
			}
			String answer = "Possible";
			for (int i = 0; i < timeline.length - 1; i++) {
				if (i % sec == 0 && i >= sec) {
					timeline[i] += buns;
				}
				if (timeline[i] < 0) {
					answer = "Impossible";
					break;
				}
				timeline[i + 1] += timeline[i];
			}

			System.out.printf("#%d %s\n", testCase, answer);
		}
	}
}
