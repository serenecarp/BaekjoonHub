package prob005356;

import java.util.Scanner;
import java.util.Stack;

class Solution5356 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		// 1. 다섯 가지 문자열을 char[][]에 입력받는다.
		// 2. 스택을 5개 만들어 각각에 거꾸로 push한다.
		// 3. 각 스택에서 하나씩 pop하며 출력한다.
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.printf("#%d ", test_case);
			char[][] letters = new char[5][];
			for (int i = 0; i < 5; i++) {
				letters[i] = sc.next().toCharArray();
			}
			// 다섯가지 스택 선언
			// 얘네들을 하나의 배열에 담아보려고 했는데..
			// 자바 미숙으로 담지 못했다. 자바를 더 공부해야 할듯..
			// 그 결과 아래처럼 장황하고 긴 코드가 되었다.
			Stack<Character> stack1 = new Stack<>();
			Stack<Character> stack2 = new Stack<>();
			Stack<Character> stack3 = new Stack<>();
			Stack<Character> stack4 = new Stack<>();
			Stack<Character> stack5 = new Stack<>();

			// 각 스택에 거꾸로 push
			for (int i = letters[0].length - 1; i >= 0; i--) {
				stack1.push(letters[0][i]);
			}
			for (int i = letters[1].length - 1; i >= 0; i--) {
				stack2.push(letters[1][i]);
			}
			for (int i = letters[2].length - 1; i >= 0; i--) {
				stack3.push(letters[2][i]);
			}
			for (int i = letters[3].length - 1; i >= 0; i--) {
				stack4.push(letters[3][i]);
			}
			for (int i = letters[4].length - 1; i >= 0; i--) {
				stack5.push(letters[4][i]);
			}

			// 모든 스택이 비어있을 때까지
			// 각 스택이 비게 될 때까지 맨 윗녀석 출력 및 pop
			while (!stack1.isEmpty() || !stack2.isEmpty() || !stack3.isEmpty() || !stack4.isEmpty()
					|| !stack5.isEmpty()) {
				if (!stack1.isEmpty()) {
					System.out.print(stack1.peek());
					stack1.pop();
				}
				if (!stack2.isEmpty()) {
					System.out.print(stack2.peek());
					stack2.pop();
				}
				if (!stack3.isEmpty()) {
					System.out.print(stack3.peek());
					stack3.pop();
				}
				if (!stack4.isEmpty()) {
					System.out.print(stack4.peek());
					stack4.pop();
				}
				if (!stack5.isEmpty()) {
					System.out.print(stack5.peek());
					stack5.pop();
				}
				
			}
			// 줄바꿈
			System.out.println();
		}
	}
}
