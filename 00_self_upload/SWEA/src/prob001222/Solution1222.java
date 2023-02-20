package prob001222;

import java.util.Scanner;
import java.util.Stack;

class Solution1222 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 문자열 총 길이, 문자열 입력 받기
			int lenStr = sc.nextInt();
			char[] calString = new char[lenStr];
			calString = sc.next().toCharArray();
			// 숫자와 부호의 스택 각각 선언
			Stack<Integer> num = new Stack<>();
			Stack<Character> sign = new Stack<>();
			// 스택에 하나씩 거꾸로 넣기
			for (int i = calString.length - 1; i >= 0; i--) {
				if (calString[i] == '+') {
					sign.push(calString[i]);
				} else {
					num.push(calString[i] - '0');
				}
			}
			
			// 부호가 없어질 때까지 연산
			while (!sign.empty()) {
				int num1 = num.peek();
				num.pop();
				int num2 = num.peek();
				num.pop();
				int newNum;
				// 혹 다른 부호가 있을까봐 조건문으로 달아봤음.
				if (sign.peek() == '+') {
					sign.pop();
					newNum = num1 + num2;
					num.push(newNum);
				}
			}
			// 마지막으로 num스택에 남은 수가 결과값
			System.out.printf("#%d %d\n", test_case, num.peek());
		}
	}
}