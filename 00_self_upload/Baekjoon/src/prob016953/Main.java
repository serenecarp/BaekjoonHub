package prob016953;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int countMin = Integer.MAX_VALUE;
	static Queue<Integer> queue;
	static int B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		B = sc.nextInt();

		queue = new LinkedList<>();
		queue.offer(A);

		if (countMin == Integer.MAX_VALUE)
			countMin = -1;
		System.out.println(countMin);
	}

	static void BFS() {
		int count = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			count++;
			if (now == B) {
				countMin = count;
				return;
			}

			int next = now * 10 + 1;
			int next2 = now * 2;
			if (next <= B)
				queue.offer(next);
			if (next2 <= B)
				queue.offer(next2);
		}
	}
}
