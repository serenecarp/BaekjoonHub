package prob001979;

import java.util.Scanner;

class Solution1979 {
	public static void main(String args[]) throws Exception {

		// 1. 2차원 배열에 입력 받는다.
		// 2. 지정 개수 K개의 연속된 원소의 곱이 1이면서, 그 앞뒤가 0이면 통과!
		// -> 가로 세로 각각 따로 검사해준다.
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 단어 퍼즐의 가로, 세로 길이 입력
			int N = sc.nextInt();
			// 단어의 길이 입력
			int K = sc.nextInt();
			// 2차원 단어퍼즐 배열 (padding(?) 1씩 부여)
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
					if (puzzle[i][j] * puzzle[i][j + K - 1] == 1) {
						answer += xChecker(puzzle, i, j, K);
					}
				}
			}
			
			// 세로 방향 검사
			for (int i = 1; i < N + 2 - K; i++) {
				for (int j = 1; j <= N; j++) {
					// 처음과 끝이 1이면, 그 사이도 모두 1인지 체크해본다
					if (puzzle[i][j] * puzzle[i + K - 1][j] == 1) {
						answer += yChecker(puzzle, i, j, K);
					}
				}
			}
			
			// 정답 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	// x방향 검사해주는 메소드
	public static int xChecker(int[][] puzzle, int y, int x, int K) {

		int isSerial = 1;
		// 1 사이의 원소들을 확인 (K=2글자여도, 그냥 교차돼서 1 나오니 괜찮다)
		// 모두 곱했을 때 1이면 전부 1이라는 뜻
		for (int j = x + 1; j < x + K - 1; j++) {
			isSerial *= puzzle[y][j];
		}
		// 지정 칸 사이가 모두 1이면서 앞뒤는 0이면 ok, answer에 1을 더한다
		if (isSerial == 1 && puzzle[y][x - 1] == 0 && puzzle[y][x + K] == 0) {
			return 1;
		}
		return 0;
	}

	// y방향 검사해주는 메소드
	public static int yChecker(int[][] puzzle, int y, int x, int K) {

		int isSerial = 1;
		// 1 사이의 원소들을 확인 (K=2글자여도, 그냥 교차돼서 1 나오니 괜찮다)
		// 모두 곱했을 때 1이면 전부 1이라는 뜻
		for (int i = y + 1; i < y + K - 1; i++) {
			isSerial *= puzzle[i][x];
		}
		// 지정 칸 사이가 모두 1이면서 앞뒤는 0이면 ok, answer에 1을 더한다
		if (isSerial == 1 && puzzle[y - 1][x] == 0 && puzzle[y + K][x] == 0) {
			return 1;
		}
		return 0;
	}
}