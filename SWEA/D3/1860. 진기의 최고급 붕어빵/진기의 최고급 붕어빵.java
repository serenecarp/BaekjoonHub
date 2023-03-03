
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 손님 수, 몇 초마다, 붕어빵 몇 개 만드는지 입력
			int customers = sc.nextInt();
			int seconds = sc.nextInt();
			int fishBuns = sc.nextInt();
			// 0~11111초까지 붕어빵 개수를 나타낸 타임라인
			int[] timeline = new int[11112];
			// 가능/불가능
			boolean possible = true;

			// 손님을 먼저 받고
			for (int j = 0; j < customers; j++) {
				int getBunTime = sc.nextInt();
				timeline[getBunTime]--;
			}

			// 붕어빵을 만드는데 붕어빵 개수가 음수면 실패
			for (int i = 0; i < timeline.length - 1; i++) {

				// seconds의 배수에만 붕어빵 추가, 0일때는 제외
				if (i >= seconds && i % seconds == 0) {
					timeline[i] += fishBuns;
				}

				timeline[i + 1] += timeline[i];

				if (timeline[i] < 0) {
					possible = false;
					break;
				}

			}

			// 출력
			System.out.printf("#%d ", testCase);
			if (possible) {
				System.out.print("Possible\n");
			} else {
				System.out.print("Impossible\n");
			}
		}
	}
}
