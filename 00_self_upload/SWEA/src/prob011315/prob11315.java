package prob011315;

import java.util.Scanner;

class Solution11315 {
	public static void main(String args[]) throws Exception {

//System.setIn(new FileInputStream("C:\\Users\\SSAFY\\Desktop\\sample_input.txt"));

		// 1. char 형식의 이중배열을 입력 받는다.
		// 2. 오목판 모든 칸을 순회하며 o를 찾는다.
		// 3. o를 발견하면 그 칸으로부터 델타 탐색을 시행한다. (가로(→) 세로(↓) 대각선(↘, ↗))
		// 4. 델타탐색한 해당 줄의 합이 444이면 오목이다. ('o' == 111)
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			// 오목판에 배열 입력 (char)
			char[][] omok = new char[N][N];
			for (int i = 0; i < N; i++) {
				omok[i] = sc.next().toCharArray();
			}
			// 오목 발견시 true가 되는 변수
			boolean isFive = false;
//			System.out.println(Arrays.deepToString(omok));
			
			
			// 오목 판정용 델타
			int d[] = { 1, 2, 3, 4 };

			// 오목판 순회 (정방향)
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					// o를 발견했을 때만 검사
					if (omok[r][c] == 'o') {
						// 가로, 세로, 대각선1, 대각선2
						int rCheck = 0;
						int cCheck = 0;
						int d1Check = 0;
						int d2Check = 0;
						// 델타로 한 칸씩 전진
						for (int k = 0; k < 4; k++) {
							int nr = r + d[k];
							int nc = c + d[k];
							int rnc = c - d[k];

							// 가로
							if (nr < N)
								rCheck += omok[nr][c];
							// 세로
							if (nc < N)
								cCheck += omok[r][nc];
							// 대각선1 (\)
							if (nc < N && nr < N)
								d1Check += omok[nr][nc];
							// 대각선2 (/)
							if (rnc >= 0 && nr < N)
								d2Check += omok[nr][rnc];

						}
						// 'o' == 111, 하나라도 오목이 보이면 탈출
						if (rCheck == 444 || cCheck == 444 || d1Check == 444 || d2Check == 444) {
							isFive = true;
							break;
						}
					}

				}
				if (isFive)
					break;
			}
			
			// 오목 발견했다면 예스, 아니면 노
			if (isFive)
				System.out.printf("#%d YES\n", test_case);
			else
				System.out.printf("#%d NO\n", test_case);
		}
	}
}