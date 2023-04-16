package prob001918;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String infix = sc.next();
		List<Character> postfix = new ArrayList<>();
		Stack<Character> operator = new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
			char o = infix.charAt(i);
			if (isOperator(o)) {
				if (operator.isEmpty())
					operator.push(o);
				else {
					if (o == ')') {
						while (operator.peek() != '(') {
							char oper = operator.pop();
							postfix.add(oper);
						}
						operator.pop();
					} else if (o == '(')
						operator.add(o);
					else if (priority(operator.peek()) >= priority(o)) {
						while (priority(operator.peek()) >= priority(o)) {
							char oper = operator.pop();
							postfix.add(oper);
							if (operator.isEmpty())
								break;
						}
						operator.push(o);
					} else {
						operator.add(o);
					}

				}
			} else
				postfix.add(o);
		}
		while (!operator.isEmpty()) {
			char oper = operator.pop();
			postfix.add(oper);
		}

		for (int i = 0; i < postfix.size(); i++)
			System.out.print(postfix.get(i));
	}

	static boolean isOperator(char o) {
		if (o == '*' || o == '/' || o == '+' || o == '-' || o == '(' || o == ')')
			return true;
		else
			return false;
	}

	static int priority(char o) {
		if (o == '*' || o == '/')
			return 2;
		else if (o == '+' || o == '-')
			return 1;
		else
			return 0;
	}
}
