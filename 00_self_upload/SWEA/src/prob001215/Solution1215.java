package prob001215;

import java.util.Scanner;

class Solution1215 {
	public static void main(String args[]) throws Exception {

		// 1. 글자판을 입력받는다.
		// 2. 글자판 한 칸씩 검사한다.
		// -> 해당 칸 기준으로 오른쪽, 아래쪽으로 회문길이만큼 검사
		// 3. 검사해서 회문이 나오면 count한다.
		Scanner sc = new Scanner(System.in);
		int T = 10;
		// 테스트케이스 10개
		for (int test_case = 1; test_case <= T; test_case++) {
			// 회문길이 지정, 글자판 입력
			int n = sc.nextInt();
			char[][] wordBoard = new char[8][8];
			for (int i = 0; i < 8; i++) {
				wordBoard[i] = sc.next().toCharArray();
			}
			// [i][j]를 기준으로 (오른쪽, 아래)를 검색했을 때 회문이 몇 개인지 count
			int count = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					count += isPalindrome(wordBoard, i, j, n);
				}
			}
			// 출력
			System.out.printf("#%d %d\n", test_case, count);
		}
	}

	// [i][j]에서 가로회문 또는 세로회문이 만들어지는지 검사해주는 메소드
	public static int isPalindrome(char[][] wordBoard, int i, int j, int n) {
		// 가로회문이 존재하면 flagJ == 1 아니면 0
		// 세로회문이 존재하면 flagI == 1 아니면 0
		int flagJ = 1;
		int flagI = 1;
		
		// 가로회문 검사
		for (int k = 0; k < n; k++) {
			// 정방향 읽기 vs. 역방향 읽기 비교
			int nj = j + k;
			int rnj = j + n - 1 - k;
			// 글자판 밖으로 나가면 탈락 (flagJ=0)
			if (rnj >= 8) {
				flagJ = 0;
				break;
			}
			// 정/역방향으로 읽을 때 일치하지 않는 글자가 나오면 탈락 (flagJ=0)
			if (wordBoard[i][nj] != wordBoard[i][rnj]) {
				flagJ = 0;
				break;
			}
		}
		
		// 세로회문 검사
		for (int k = 0; k < n; k++) {
			// 정방향 읽기 vs. 역방향 읽기 비교
			int ni = i + k;
			int rni = i + n - 1 - k;
			// 글자판 밖으로 나가면 탈락 (flagI=0)
			if (rni >= 8) {
				flagI = 0;
				break;
			}
			// 정/역방향으로 읽을 때 일치하지 않는 글자가 나오면 탈락 (flagI=0)
			if (wordBoard[ni][j] != wordBoard[rni][j]) {
				flagI = 0;
				break;
			}
		}
		// 해당 지점에서의 회문 개수(가로or세로) 반환
		return flagJ + flagI;
	}
}