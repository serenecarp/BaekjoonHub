package prob001289;

import java.util.Scanner;

public class Solution1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			char[] temp = sc.next().toCharArray();
			MyQueue memory = new MyQueue(temp.length);
			// memory 큐에 입력값 넣기
			for (int i = 0; i < temp.length; i++) {
				memory.enQueue(temp[i] - '0');
			}
			// 바꿔야 할 횟수 count 세어주기
			// 기본: 0에서 바뀌면 count++, 이후로 또 값이 바뀌면 count++
			int count = 0;
			int defaultBit = 0;
			for (int i = 0; i < memory.qSize; i++) {
				int currentBit = memory.deQueue();
				if (currentBit != defaultBit) {
					count++;
					defaultBit = currentBit;
				}
			}
			System.out.printf("#%d %d\n", test_case, count);
		}
	}
}

// 문제에서 필요한 기능만 넣은 큐 정의
class MyQueue {
	int qSize;
	int front;
	int rear;
	int[] MyQueue;

	// 생성자
	public MyQueue(int qSize) {
		super();
		this.qSize = qSize;
		this.front = -1;
		this.rear = -1;
		this.MyQueue = new int[qSize];
	}

	// 원소 넣기
	public void enQueue(int n) {
		this.MyQueue[++rear] = n;
	}

	// 원소 빼고 뺀 원소 리턴
	public int deQueue() {
		return this.MyQueue[++this.front];
	}

	// 비어있는지 확인 (안씀)
	public boolean isEmpty() {
		if (rear == front) {
			return true;
		} else {
			return false;
		}
	}
}