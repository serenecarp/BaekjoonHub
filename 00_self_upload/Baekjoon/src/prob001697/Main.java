package prob001697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Subin {
	int loc;
	int cnt;

	public Subin(int loc) {
		this.loc = loc;
		this.cnt = 0;
	}

	public Subin(int loc, int cnt) {
		this.loc = loc;
		this.cnt = cnt;
	}
}

public class Main {
	static int young;
	static boolean[] visited = new boolean[100001];
	static Queue<Subin> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loc = sc.nextInt();
		Subin subin = new Subin(loc);
		young = sc.nextInt();
		visited[loc] = true;
		queue.add(subin);
		while (!queue.isEmpty()) {
			Subin now = queue.poll();

			if (now.loc == young) {
				System.out.println(now.cnt);
				break;
			}
			if (loc * 2 <= 100000 && !visited[loc * 2]) {
				Subin next1 = new Subin(loc * 2, now.cnt++);
				visited[next1.loc] = true;
				queue.offer(next1);
			}
			if (loc + 1 <= 100000 && !visited[loc + 1]) {
				Subin next2 = new Subin(loc + 1, now.cnt++);
				visited[next2.loc] = true;
				queue.offer(next2);
			}
			if (loc - 1 >= 0 && !visited[loc - 1]) {
				Subin next3 = new Subin(loc - 1, now.cnt--);
				visited[next3.loc] = true;
				queue.offer(next3);
			}
		}
	}
}
