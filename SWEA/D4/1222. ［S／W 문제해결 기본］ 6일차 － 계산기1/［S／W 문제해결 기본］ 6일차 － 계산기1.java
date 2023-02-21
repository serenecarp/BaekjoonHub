
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 수식 길이 입력.. -> toCharArray로 받아줘서 별 의미는 없음
			int len = sc.nextInt();
			char[] infix = sc.next().toCharArray();

			Queue<Character> postfix = new LinkedList<>();
			Stack<Character> operator = new Stack<>();
			Stack<Integer> operand = new Stack<>();
			for (int i = 0; i < infix.length; i++) {
				if (infix[i] >= '0') {
					postfix.add(infix[i]);
				} else if (infix[i] == '+') {
					if (operator.isEmpty()) {
						operator.push(infix[i]);
					} else {
						postfix.add(operator.peek());
						operator.pop();
						operator.push(infix[i]);
					}
				}
			}
			while (!operator.isEmpty()) {
				postfix.add(operator.peek());
				operator.pop();
			}

			while (!postfix.isEmpty()) {
				if (postfix.peek() >= '0') {
					operand.push(postfix.poll() - '0');
				} else if (postfix.peek() == '+') {
					postfix.poll();
					int num1 = operand.peek();
					operand.pop();
					int num2 = operand.peek();
					operand.pop();
					operand.push(num1 + num2);
				}
			}

			System.out.printf("#%d %d\n", test_case, operand.peek());
		}
	}
}