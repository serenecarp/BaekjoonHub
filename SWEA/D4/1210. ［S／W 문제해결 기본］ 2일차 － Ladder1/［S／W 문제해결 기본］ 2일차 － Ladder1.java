
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 케이스번호 대충 입력받기
			sc.nextInt();

			// 사다리 입력
			int size = 100;
			int[][] ladder = new int[size+1][size];
			int pointer = 0;
			// 사다리의 세로막대(column)들의 index값을 저장하는 리스트
			List<Integer> column = new ArrayList<>();

			// 사다리를 거꾸로 입력받는다 (==사다리가 뒤집어짐)
			// 그냥 끝에서 출발해도 되지만..
			// 나는 이게 생각하기 편하다!
			for (int i = size - 1; i >= 0; i--) {
				for (int j = 0; j < size; j++) {
					ladder[i][j] = sc.nextInt();
					// 사다리 세로막대(?)의 index만 따로 리스트에 저장
					if (ladder[0][j] == 1) {
						column.add(j);
					}
					// 출발지점(==뒤집기 전엔 도착했어야할 지점)지정 (얘도 물론 column에)
					if (ladder[0][j] == 2) {
						column.add(j);
						pointer = column.size() - 1;
					}

				}
			}
//			System.out.println(column.toString());

			for (int i = 0; i < size; i++) {
//				System.out.println(pointer);
				if (column.get(pointer) < size - 1) {
					// 오른쪽에 1이 있으면 pointer++ (== 한칸 오른쪽 막대기로)
					if (ladder[i][column.get(pointer) + 1] == 1) {
						pointer++;
						continue;
					}
				}

				if (column.get(pointer) > 0) {
					// 왼쪽에 1이 있으면 pointer-- (== 한칸 왼쪽 막대기로)
					if (ladder[i][column.get(pointer) - 1] == 1) {
						pointer--;
						continue;
					}
				}
				
			}

			System.out.printf("#%d %d\n", test_case, column.get(pointer));

		}
	}
}