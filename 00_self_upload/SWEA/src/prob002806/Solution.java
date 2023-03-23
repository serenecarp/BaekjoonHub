package prob002806;

import java.util.Scanner;

public class Solution {
	// boardRow : 체스판 한 줄 (N칸짜리 한줄)
	static int N;
	// N-Queen이 가능한 개수 count
	static int count;
	// cannotPosition을 int로 하고 bit로 처리하려고 했는데,
	// row가 증가하면서 두지 못하는 칸을 정할 때
	// 우측 하단으로 가던 녀석인지 좌측 하단으로 가던 녀석인지 분간할 수 없게 되었다.
	// (RESET)
	// 따라서 visited배열처럼 배열로 만들되,
	// 우측하단으로 가는 녀석인지 좌측 하단으로 가던 녀석인지 판단하기 위해
	// 배열을 2개 만들기로 했다.
//	static boolean[] powerRight;
//	static boolean[] powerLeft;

	// 다 만들고 보니 글러먹은 것 같아서
	// 처음부터 또 다시 만들기로 했다.
	// (RESET)
	// 우하단으로 가는 비트, 좌하단으로 가는 비트 두 개를 생각하기로 했다.

	public static void main(String[] args) {
		int test = 2;
		test = test | (1 << (4));
//		System.out.println(toBinary(test));
//		System.out.println(toBinary(test | 1 << 2));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();

			count = 0;

			positionQueen(0, 0, 0, 0);
			System.out.println(count);

		} // tc
	}

	static void positionQueen(int boardRow, int row, int powL, int powR) {
		// BASE
		// 모든 열을 다 따졌으며,
		if (row == N) {
			// boardRow가 111..11 로만 돼있다면 ok! count++
			if (boardRow == (1 << N) - 1) {
				System.out.println("***");
				System.out.println(toBinary(boardRow) + "당첨");
				System.out.println("***");
				count++;
			}
			// 다른 경우를 생각하러 돌아가기
			return;
		}

		// RECURSIVE
		// 모든 case를 돌아본다.
		// col = 현재 몇 번째 칸(column)
		// 재귀의 depth = 현재 몇 번째 행인지 (row)
		for (int col = 0; col < N; col++) {
			// row가 한 칸 밑으로 가면 대각선으로 가던 영향력은
			// 방향에 맞게 한 칸씩 더 간다.
			powL = powL << 1;
			powR = powR >>> 1;
			// 이미 퀸을 둔 열(column)이거나 (=> 세로줄 고려)
			// 퀸을 두면 안되는 위치라면 다음 위치를 고려하자. (=> 대각선 고려)
			int cannotPosition = boardRow | powL | powR;

			if (((1 << col) & cannotPosition) != 0) {
				continue;
			}

//			// 퀸을 두어도 괜찮은 위치라면 둬보자.
//			boardRow = boardRow | (1 << col);
//
//			// 두면 안되는 대각선 영향력을 대각선 위치에 추가
//			powL = powL | (1 << (col + 1));
//			powR = powR | (1 << (col - 1));
//
//			positionQueen(boardRow, row + 1, powL, powR);
//			-> 이렇게 해버리면 재귀에서 돌아올 때 후처리가 되지 않으므로,
//			아예 재귀 안에 해당하는 식을 넣어 주어야 돌아올 때 이전 상태로 되돌릴 수 있다.
			System.out.println("현재 row: "+row);
			System.out.println(toBinary(boardRow));
			positionQueen(boardRow | (1 << col), row+1, powL | (1 << (col + 1)), powR | (1 << (col - 1)));

		}
	}

	public static String toBinary(int x) {
		return String.format("%10s", Integer.toBinaryString(x)).replaceAll(" ", "0");
	}
}
