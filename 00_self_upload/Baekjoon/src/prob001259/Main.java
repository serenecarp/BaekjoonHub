package prob001259;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			char[] pelin = sc.next().toCharArray();
			if(pelin[0] == '0') {
				break;
			}
			String answer = "yes";
			for (int i = 0; i < pelin.length / 2; i++) {
				if (pelin[i] != pelin[pelin.length - 1 - i]) {
					answer = "no";
					break;
				}
			}
			System.out.println(answer);
		}
	}
}
