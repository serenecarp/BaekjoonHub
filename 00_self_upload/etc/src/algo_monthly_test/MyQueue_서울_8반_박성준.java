package algo_monthly_test;

/*
 * # 원형큐 (배열 구현)
 * 
 * ## 배경
 * 큐는 원래 선입선출 구조로, 먼저 들어온 원소가 먼저 나간다.
 * 원형큐도 큐의 일종으로서 마찬가지의 특징을 가지고 있다.
 * 그러나 일반 선형 큐의 경우 계속 enQueue deQueue 작업을 수행하다가
 * rear의 index가 결국 배열의 최대 크기를 넘어서서 큐가 작동하지 못하게 되는 경우가 생긴다.
 * 이 경우 선형큐의 원소를 계속 앞으로 당겨주는 작업을 수행하는 등 비효율적인 과정을 수반해야하는데,
 * 이런 문제를 해소하고자 원형큐라는 아이디어가 제시되었다.
 * 
 * ## 설명
 * 선입선출 구조이다.
 * 값이 들어올 부분인 rear와 값이 나가는 부분인 front로 구성된다.
 * 초기 front와 rear는 0으로 시작하며, '두 값이 같은 경우'를 큐가 비어 있는 경우로 생각한다.
 * [<-- 맨 앞에서 나가고, 맨 뒤로 들어온다고 생각 <--]
 * front는 맨 앞 원소의 바로 앞을 가리키고, rear는 맨 뒤 원소를 가리킨다.
 * (즉 front는 큐의 어떤 원소를 가리키지 않고 맨 앞 원소의 앞쪽 허공을 가리킨다.)
 * 
 * 값을 계속 enQueue하며 rear가 원형큐를 한 바퀴 돌아 front의 직전까지 왔을 때를-
 * -큐가 가득 차 있는 경우로 본다.
 * 따라서 원형큐가 비어 있는 경우를 구분하기 위해 한 칸의 여유를 두고 배열을 생성하도록 한다.
 * 
 * 아래 원형큐 클래스는 배열로 구현했으므로,
 * 배열의 index가 배열의 크기를 넘어가지 않고 계속 순환하도록 하기 위해
 * 배열의 index를 배열의 크기로 나눈 나머지로 설정해준다.
 * 
 * 
 */

public class MyQueue_서울_8반_박성준 {
	int size;
	int[] queue;
	int front = 0;
	int rear = 0;

	// 원형큐는 큐가 비어있을 때를 쉽게 구분해주기 위해서
	// size를 원하는 것보다 +1해서 만들어 주고,
	// 비어 있을 때의 조건은 front==rear일 때로 한다.
	public MyQueue_서울_8반_박성준(int size) {
		this.size = size + 1;
		this.queue = new int[this.size];
	}

	// 원형큐가 비어 있을 때
	// front와 rear가 같을 때 true
	public boolean isEmpty() {
		if (this.front == this.rear) {
			return true;
		} else {
			return false;
		}
	}

	// 원형큐가 다 찼을 때
	// rear+1을 했을 때 front와 같다면 가득 찬 것
	// (rear가 원형큐를 한바퀴 돌아 시작점 전까지 왔을 때)
	public boolean isFull() {
		if ((this.rear + 1) % this.size == this.front) {
			return true;
		} else {
			return false;
		}
	}

	// 원형큐에 원소를 삽입
	// rear를 +1 해주고 그 자리에 삽입
	public void enQueue(int value) {
		if (isFull()) {
			System.out.println("원형큐가 가득 찼어요.");
		} else {
			queue[++this.rear % this.size] = value;
		}
	}

	// 원형큐에서 원소를 삭제 및 반환
	// front를 +1 하고 그 자리의 원소를 삭제 및 반환
	public int deQueue() {
		if (isEmpty()) {
			System.out.println("원형큐가 비어 있어요.");
			return -1;
		} else {
			int temp = queue[++this.front % this.size];
			queue[front % this.size] = 0; // 원소 초기화
			return temp;
		}

	}
}
