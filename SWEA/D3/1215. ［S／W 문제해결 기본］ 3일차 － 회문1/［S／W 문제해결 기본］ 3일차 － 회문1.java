
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {


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
			// 회문이 몇 개인지 count
			int count = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					count += isPalindrome(wordBoard, i, j, n);
				}
			}

			System.out.printf("#%d %d\n", test_case, count);
		}
	}

	public static int isPalindrome(char[][] wordBoard, int i, int j, int n) {
		int flagJ = 1;
		int flagI = 1;
		for (int k = 0; k < n; k++) {

			int nj = j + k;
			int rnj = j + n - 1 - k;
			if (rnj >= 8) {
				flagJ = 0;
				break;
			}
			if (wordBoard[i][nj] != wordBoard[i][rnj]) {
				flagJ = 0;
				break;
			}

		}

		for (int k = 0; k < n; k++) {
			int ni = i + k;
			int rni = i + n - 1 - k;
			if (rni >= 8) {
				flagI = 0;
				break;
			}
			if (wordBoard[ni][j] != wordBoard[rni][j]) {
				flagI = 0;
				break;
			}
		}
//		if (flagJ == 1)
//			System.out.printf("[%d][%d] 가로회문\n", i, j);
//		if (flagI == 1)
//			System.out.printf("[%d][%d] 세로회문\n", i, j);

		return flagJ + flagI;
	}
}