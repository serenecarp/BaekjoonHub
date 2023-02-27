package algo_monthly_test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo1_서울_8반_박성준 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 쿵쿵따 큐
		Queue<Integer> KKD = new LinkedList<>();
		int T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 쿵쿵따 참여 인원수 입력 및 큐에 삽입
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				KKD.add(i + 1);
			}

			int count = 0;
			int temp = 0;
			// 쿵쿵따의 큐가 빌 때까지,
			// 쿵쿵따 큐 맨 앞의 사람을 poll하고, 그 사람을 다시 add한다.
			// (가장 최근에 poll된 사람을 temp변수가 기억한다.)
			// 이 시행마다 count가 상승하며,
			// count가 3의 배수가 되면 poll한 사람은 다시 add되지 않는다.
			// 쿵쿵따가 끝나 큐가 비면 가장 최근에 poll된 사람을 출력한다.
			while (!KKD.isEmpty()) {
				count++;
				if (count % 3 == 0) {
					temp = KKD.poll();

				} else {
					KKD.add(KKD.poll());
				}
			}
			System.out.printf("#%d %d\n", test_case, temp);
		}
	}
}
