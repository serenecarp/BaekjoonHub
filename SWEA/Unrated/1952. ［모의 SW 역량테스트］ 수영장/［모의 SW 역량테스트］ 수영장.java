
import java.util.Scanner;

public class Solution {
	// day, month, quarter, year
	static final int d = 0, m = 1, q = 2, y = 3;
	static int[] ticket, plan;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			ticket = new int[4];
			ticket[d] = sc.nextInt();
			ticket[m] = sc.nextInt();
			ticket[q] = sc.nextInt();
			ticket[y] = sc.nextInt();

			plan = new int[13];
			for (int i = 1; i <= 12; i++) {
				// 월간 사용 횟수
				int usage = sc.nextInt();
				// i월의 최적해는 i-1의 최적해 + (usage*일 or 월 사용로)
				plan[i] = Math.min(plan[i - 1] + ticket[m], plan[i - 1] + usage * ticket[d]);
				
				// 3달권, 1년권을 사용 가능한 경우
				// 현재 최적해와 (n달전 최적해 + n달권이용료) 비교
				if (i >= 3)
					plan[i] = Math.min(plan[i], plan[i - 3] + ticket[q]);
				if (i >= 12)
					plan[i] = Math.min(plan[i], plan[i - 12] + ticket[y]);
			}
			
			System.out.printf("#%d %d\n", testCase, plan[12]);

		} // tc
	}
}
