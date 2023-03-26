package boj230326_UDP;

import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String rawResult = sc.next();
		char[] result = rawResult.toCharArray();

		int uc = 0;
		int dp = 0;
		for (int i = 0; i < result.length; i++) {
			char vote = result[i];
			switch (vote) {
			case 'U':
				uc++;
				break;
			case 'D':
				dp++;
				break;
			case 'P':
				dp++;
				break;
			case 'C':
				uc++;
				break;
			}
		}
		if (uc > dp / 2 + dp % 2 && uc >= 1) {
			sb.append("U");
		}

		if (dp != 0) {
			sb.append("DP");
		}

		System.out.println(sb);
	}
}
