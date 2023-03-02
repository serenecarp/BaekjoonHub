
import java.io.FileNotFoundException;
import java.util.Scanner;

// 각 노드 정의
// 계산값(double), 연산자, left child, right child
class Node {
	double value;
	char operator;
	int leftIdx;
	int rightIdx;

	// internal node일 경우
	// 연산자, 왼쪽, 오른쪽
	public Node(char operator, int leftIdx, int rightIdx) {
		this.operator = operator;
		this.leftIdx = leftIdx;
		this.rightIdx = rightIdx;
	}

	// external node (== leaf node)일 경우
	// 값
	public Node(double value) {
		this.value = value;
	}
}

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 노드 개수 입력
			int N = sc.nextInt();
			// 트리 생성(인덱스를 편하게 쓰기 위해 N+1 크기로)
			Node[] tree = new Node[N + 1];
			for (int i = 1; i <= N; i++) {
				// curr: 현재 노드의 인덱스
				int curr = sc.nextInt();
				// sth: 인덱스 다음에 나온 something => internal인지 external인지에 따라, 연산자가 나올 수도, 그냥 값이 나올
				// 수도
				String sth = sc.next();

				// sth이 연산자였다면 (isDigit이 아니었다면) <= internal node
				if (!Character.isDigit(sth.charAt(0))) {
					// 해당 노드를 {연산자, 왼쪽, 오른쪽}으로 생성 (값은 비어 있다)
					tree[curr] = new Node(sth.charAt(0), sc.nextInt(), sc.nextInt());
				}
				// sth이 연산자가 아니였다면 (그냥 숫자가 나왔다면) <= external node
				else {
					// 해당 노드를 {값}만 생성 (연산자, 왼쪽, 오른쪽은 비었다)
					tree[curr] = new Node(Double.parseDouble(sth));
				}
			}
			// 답을 구하고 출력
			double answer = 0;
			System.out.printf("#%d %d\n", test_case, (int) calculate(tree, 1, answer));
		}
	}

	// 계산해주는 재귀함수
	static double calculate(Node[] tree, int idx, double answer) {
		// 노드의 좌우가 존재한다면 (좌우가 둘다 있거나 둘다 없을 것이라, 왼쪽만 검사)
		// == internal node라면
		// (왼쪽의 결과물)과 (오른쪽 결과물)을 계산해 (현재 노드의 결과물)을 만든다.
		if (tree[tree[idx].leftIdx] != null) {
			answer = operate(tree[idx].operator, calculate(tree, tree[idx].leftIdx, answer),
					calculate(tree, tree[idx].rightIdx, answer));
		}
		// 좌우 노드가 없다면
		// == external node라면
		// 그 값을 결과물로 제출한다.
		else {
			answer = tree[idx].value;
		}

		return answer;
	}

	// 사칙연산 해주는 메소드
	static double operate(char operator, double a, double b) {
		if (operator == '+') {
			return a + b;
		} else if (operator == '-') {
			return a - b;
		} else if (operator == '*') {
			return a * b;
		} else {
			return a / b;
		}

	}

}
