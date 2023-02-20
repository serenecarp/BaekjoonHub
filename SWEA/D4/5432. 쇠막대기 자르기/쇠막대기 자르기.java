
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			char[] bracket = sc.next().toCharArray();
			int count = 0;
			int answer = 0;
			for (int i = 0; i < bracket.length; i++) {
				if (bracket[i] == '(') {
					count++;
				} else if (bracket[i] == ')') {
					count--;
					if (bracket[i - 1] == '(') {
						answer += count;
					} else
						answer += 1;
				}
			}
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}