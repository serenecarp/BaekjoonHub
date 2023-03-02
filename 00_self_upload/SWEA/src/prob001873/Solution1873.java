package prob001873;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1873 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] field = new char[H][W];
			int idx = 0;
			int jdx = 0;
			// 상 우 하 좌 == 0 1 2 3
			int[] di = { -1, 0, 1, 0 };
			int[] dj = { 0, 1, 0, -1 };
			int dir = 0;
			for (int i = 0; i < H; i++) {
				field[i] = sc.next().toCharArray();
				for (int j = 0; j < W; j++) {
					if (field[i][j] == '^' || field[i][j] == '>' || field[i][j] == 'v' || field[i][j] == '<') {
						idx = i;
						jdx = j;

						switch (field[i][j]) {
						case '^':
							dir = 0;
							break;
						case '>':
							dir = 1;
							break;
						case 'v':
							dir = 2;
							break;
						case '<':
							dir = 3;
							break;
						}
					}
				}
			}

			int acts = sc.nextInt();
			String commands = sc.next();
			for (int actNo = 0; actNo < acts; actNo++) {
				char act = commands.charAt(actNo);
				int nidx = idx;
				int njdx = jdx;
				if (act == 'S') {
					while (nidx >= 0 && nidx < H && njdx >= 0 && njdx < W && field[nidx][njdx] != '*'
							&& field[nidx][njdx] != '#') {
						System.out.println(njdx);
						nidx += di[dir];
						njdx += dj[dir];
					}
					if (field[nidx][njdx] == '*') {
						field[nidx - di[dir]][njdx - dj[dir]] = '.';
						continue;
					} else
						continue;
				}

				else if (act == 'U')
					dir = 0;
				else if (act == 'R')
					dir = 1;
				else if (act == 'D')
					dir = 2;
				else if (act == 'L')
					dir = 3;

				nidx += di[dir];
				njdx += dj[dir];
				if (nidx < 0 || nidx >= H || njdx < 0 || njdx >= W || cannotGo(field[nidx][njdx])) {
					continue;
				} else {
					field[idx][jdx] = '.';
					idx = nidx;
					jdx = njdx;
				}

			}
			switch (dir) {
			case 0:
				field[idx][jdx] = '^';
				break;
			case 1:
				field[idx][jdx] = '>';
				break;
			case 2:
				field[idx][jdx] = 'v';
				break;
			case 3:
				field[idx][jdx] = '<';
				break;
			}

			System.out.println(Arrays.deepToString(field));
		}
	}

	static boolean cannotGo(char point) {
		if (point == '*' || point == '#' || point == '-')
			return true;
		else
			return false;
	}
}
