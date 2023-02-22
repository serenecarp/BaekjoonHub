package prob001218;

import java.util.Scanner;
import java.util.Stack;

class Solution1218 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			// toCharArray로 받을 거라 별 의미 없는 tc 길이를 nextInt()로 처리
			sc.nextInt();
			// 오늘 큐를 배우긴 했는데 어떻게 활용해야 할 지 몰라서
			// 그냥 스택을 썼다.
			Stack<Character> bracket = new Stack<>();
			char[] rawBracket = sc.next().toCharArray();

			// 괄호가 온전히 잘 있는 좋은 상태라고 가정
			int isGood = 1;
			
			// 여는 괄호가 나왔다면 스택에 push
			
			// 닫는 괄호가 나왔다면
			// 스택 맨 위 원소가 해당 괄호의 여는 괄호가 아닐 경우
			// 온전하지 않다고 판단하고 탈출 후 출력
			for (int i = 0; i < rawBracket.length; i++) {
				if (rawBracket[i] == ')') {
					if (bracket.peek() == '(') {
						bracket.pop();
						continue;
					} else {
						isGood = 0;
						break;
					}
				}
				if (rawBracket[i] == ']') {
					if (bracket.peek() == '[') {
						bracket.pop();
						continue;
					} else {
						isGood = 0;
						break;
					}
				}
				if (rawBracket[i] == '}') {
					if (bracket.peek() == '{') {
						bracket.pop();
						continue;
					} else {
						isGood = 0;
						break;
					}
				}
				if (rawBracket[i] == '>') {
					if (bracket.peek() == '<') {
						bracket.pop();
						continue;
					} else {
						isGood = 0;
						break;
					}
				}
				bracket.push(rawBracket[i]);
			}
			if (bracket.isEmpty() && isGood == 1)
				System.out.printf("#%d %d\n", test_case, isGood);
			else
				System.out.printf("#%d %d\n", test_case, isGood);

		}
	}
}
