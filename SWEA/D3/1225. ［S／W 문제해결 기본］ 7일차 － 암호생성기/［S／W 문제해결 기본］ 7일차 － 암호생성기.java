
import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {


		Scanner sc = new Scanner(System.in);
		int T = 10;
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt();
			System.out.printf("#%d ", test_case);
			// 마이큐 객체 생성 (원형큐)
			MyQueue password = new MyQueue();
			// 큐에 입력값 enQueue
			for (int i = 0; i < 8; i++) {
				password.enQueue(sc.nextInt());
			}
			// 사이클을 계속 돌고 최종 형태가 되면 출력
			password.cycle();
			password.print();
			// 줄바꿈
			System.out.println();
		}
	}
}

// 8개의 데이터를 담을 수 있는 원형큐 (size == 8+1)
class MyQueue {
	int qSize = 9;
	int[] password;
	int front;
	int rear;

	public MyQueue() {
		this.password = new int[qSize];
		this.front = 0;
		this.rear = 0;
		this.password[front] = -1;
	}

	// 안씀
	public boolean isEmpty() {
		if (this.front == this.rear) {
			return true;
		} else {
			return false;
		}
	}
	// 안씀
	public boolean isFull() {
		if ((this.rear + 1) % qSize == this.front) {
			return true;
		} else {
			return false;
		}
	}

	// 원형큐에 데이터 삽입
	public void enQueue(int n) {
		rear = ++rear % qSize;
		password[rear] = n;
	}

	// 원형큐에서 데이터 삭제
	public int deQueue() {
		front = ++front % qSize;
		return password[front];
	}

	// 문제에서 주어진 사이클을 돌리는 메소드
	public void cycle() {
		int count = 1;
		// 맨앞에서 값을 빼고 count(1~5)를 뺀다
		int temp = deQueue() - count;

		while (temp > 0) {
			// 맨앞 값에서 count를 뺀 값을
			// 맨 뒤에 enQueue해준다.
			enQueue(temp);
			count = count % 5 + 1;
			temp = deQueue() - count;
		}
		// 그 맨 앞에서 count 뺐는데 0보다 작거나 같아지면 반복문을 그만 두고
		// 그 값을 0으로 만들어 enQueue해준다.
		enQueue(0);
	}

	// 0이 된 녀석은 누구인가?
	public int isZero() {
		int imZero = 0;
		for (int i = 0; i < this.password.length; i++) {
			if (password[i] == 0) {
				imZero = i;
				break;
			}
		}
		return imZero;
	}

	// 0이 된 녀석의 다음 값(== 맨 처음 값)부터
	// 0이 된 녀석까지 출력
	public void print() {
		for (int i = 1; i <= password.length - 1; i++) {
			System.out.printf("%d ", this.password[(isZero() + i + 1) % qSize]);
		}
		
	}
}