package prob008958;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case=0; test_case<T; test_case++) {
			String oxQuiz = sc.next();
			String[] oxQuizArr = oxQuiz.split("");
			int bonus = 0;
			int totScore = 0;
		
			for (int i=0; i<oxQuizArr.length; i++) {
				if (oxQuizArr[i].equals("O")) bonus++;
				else bonus=0;
				totScore += bonus;
			}
			System.out.println(totScore);
		}
	}
}
