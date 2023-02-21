
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
			// 수식 입력 (char배열)
			int lengthOfInfix = sc.nextInt();
			char[] infix = sc.next().toCharArray();

			// 1. infix식을 postfix식으로 바꿔 담을 큐
			// -> 앞에서 쭉 읽는 데에 queue가 좋을 것 같았다.
			// 2. postfix로 바꿀 때 필요한 연산자용 스택
			// 3. postfix를 계산할 때 필요한 피연산자용 스택
			Queue<Character> postfix = new LinkedList<>();
			Stack<Character> operator = new Stack<>();
			Stack<Integer> operand = new Stack<>();

			// infix를 postfix로
			for (int i = 0; i < infix.length; i++) {
				// 원소가 (일의 자리) 숫자이면 그냥 postfix에 담는다.
				if (infix[i] >= '0') {
					postfix.add(infix[i]);
				}
				// 원소가 연산자이면 stack에 담는다.
				else if (infix[i] == '+') {
					// 스택이 비어 있으면 그냥 넣고
					if (operator.isEmpty()) {
						operator.push(infix[i]);
					}
					// 비어있지 않다면
					// 스택에 자신보다 우선순위가 높거나 같은(==높은) 녀석이 있으면
					// 그 친구를 pop해서 postfix에 넣고, 나는 스택에 push한다.
					else {
						postfix.add(operator.peek());
						operator.pop();
						operator.push(infix[i]);
					}
				}
			}
			
			// infix식을 다 돌고, 연산자 스택에 남은 애들은
			// postfix에 다 들여보낸다.
			while (!operator.isEmpty()) {
				postfix.add(operator.peek());
				operator.pop();
			}

			// 이제 계산을 돌린다.
			// 연산자가 다 없어질 때까지 계산한다.
			while (!postfix.isEmpty()) {
				// postfix를 돌면서 나온 것이 숫자라면
				// 피연산자 스택에 (int 형태로) push한다.
				if (postfix.peek() >= '0') {
					operand.push(postfix.poll() - '0');
				}
				// 연산자라면 (이 경우 +밖에 없지만)
				// 해당 연산자로 제일 위의 피연산자를 계산한 뒤
				// 그 값을 push한다.
				else if (postfix.peek() == '+') {
					postfix.poll();
					int num1 = operand.peek();
					operand.pop();
					int num2 = operand.peek();
					operand.pop();
					operand.push(num1 + num2);
				}
			}
			// 마지막에 스택에 남은 최종 결과를 출력한다.
			System.out.printf("#%d %d\n", test_case, operand.peek());
		}
	}
}