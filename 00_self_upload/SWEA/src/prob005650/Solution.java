package prob005650;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Wormhole {
	int i;
	int j;

	public Wormhole(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class Solution {
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static HashMap<Integer, List<Wormhole>> holes;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			board = new int[N][N];
			holes = new HashMap<>();
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tmp = sc.nextInt();
					board[i][j] = tmp;
					// 웜홀일 경우 웜홀의 정보 저장
					if (tmp >= 6) {
						if (!holes.containsKey(tmp)) {
							holes.put(tmp, new ArrayList<>());
						}
						holes.get(tmp).add(new Wormhole(i, j));
					}
				}
			}
			answer = Integer.MIN_VALUE;
			// 우방향 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 방문하지 않았거나 빈 공간이면 핀볼 게임을 실행한다.

					if (!visited[i][j] && board[i][j] == 0) {
						int score = pinball(i, j, 0, 0);
						if (answer < score) {
							answer = score;
						}
					}
					// 우측탐색: 전부 다 같은 케이스이므로 다 거름
					while (board[i][j] != 0) {
						visited[i][j] = true;
						j++;
						if (j >= N)
							break;
					}
				}
			}
			// 하방향 탐색
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					// 방문하지 않았거나 빈 공간이면 핀볼 게임을 실행한다.
					if (!visited[i][j] && board[i][j] == 0) {
						int score = pinball(i, j, 0, 1);
						if (answer < score) {
							answer = score;
						}
					}
					// 하방탐색: 전부 다 같은 케이스이므로 다 거름
					while (board[i][j] != 0) {
						visited[i][j] = true;
						i++;
						if (i >= N)
							break;
					}
				}
			}
			// 좌방향 탐색
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					// 방문하지 않았거나 빈 공간이면 핀볼 게임을 실행한다.
					if (!visited[i][j] && board[i][j] == 0) {
						int score = pinball(i, j, 0, 2);
						if (answer < score) {
							answer = score;
						}
					}
					// 좌측탐색: 전부 다 같은 케이스이므로 다 거름
					while (board[i][j] != 0) {
						visited[i][j] = true;
						j--;
						if (j < 0)
							break;
					}
				}
			}
			// 상방향 탐색
			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i >= 0; i--) {
					// 방문하지 않았거나 빈 공간이면 핀볼 게임을 실행한다.
					if (!visited[i][j] && board[i][j] == 0) {
						int score = pinball(i, j, 0, 3);
						if (answer < score) {
							answer = score;
						}
					}
					// 상방탐색: 전부 다 같은 케이스이므로 다 거름
					while (board[i][j] != 0) {
						visited[i][j] = true;
						i++;
					}
					if (i < 0)
						break;
				}
			}
			System.out.printf("#%d %d\n", testCase, answer);
		} // tc
	}

	public static int pinball(int i, int j, int dir, int score) {
		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };
		int ni = i + di[dir];
		int nj = j + dj[dir];
		while (ni == i && nj == j) {

			if (ni < 0 || nj < 0 || ni >= N || nj >= N || board[ni][nj] == 5) {
				return reflect(score);
			} else if (board[ni][nj] == -1) {
				return score;
			} else if (board[ni][nj] >= 6) {
				for (int k = 0; k <= 1; k++) {
					if (ni != holes.get(board[ni][nj]).get(k).i || nj != holes.get(board[ni][nj]).get(k).j) {
						ni = holes.get(board[ni][nj]).get(k).i;
						nj = holes.get(board[ni][nj]).get(k).j;
						break;
					}
				}
			} else if (board[ni][nj] != 0) {
				int block = board[ni][nj];
				switch (dir) {
				case 0:
					if (block == 1 || block == 2)
						return reflect(score);
					else if (block == 3)
						dir++;
					else
						dir--;
					break;
				case 1:
					if (block == 2 || block == 3)
						return reflect(score);
					else if (block == 4)
						dir++;
					else
						dir--;
					break;
				case 2:
					if (block == 3 || block == 4)
						return reflect(score);
					else if (block == 1)
						dir++;
					else
						dir--;
					break;
				case 3:
					if (block == 4 || block == 1)
						return reflect(score);
					else if (block == 2)
						dir = 0;
					else
						dir--;
					break;
				}
				score++;
			} else {
				ni = i + di[dir];
				nj = j + dj[dir];
			}
		}
		return score;
	}

	public static int reflect(int score) {
		return 2 * score + 1;
	}
}
