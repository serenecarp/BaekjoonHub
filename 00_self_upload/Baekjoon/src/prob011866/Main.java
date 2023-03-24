package prob011866;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		List<Integer> answer = new ArrayList<>();
		while (!queue.isEmpty()) {
			for (int i = 0; i < K; i++) {
				int tmp = queue.poll();
				if (i == K - 1) {
					answer.add(tmp);
					break;
				}
				queue.offer(tmp);
			}
		}
		System.out.print('<');
		for (int i = 0; i < answer.size(); i++) {
			if (i == answer.size() - 1) {
				System.out.print(answer.get(i) + ">");
				break;
			}
			System.out.print(answer.get(i) + ", ");
		}
	}
}
