package prob001216;

import java.util.Scanner;

class Solution1216 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;
		// 테스트케이스 10개
		for (int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt();
			
			// 보드 입력 (100*100)
			char[][] board = new char[100][100];
			for (int i = 0; i < 100; i++) {
				board[i] = sc.next().toCharArray();
			}

			// 회문의 최대 길이는?
			int maxLength = 1;

			// 100*100을 순회하며 더 긴 길이가 나오면
			// 최대 길이 갱신
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (maxLength < superPalindrome(board, i, j, maxLength)) {
						maxLength = superPalindrome(board, i, j, maxLength);
					}
				}
				// 혹시 100이면 더 늘어날 것도 없으니 100 출력해요
				if (maxLength == 100)
					break;
			}
			// 정답 출력
			System.out.printf("#%d %d\n", test_case, maxLength);
		}
	}

	// 해당 인덱스에서 최대한 긴 회문의 길이를 return한다.
	// 회문이 없다면 0을 리턴한다.
	public static int superPalindrome(char[][] board, int i, int j, int maxLength) {

		// 해당 인덱스에서 제일 긴 회문의 길이
		int longerLen = 0;

		// 길면 길수록 좋기 때문에, 길이 100에서부터 세어주기로 했다.
		// j를 빼주는 건, 회문검사 할 때 배열 밖으로 나가지 않기 위해서.
		// - 해당 조건문(rnj >= 100)을 빼고 이렇게 설정해보았다.
		for (int len = 100 - j; len > maxLength; len--) {
			// 회문이 있는가?
			boolean flagJ = true;

			// 정방향 읽기 vs. 역방향 읽기 비교
			for (int k = 0; k < len; k++) {
				int nj = j + k;
				int rnj = j + (len - 1) - k;

				// 읽다가 정/역이 다른 글자가 나오면 탈락, 바로 탈출 후 다음 길이로
				if (board[i][nj] != board[i][rnj]) {
					flagJ = false;
					break;
				}
			}

			// 회문이 있는 경우
			// 그 회문이 지금까지 측정한 최대회문길이보다 짧으면 의미 없으므로 넘어간다.
			// 더 길면 그녀석을 채택
			if (flagJ) {
				if (len > maxLength) {

					longerLen = len;
					break;
				}
			}

		}

		// 이하동문
		for (int len = 100-i; len > maxLength; len--) {
			boolean flagI = true;

			for (int k = 0; k < len; k++) {
				int ni = i + k;
				int rni = i + (len - 1) - k;
				if (board[ni][j] != board[rni][j]) {
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
		// 해당 좌표에서의 최대 회문 길이 or 0 반환
		return longerLen;
	}
}