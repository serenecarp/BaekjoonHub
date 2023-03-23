import java.util.Scanner;

public class Main {
	static int N;
	static int count;

	public static void main(String[] args) {
		int test = 2;
		test = test | (1 << (4));

		Scanner sc = new Scanner(System.in);
		
			N = sc.nextInt();
			count = 0;
			positionQueen(0, 0, 0, 0);
			System.out.printf("%d", count);


	}

	static void positionQueen(int boardRow, int row, int powL, int powR) {
		// BASE
		if (row == N) {
			// boardRow가 111..11 로만 돼있다면 ok! count++
			if (boardRow == (1 << N) - 1) {
				count++;
			}
			return;
		}

		// RECURSIVE
		for (int col = 0; col < N; col++) {
			int cannotPosition = boardRow | powL | powR;
			if (((1 << col) & cannotPosition) != 0) {
				continue;
			}
// (boardRow에 퀸을 놓고 / 다음 row로 / 놓으면 안되는 영역을 왼아래로 / 놓으면 안되는 영역을 오른아래로)
			positionQueen(boardRow | (1 << col), row + 1, (powL | (1 << col)) << 1, (powR | (1 << col)) >>> 1);
		}
	}
}