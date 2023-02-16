
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		// System.setIn(new FileInputStream("res/input.txt"));

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
			int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

			// 번호 찍을 좌표 [i][j], 델타 제어용 k
			int i = 0;
			int j = 0;
			int k = 0;

			// 달팽이배열에 값 넣기
			for (int num = 1; num <= N * N; num++) {
				snail[i][j] = num;
				// 현재 방향대로 전진
				i += direction[k][0];
				j += direction[k][1];
				// 전진했는데 배열 범위를 넘었다면
				// 후진했다가 방향전환
				if (i >= N || i < 0 || j >= N || j < 0) {
					i -= direction[k][0];
					j -= direction[k][1];
					k = ++k % 4;
					i += direction[k][0];
					j += direction[k][1];
				}
				// 전진했는데 이미 갔던 곳이라면
				// 후진했다가 방향젼환
				else if (snail[i][j] != 0) {
					i -= direction[k][0];
					j -= direction[k][1];
					k = ++k % 4;
					i += direction[k][0];
					j += direction[k][1];
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