package prob002564;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		int stores = sc.nextInt();

		int[][] store = new int[stores][2];
		for (int i = 0; i < stores; i++) {
			store[i][0] = sc.nextInt();
			store[i][1] = sc.nextInt();
		}
		int[] dong = new int[2];
		dong[0] = sc.nextInt();
		dong[1] = sc.nextInt();

		int answer = 0;

		for (int i = 0; i < stores; i++) {
			int dist = 0;
			int indicator = dong[0] + store[i][0];
			// 동근이와 상점이 같은 라인
			if (dong[0] == store[i][0]) {
				dist = store[i][1] - dong[1];
				if (dist < 0)
					dist *= -1;
			}
			// 동근이와 상점이 남북
			else if (indicator == 3)
				dist = store[i][1] + dong[1] + H;
			// 동근이와 상점이 동서
			else if (indicator == 7)
				dist = store[i][1] + dong[1] + W;
			// 동근이와 상점이 북서
			else if (indicator == 4)
				dist = store[i][1] + dong[1];
			// 동근이와 상점이 남동
			else if (indicator == 6)
				dist = W + H - store[i][1] - dong[1];
			// 그 외 case
			else {
				// 동근 북 상점 동
				if (dong[0] == 1 && store[i][0] == 4)
					dist = W - dong[1] + store[i][1];
				// 동근 동 상점 북
				else if (dong[0] == 4 && store[i][0] == 1)
					dist = dong[1] + W - store[i][1];
				// 동근 서 상점 남
				else if (dong[0] == 3 && store[i][0] == 2)
					dist = H - dong[1] + store[i][1];
				// 동근 남 상점 서
				else
					dist = dong[1] + H - store[i][1];
			}
			// 마주본 case에 대해 더 짧은 쪽의 길이를 반환
			dist = (dist < 2 * W + 2 * H - dist) ? dist : 2 * W + 2 * H - dist;
			// 정답에 합하기
			answer += dist;

		}
		// 출력
		System.out.println(answer);

	}
}
