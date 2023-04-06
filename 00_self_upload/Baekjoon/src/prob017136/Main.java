package prob017136;

import java.util.Arrays;
import java.util.Scanner;

// 좌표를 탐색하면서 1이 발견되면
// 그 곳에서 최대한 큰 정사각형을 찾아 바로 집어 넣는 방식이었다. (greedy)

// 그러나..
// 1 1 1 1 1 1 1 1
// 1 1 1 1 1 1 1 1
// 1 1 1 1 1 1 1 1
// 1 1 1 1 1 1 1 1
// 1 1 1 1 1 1 1 1
// 1 1 1 1 1 1 1 1
// 1 1 1 1 1 1 1 1
// 1 1 1 1 1 1 1 1
// 이 경우 바로 5*5를 붙이는 것보다 4*4를 4개 붙이는 것이 낫다.
// => 최대 정사각형을 바로 넣는 것이 정답이 아니었다.
// 예제 7번에서도, 바로 큰 정사각형을 넣어버리면 다른 좌표에서 더 큰 정사각형을 못 넣게 될 수도 있다.

// 폐기!


public class Main {
	static int[][] paperMain;
	static int answer;
	static int[] paper;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		paper = new int[5];
		Arrays.fill(paper, 5);

		paperMain = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				paperMain[i][j] = sc.nextInt();
			}
		}
		answer = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (paperMain[i][j] == 1) {
					boolean possible = DFS(0, i, j);
					if (!possible) {
						answer = -1;
						break;
					}
				}
			}
		}
		System.out.println(countPaper());
	}

	static boolean DFS(int depth, int i, int j) {
		if (depth == 5) {
			visit(depth, i, j);
			paper[depth - 1]--;
			if (paper[depth - 1] < 0)
				return false;
			return true;
		}

		for (int k = j; k < j + depth; k++) {
			if (paperMain[i + depth][k] != 1) {
				visit(depth, i, j);
				paper[depth - 1]--;
				if (paper[depth - 1] < 0)
					return false;
				return true;
			}
		}
		for (int k = i + depth; k >= i; k--) {
			if (paperMain[k][j + depth] != 1) {
				visit(depth, i, j);
				paper[depth - 1]--;
				if (paper[depth - 1] < 0)
					return false;
				return true;
			}
		}
		return DFS(depth + 1, i, j);
	}

	static void visit(int depth, int i, int j) {
		for (int k = i; k < i + depth; k++) {
			for (int l = j; l < j + depth; l++) {
				paperMain[k][l] = 0;
			}
		}
	}

	static int countPaper() {
		int answer = 0;
		for (int i = 0; i < 5; i++) {
			answer += 5 - paper[i];
		}
		return answer;
	}
}
