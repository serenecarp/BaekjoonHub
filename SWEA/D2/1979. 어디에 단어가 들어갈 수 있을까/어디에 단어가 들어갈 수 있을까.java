
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 단어 퍼즐의 가로, 세로 길이 입력
			int N = sc.nextInt();
			// 단어의 길이 입력
			int K = sc.nextInt();
			// 2차원 단어퍼즐 배열 (margin(?) 1씩 부여)
			// 원본 퍼즐은 (1,1) ~ (N,N)
			// margin 포함하면 (0,0) ~ (N+1, N+1)
			int[][] puzzle = new int[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			// 정답 세어주기
			int answer = 0;
			// 가로 방향 검사
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j < N + 2 - K; j++) {
					// 처음과 끝이 1이면, 그 사이도 모두 1인지 체크해본다
//					System.out.printf("%d, %d\n", j, j + K - 1);
					if (puzzle[i][j] * puzzle[i][j + K - 1] == 1) {
//						System.out.printf("(%d, %d) 검사합니다\n", i, j);
//						if (xChecker(puzzle, i, j, K) ==1) System.out.println("좋아요");
						answer += xChecker(puzzle, i, j, K);
					}
				}
			}
			
			// 세로 방향 검사
			for (int i = 1; i < N + 2 - K; i++) {
				for (int j = 1; j <= N; j++) {
					// 처음과 끝이 1이면, 그 사이도 모두 1인지 체크해본다
//					System.out.printf("%d, %d\n", j, j + K - 1);
					if (puzzle[i][j] * puzzle[i + K - 1][j] == 1) {
//						System.out.printf("(%d, %d) 검사합니다\n", i, j);
//						if (xChecker(puzzle, i, j, K) ==1) System.out.println("좋아요");
						answer += yChecker(puzzle, i, j, K);
					}
				}
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	public static int xChecker(int[][] puzzle, int y, int x, int K) {

		// 가로 체크
		int isSerial = 1;
		// 1 사이의 원소들을 확인 (K=2글자여도, 그냥 교차돼서 1 나오니 괜찮다)
		for (int j = x + 1; j < x + K - 1; j++) {
			isSerial *= puzzle[y][j];
		}
		if (isSerial == 1 && puzzle[y][x - 1] == 0 && puzzle[y][x + K] == 0) {
			return 1;
		}
		return 0;
	}

	public static int yChecker(int[][] puzzle, int y, int x, int K) {

		// 가로 체크
		int isSerial = 1;
		// 1 사이의 원소들을 확인 (K=2글자여도, 그냥 교차돼서 1 나오니 괜찮다)
		for (int i = y + 1; i < y + K - 1; i++) {
			isSerial *= puzzle[i][x];
		}
		if (isSerial == 1 && puzzle[y - 1][x] == 0 && puzzle[y + K][x] == 0) {
			return 1;
		}
		return 0;
	}
}