
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		// 1. 입력할 숫자는 계속 하나씩 늘려준다
		// 2. 아직 입력하지 않아서 0인 곳에 숫자를 남겨놓고 다음 장소로 이동한다
		// 3. 가서는 안 될 곳에 들어가면
		//   - 사과하고 다시 나온다.
		//   - 델타를 이용해 방향을 바꾼다.
		// 4. 완성되면 그대로 출력한다.
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 달팽이 크기
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			// 방향전환용 델타
			// 오른쪽 / 아래 / 왼쪽 / 위 반복 예정
			int[][] basis = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

			// 번호 찍을 좌표 [i][j], 델타 제어용 k
			int i = 0;
			int j = 0;
			int k = 0;

			// 달팽이배열에 값 넣기
			for (int num = 1; num <= N * N; num++) {
				snail[i][j] = num;
				// 현재 방향대로 전진
				i += basis[k][0];
				j += basis[k][1];
				// 전진했는데 배열 범위를 넘었다면
				// 후진했다가 방향전환
				if (i >= N || i < 0 || j >= N || j < 0) {
					i -= basis[k][0];
					j -= basis[k][1];
					k = ++k % 4;
					i += basis[k][0];
					j += basis[k][1];
				}
				// 전진했는데 이미 갔던 곳이라면
				// 후진했다가 방향젼환
				else if (snail[i][j] != 0) {
					i -= basis[k][0];
					j -= basis[k][1];
					k = ++k % 4;
					i += basis[k][0];
					j += basis[k][1];
				}
			}
			// 배열 그대로 출력
			System.out.printf("#%d\n", test_case);
			for (int y=0; y<N; y++) {
				for	(int x=0; x<N; x++) {
					System.out.print(snail[y][x] + " ");
				}
				System.out.println();
			}
			
		}
	}
}