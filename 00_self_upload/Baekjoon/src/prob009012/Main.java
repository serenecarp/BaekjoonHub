package prob009012;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			Stack<Character> bracket = new Stack<>();
			char[] rawBracket = sc.next().toCharArray();
			String answer = "YES";
			for (int i = 0; i < rawBracket.length; i++) {
				char nextOne = rawBracket[i];
				if (nextOne == '(') {
					bracket.push(nextOne);
				} else {
					if (bracket.isEmpty()) {
						answer = "NO";
						break;
					} else {
						bracket.pop();
					}
				}
			}
			
			if(!bracket.isEmpty())
				answer = "NO";
			System.out.println(answer);
		}
	}
}
