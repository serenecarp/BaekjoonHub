
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {


		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt();

			char[][] board = new char[100][100];
			for (int i = 0; i < 100; i++) {
				board[i] = sc.next().toCharArray();
			}

			int maxLength = 1;

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (maxLength < isPalindrome(board, i, j, maxLength)) {
						maxLength = isPalindrome(board, i, j, maxLength);
					}
				}
				if (maxLength == 100)
					break;
			}

			System.out.printf("#%d %d\n", test_case, maxLength);
		}
	}

	public static int isPalindrome(char[][] board, int i, int j, int maxLength) {

		int longerLen = 0;

		for (int len = 100-j; len > maxLength; len--) {
			boolean flagJ = true;

			for (int k = 0; k < len; k++) {
				int nj = j + k;
				int rnj = j + (len - 1) - k;

				if (rnj >= 100) {
					flagJ = false;
					break;
				}else if (board[i][nj] != board[i][rnj]) {
					flagJ = false;
					break;
				}
				
			}

			if (flagJ) {
				if (len > maxLength) {

					longerLen = len;
					break;
				}
			}

		}
		
		for (int len = 100; len > maxLength; len--) {
			boolean flagI = true;

			for (int k = 0; k < len; k++) {
				int ni = i + k;
				int rni = i + (len - 1) - k;
				if (rni >= 100) {
					flagI = false;
					break;
				} else if (board[ni][j] != board[rni][j]) {
					flagI = false;
					break;
				}
			}
			if (flagI) {
				if (longerLen < len) {
					longerLen = len;
				}
				break;
			}
		}
		return longerLen;
	}
}