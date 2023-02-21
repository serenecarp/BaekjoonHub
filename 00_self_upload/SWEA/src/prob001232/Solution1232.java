package prob001232;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

class Solution1232 {

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("C:\\Users\\SSAFY\\Desktop\\input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int treeSize = sc.nextInt();
			Node[] nodes = new Node[treeSize];
			for (int i = 0; i < treeSize; i++) {
				Node iNode = new Node();
				int nodeNum = sc.nextInt() - 1;
				iNode.value = sc.next().charAt(0);
				// 자식이 없을 조건
				if (nodeNum + 1 > treeSize / 2) {
					nodes[i] = iNode;
					continue;
				}
				// 자식이 존재하면 달아줌
				// **********************   ????
				iNode.left = nodes[sc.nextInt()-1];
				iNode.right = nodes[sc.nextInt()-1];
			}
			// post-order traversal 연산 결과 출력
		}
	}
}

class Node {
	static Stack<Integer> operand = new Stack<>();

	char value;
	Node left;
	Node right;

	// post-order traversal
	void postOrder(Node node) {
		if (node == null) {
			return;
		}
		// **********************    ????
		postOrder(node.left);
		postOrder(node.right);
		
		if (node.value >= '0') {
			operand.push(node.value - '0');
		} else {
			if (node.value == '+') {
				int num1 = operand.peek();
				operand.pop();
				int num2 = operand.peek();
				operand.pop();
				operand.push(num1 + num2);
			} else if (node.value == '-') {
				int num1 = operand.peek();
				operand.pop();
				int num2 = operand.peek();
				operand.pop();
				operand.push(num1 - num2);
			} else if (node.value == '*') {
				int num1 = operand.peek();
				operand.pop();
				int num2 = operand.peek();
				operand.pop();
				operand.push(num1 * num2);
			} else {
				int num1 = operand.peek();
				operand.pop();
				int num2 = operand.peek();
				operand.pop();
				operand.push(num1 / num2);
			}
		}
		System.out.println(operand.peek());
	}

}
