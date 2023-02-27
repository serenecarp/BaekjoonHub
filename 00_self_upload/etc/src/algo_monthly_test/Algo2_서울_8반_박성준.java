package algo_monthly_test;
import java.util.Scanner;

public class Algo2_서울_8반_박성준 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 전체 땅 크기와
			// 개발할 사각영역 좌표 입력
			int N = sc.nextInt();
			int locI1 = sc.nextInt();
			int locJ1 = sc.nextInt();
			int locI2 = sc.nextInt();
			int locJ2 = sc.nextInt();
			
			// 전체 땅 정보 입력,
			// 해당 땅이 개발 예정인 지역이면
			// 평탄화 높이를 계산하기 위해 landMean 변수에 더해준다.
			int[][] landMap = new int[N][N];

			int landMean = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					landMap[i][j] = sc.nextInt();
					if (i >= locI1 && i <= locI2 && j >= locJ1 && j <= locJ2) {
						landMean += landMap[i][j];
					}
				}
			}
			// 사각영역의 땅 높이 합을 영역 넓이로 나눠준다.
			// == 평탄화할 높이
			landMean /= (locJ2 - locJ1 + 1) * (locI2 - locI1 + 1);

			// 사각영역
			// row: 	locI1 ~ locI2
			// column: 	locJ1 ~ locJ2
			// 해당 영역만 순회하며 평탄화할 높이 landMean과의 차를 구해준다.(음수면 양수로 바꿈)
			// 그 차이를 모두 더해 출력한다.
			int costSum = 0;
			for (int i = locI1; i <= locI2; i++) {
				for (int j = locJ1; j <= locJ2; j++) {
					int temp = landMap[i][j] - landMean;
					if (temp < 0) {
						temp *= -1;
					}
					costSum += temp;
				}
			}
			System.out.printf("#%d %d %d\n", test_case, landMean,costSum);

		}
	}
}
