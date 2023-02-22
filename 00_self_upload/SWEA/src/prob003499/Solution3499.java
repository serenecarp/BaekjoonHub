package prob003499;

import java.util.Scanner;

class Solution3499 {
	public static void main(String args[]) throws Exception {

		// 1. 문제에서 필요한 기능만 눌러담은 MyQueue 클래스를 구현한다.
		// 2. 두 개의 MyQueue 객체를 생성한다.
		// 3. 입력값을 MyQueue에 반반씩 받는다(String).
		// 4. 두 MyQueue를 번갈아가며 deQueue하면서 출력한다.

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.printf("#%d ", test_case);
			// 전체 입력값 길이와, 큐들이 나눠가질 길이 (== 큐의 길이)
			int N = sc.nextInt();
			int queueSize = N / 2 + N % 2;
			// 카드덱 2개 객체 생성 
			MyQueue deck1 = new MyQueue(queueSize);
			MyQueue deck2 = new MyQueue(queueSize);
			// 전체 입력값을 반반 나눠 가짐
			for (int i = 0; i < queueSize; i++) {
				deck1.enQueue(sc.next());
			}
			for (int i = queueSize; i < N; i++) {
				deck2.enQueue(sc.next());
			}

			// 두 덱이 모두 비게 될 때까지 deQueue (출력)
			while (!deck1.isEmpty() || !deck2.isEmpty()) {
				deck1.deQueue();
				deck2.deQueue();
			}
			// 줄바꿈
			System.out.println();
		}
	}
}

// 이번 문제에서 필요한 부분만 큐 기능 구현
class MyQueue {

	public int size;
	public int front = -1;
	public int rear = -1;
	public String[] MyQueue;

	public MyQueue(int size) {
		this.size = size;
		this.MyQueue = new String[size];
	}

	// String을 입력받아 MyQueue배열에 저장
	public void enQueue(String arg) {
		MyQueue[++this.rear] = arg;
	}

	// MyQueue의 맨 앞 원소를 출력하고 제거해줌
	public void deQueue() {
		if (!isEmpty()) {
			System.out.print(this.MyQueue[++front] + " ");
		}
	}

	// MyQueue가 비어 있는지 확인
	public boolean isEmpty() {
		if (this.front >= this.rear) {
			return true;
		} else {
			return false;
		}
	}
	
	// 디버깅용 MyQueue 출력 메소드
	public void print() {
		System.out.println();
		for(int i=0; i<=this.rear; i++) {
			System.out.print(this.MyQueue[i] +" ");
		}
		System.out.println();
	}
}