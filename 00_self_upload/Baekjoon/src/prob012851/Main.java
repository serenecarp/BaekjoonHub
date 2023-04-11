package prob012851;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Queue<Integer> queue;
	static int minT;
	static int ways;
	static int young;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int subin = sc.nextInt();
		young = sc.nextInt();
		queue = new LinkedList<>();
		queue.offer(subin);
		BFS();
		System.out.println(minT);
		System.out.println(ways);
	}

	static void BFS() {
		boolean found = false;
		while (!queue.isEmpty()) {
			minT++;
			int now = queue.poll();

			if (now == young) {
				found = true;
				ways++;
			}
			if (!found) {
				queue.offer(now * 2);
				queue.offer(now + 1);
				queue.offer(now - 1);
			}

		}
	}

}
