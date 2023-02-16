
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

//System.setIn(new FileInputStream("C:\\Users\\SSAFY\\Desktop\\sample_input.txt"));

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
			boolean isFive = false;
//			System.out.println(Arrays.deepToString(omok));
			int d[] = { 1, 2, 3, 4 };

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					if (omok[r][c] == 'o') {
						int rCheck = 0;
						int cCheck = 0;
						int d1Check = 0;
						int d2Check = 0;
						for (int k = 0; k < 4; k++) {
							int nr = r + d[k];
							int nc = c + d[k];
							int rnc = c - d[k];

							if (nr < N)
								rCheck += omok[nr][c];

							if (nc < N)
								cCheck += omok[r][nc];

							if (nc < N && nr < N)
								d1Check += omok[nr][nc];

							if (rnc >= 0 && nr < N)
								d2Check += omok[nr][rnc];

						}
						if (rCheck == 444 || cCheck == 444 || d1Check == 444 || d2Check == 444) {
							isFive = true;
							break;
						}
					}

				}
				if (isFive)
					break;
			}
			if (isFive)
				System.out.printf("#%d YES\n", test_case);
			else
				System.out.printf("#%d NO\n", test_case);
		}
	}
}