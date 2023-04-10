package prob005648;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int[][] field;
	static int[] timeline;
	static HashMap<Integer, List<int[]>> atom;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			field = new int[2001][2001];
			timeline = new int[1001];
			atom = new HashMap<>();
			for (int dir = 0; dir < 4; dir++) {
				atom.put(dir, new ArrayList<>());
			}
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt() + 1000;
				int y = sc.nextInt() + 1000;
				int[] point = { y, x };
				int dir = sc.nextInt();
				int energy = sc.nextInt();
				
				field[y][x] = energy;
				atom.get(dir).add(point);
			}
		} // tc
	}
}
