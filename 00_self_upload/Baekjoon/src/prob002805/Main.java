package prob002805;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Map<Integer, Integer> tree = new HashMap<>();

		int maxH = 0;
		for (int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			if (tree.containsKey(tmp)) {
				tree.replace(tmp, tree.get(tmp) + 1);
			} else {
				tree.put(tmp, 1);
			}
			if (tmp > maxH) {
				maxH = tmp;
			}
		}
		Map<Integer, Integer> sortedTree = new TreeMap<>(tree);
		int count = 0;
		int log = 0;
		int answer = 0;
		for (int h = maxH; h >= 0; h--) {
			log += count;
			if (log >= M) {
				answer = h;
				break;
			}
			if (sortedTree.containsKey(h)) {
				count += sortedTree.get(h);
			}
		}
		System.out.println(answer);

	}
}
