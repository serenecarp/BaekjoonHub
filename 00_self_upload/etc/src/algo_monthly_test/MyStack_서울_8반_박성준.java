package algo_monthly_test;
/*
 * 스택 (배열 구현)
 * Last-in-First-out, 가장 최근에 들어온 원소가 먼저 나가는 자료구조이다.
 * 
 * 스택의 구조를 마치 프링글스 통(하단이 막혀 있고 상단이 뚫린 원통형 용기)처럼 생각하자면..
 * push()로 원소를 들여보내고, pop()으로 원소를 빼 내는데,
 * 먼저 push된 원소는 스택의 아래에 깔려 있게 되고
 * 나중에 push된 원소일수록 스택의 상단에 쌓이게 된다.
 * 
 * 가장 상단의 원소 index를 가리키는 'top' 변수에 따라
 * top의 원소를 삭제(pop)하거나 top의 위로 새로운 원소를 추가할 수 있다.
 * 
 * 스택이 비어있는 경우 top = -1로 설정해 주었고,
 * 스택이 가득찬 경우는 top = (배열의 크기-1)이다.
 */

public class MyStack_서울_8반_박성준 {
	// 배열로 구현한 스택의 크기
	// 스택을 구현한 배열
	// 최상단의 원소 index(비어있을 경우 -1)
	int size;
	int[] stack; // 정수형 스택
	int top = -1;

	// 스택 생성자
	public MyStack_서울_8반_박성준(int size) {
		this.size = size;
		this.stack = new int[size];
	}

	// 스택이 비어있는지 여부를 반환하는 메소드
	// top == -1이면 비어 있음
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	// 스택이 가득 찼는지 여부를 반환하는 메소드
	// top == 스택크기-1 이면 가득 참
	public boolean isFull() {
		if (this.top == this.size - 1) {
			return true;
		} else {
			return false;
		}
	}

	// 스택에 새로운 원소를 추가하는 메소드
	// top을 한 칸 올리고 그 자리에 새 값을 추가
	public void push(int value) {
		if (isFull()) {
			System.out.println("스택이 가득 찼어요.");
		} else {
			stack[++top] = value;
		}
	}

	// 스택의 가장 위에 있는 원소(가장 최근 투입된 원소)를 삭제하는 메소드
	// 삭제한 원소를 반환
	public int pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어 있어요.");
			return -1;
		} else {
			int temp = stack[top];
			stack[top--] = 0;
			return temp;
		}

	}

}
