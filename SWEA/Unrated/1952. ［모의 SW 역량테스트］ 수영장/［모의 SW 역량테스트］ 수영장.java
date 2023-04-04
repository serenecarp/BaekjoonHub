
import java.util.Scanner;

public class Solution {
	static int d;
	static int m;
	static int q;
	static int y;
	static int[] feeBase;

	static int feeMin;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 일일, 1달, 3달, 1년 이용권 가격 입력
			d = sc.nextInt();
			m = sc.nextInt();
			q = sc.nextInt();
			y = sc.nextInt();
			// 연간 이용계획 입력
			// 베이스: 일일, 1달 두개만 사용한다고 가정했을 때 어느 쪽이 효율적인지 계산 후 입력
			feeBase = new int[12];
			int totBase = 0;
			for (int i = 0; i < 12; i++) {
				int frq = sc.nextInt();
				int feeMon = d * frq < m ? d * frq : m;
				feeBase[i] = feeMon;
				totBase += feeMon;
			}
			// 연간이용권 vs 일일+1달 이용권만 사용한 경우 중 더 싼 경우를 최솟값으로 가정
			feeMin = y < totBase ? y : totBase;

			selectQs(0, totBase);

			System.out.printf("#%d %d\n", testCase, feeMin);

		} // tc
	}

	private static void selectQs(int idx, int feeCurr) {
		// base
		// 3달권은 idx 10이상에선 어차피 넣지 못하므로
		// 10 이상일 때 재귀 종료 및 최솟값 갱신
		if (idx >= 10) {
			if (feeMin > feeCurr) {
				feeMin = feeCurr;
			}
			return;
		}

		// recursive
		// 해당 월에 3달권을 사용한 경우(1달권 3개를 취소하고, 그 자리에 3달권을 사용)
		selectQs(idx + 3, feeCurr - feeBase[idx] - feeBase[idx + 1] - feeBase[idx + 2] + q);
		// 해당 월에 3달권을 사용하지 않은 경우
		selectQs(idx + 1, feeCurr);
	}
}
