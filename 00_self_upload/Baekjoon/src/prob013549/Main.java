package prob013549;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Subin {
	int num;
	int time;

	public Subin(int num, int time) {
		this.num = num;
		this.time = time;
	}
}

public class Main {
	static boolean[] visited = new boolean[100001];
	static int young, minT = Integer.MAX_VALUE;
	static Queue<Subin> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int subin = sc.nextInt();
		young = sc.nextInt();
		queue = new LinkedList<>();

		Subin st = new Subin(subin, 0);
		queue.offer(st);
		BFS();
		System.out.println(minT);
	}

	static void BFS() {
		while (!queue.isEmpty()) {
			Subin now = queue.poll();
			visited[now.num] = true;
			if (now.num == young) {
				minT = Math.min(minT, now.time);
			}

			Subin next1 = new Subin(now.num * 2, now.time);
			Subin next2 = new Subin(now.num + 1, now.time + 1);
			Subin next3 = new Subin(now.num - 1, now.time + 1);

			if (next1.num <= 100000 && !visited[next1.num]) {
				queue.offer(next1);
			}
			if (next2.num <= 100000 && !visited[next2.num]) {
				queue.offer(next2);
			}
			if (next3.num >= 0 && !visited[next3.num]) {
				queue.offer(next3);
			}

		}
	}
}
