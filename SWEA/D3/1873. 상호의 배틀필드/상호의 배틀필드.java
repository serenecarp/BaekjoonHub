
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 배틀필드 지도의 크기
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] field = new char[H][W];
			// 현재 전차의 위치를 나타내는 좌표
			int idx = 0;
			int jdx = 0;
			// 상 우 하 좌 == 0 1 2 3
			int[] di = { -1, 0, 1, 0 };
			int[] dj = { 0, 1, 0, -1 };
			// 전차의 방향 (di, dj의 index)
			int dir = 0;
			
			// 배틀필드 지도의 정보 입력 받기
			// 동시에 현재 전차의 위치와 방향 파악하기
			for (int i = 0; i < H; i++) {
				field[i] = sc.next().toCharArray();
				for (int j = 0; j < W; j++) {
					
					// 화살표 모양이 보이면, 그 곳이 전차의 위치
					// 화살표의 방향에 따라 전차의 현재 방향 설정
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

			// 전차의 동작 개수 및 동작들 입력
			int acts = sc.nextInt();
			String commands = sc.next();
			// 전차 동작 실행
			outLoop: for (int actNo = 0; actNo < acts; actNo++) {
				char act = commands.charAt(actNo);
				// nidx, njdx == 전차의 움직일 새로운 좌표 or 전차가 쏜 포탄의 좌표
				int nidx = idx;
				int njdx = jdx;
				// ********** S. 전차가 포탄을 쏜 경우 **********
				if (act == 'S') {
					// '*'이나 '#'을 만날 때까지 포탄을 전차의 현재 방향으로 전진시킨다
					while (field[nidx][njdx] != '*' && field[nidx][njdx] != '#') {
						nidx += di[dir];
						njdx += dj[dir];
						// 지도 밖으로 나갔다면 아무것도 하지 않고 다음 동작을 수행한다
						if (nidx < 0 || nidx >= H || njdx < 0 || njdx >= W) {
							continue outLoop;
						}
					}

					// 벽돌 벽을 만나면 그 벽을 평지('.')로 만든다.
					if (field[nidx][njdx] == '*') {
						field[nidx][njdx] = '.';
						continue;
					}
					// 강철 벽을 만나면 아무것도 하지 않는다.
					else
						continue;
				}

				// ********** U, R, D, L. 전차가 움직인 경우 **********
				// 방향 설정
				else if (act == 'U')
					dir = 0;
				else if (act == 'R')
					dir = 1;
				else if (act == 'D')
					dir = 2;
				else if (act == 'L')
					dir = 3;

				// 해당 방향으로 한 칸 전진
				nidx += di[dir];
				njdx += dj[dir];
				// 만약 전진한 곳이 맵 밖이거나, 갈 수 없는 곳(벽돌 벽, 강철 벽, 물)이면
				// 아무것도 하지 않는다.
				if (nidx < 0 || nidx >= H || njdx < 0 || njdx >= W || cannotGo(field[nidx][njdx])) {
					continue;
				}
				// 전진한 곳이 평지라면 그 좌표로 이동한다.
				// => 현 위치를 새 위치로 갱신한다.
				else {
					field[idx][jdx] = '.';
					idx = nidx;
					jdx = njdx;
				}

			}
			
			// 모든 행동을 마친 후,
			// 전차가 있는 현위치에 현 방향에 맞는 화살표만 추가로 넣어준다.
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

			// 출력
			System.out.printf("#%d ", testCase);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}
	}

	// 전차가 갈 수 없는 곳인지 판별하는 메소드
	static boolean cannotGo(char point) {
		if (point == '*' || point == '#' || point == '-')
			return true;
		else
			return false;
	}
}
