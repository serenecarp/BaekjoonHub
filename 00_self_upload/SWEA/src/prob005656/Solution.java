package prob005656;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Block {
	// blockPile의 i번째 list,
	// list의 j번째 블록
	int i;
	int j;
	// 블록의 영향력
	int pow;

	public Block(int i, int j, int pow) {
		this.i = i;
		this.j = j;
		this.pow = pow;
	}
}

public class Solution {
	static List<Integer>[] blockPile;
	static Queue<Block> blockToBoom;
	static Stack<Block> blockToRestore;

	static int minBlocks;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int W = sc.nextInt();
			int H = sc.nextInt();
			// 벽돌을 90도 시계방향 회전한 형태로, 가로로 눕혀 리스트로 입력
			// 리스트로 받는 이유는, 블록이 폭발 후 떨어졌을 때 쉽게 처리하기 위함
			blockPile = new ArrayList[W];
			for (int i = 0; i < blockPile.length; i++) {
				blockPile[i] = new ArrayList<>();
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					int val = sc.nextInt();
					if (val != 0)
						blockPile[j].add(0, val);
				}
			}

			blockToBoom = new LinkedList<>();
			blockToRestore = new Stack<>();
			minBlocks = Integer.MAX_VALUE;
			boom(N);

			System.out.printf("#%d %d\n", testCase, minBlocks);

		} // tc
	}

	static void boom(int N) {
		// base
		if (N == 0) {
			int cnt = countBlocks();
			if (minBlocks > cnt) {
				minBlocks = cnt;
			}
			return;
		}
		// recursive
		for (int i = 0; i < blockPile.length; i++) {

			findBlocksToBoom(i);
			applyGravity();
			boom(N - 1);
			restoration();
		}
	}

	static void findBlocksToBoom(int idx) {

		int top = blockPile[idx].size() - 1;
		if (top < 0) {
			return;
		}
		Block block = new Block(idx, top, blockPile[idx].get(top));

		// 블록의 파괴력이 1보다 크면 while문 안에서 따로 처리
		// 그렇지 않으면 자신만 파괴되므로 따로 처리 x
		if (blockPile[idx].get(top) > 1) {
			blockToBoom.add(block);
		} else {
			blockToRestore.push(block);
		}
		blockPile[idx].set(top, 0);

		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };
		while (!blockToBoom.isEmpty()) {
			Block tmp = blockToBoom.poll();
			int i = tmp.i;
			int j = tmp.j;

			for (int dir = 0; dir < 4; dir++) {
				for (int pow = 0; pow < tmp.pow - 1; pow++) {
					int ni = i + di[dir];
					int nj = j + dj[dir];
					if (ni >= blockPile.length || ni < 0 || nj >= blockPile[ni].size() || nj < 0) {
						continue;
					}

					// 블록의 파괴력이 1보다 크면 while문 안에서 따로 처리
					// 그렇지 않으면 자신만 파괴되므로 따로 처리 x
					if (blockPile[ni].get(nj) > 1) {
						blockToBoom.add(new Block(ni, nj, blockPile[ni].get(nj)));
					} else if (blockPile[ni].get(nj) == 1) {
						blockToRestore.push(new Block(ni, nj, blockPile[ni].get(nj)));
					}
					blockPile[ni].set(nj, 0);

				}
			}
		}
		blockToRestore.push(new Block(-1, -1, -1));
	}

	static void restoration() {
		if (!blockToRestore.isEmpty())
			blockToRestore.pop();
		while (!blockToRestore.isEmpty()) {
			Block tmp = blockToRestore.pop();
			if (!blockToRestore.isEmpty() && blockToRestore.peek().pow == -1) {
				break;
			}
			System.out.println(blockPile.length);
			System.out.println(blockPile[tmp.i].size());
			System.out.println(tmp.i + " " + tmp.j);
			blockPile[tmp.i].add(tmp.j, tmp.pow);

		}
	}

	static void applyGravity() {
		for (int i = 0; i < blockPile.length; i++) {
			for (int j = blockPile[i].size() - 1; j >= 0; j--) {
				if (blockPile[i].get(j) == 0) {
					blockPile[i].remove(j);
				}
			}
		}
	}

	static int countBlocks() {
		int count = 0;
		for (int i = 0; i < blockPile.length; i++) {
			count += blockPile[i].size();
		}
		return count;
	}

	static void printBlocks() {
		for (int i = 0; i < blockPile.length; i++) {
			System.out.println(blockPile[i]);
		}
	}
}
