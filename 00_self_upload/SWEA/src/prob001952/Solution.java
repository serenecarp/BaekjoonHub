package prob001952;

import java.util.Scanner;

public class Solution {
	static int feeD;
	static int feeM;
	static int feeQ;
	static int feeY;

	static int[] plan;
	static int[] feeMD;

	static int feeTot;
	static int feeMin;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			feeD = sc.nextInt();
			feeM = sc.nextInt();
			feeQ = sc.nextInt();
			feeY = sc.nextInt();

			// 연간 수영장 이용계획 입력

			plan = new int[12];
			feeMD = new int[12];

			// 1. 일일 이용권, 한 달 이용권만 있다고 가정했을 때
			feeTot = 0;
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
				if (plan[i] != 0) {
					// 해당 달의 더 저렴한 요금(일일 vs 한달)
					feeMD[i] = feeM < plan[i] * feeD ? feeM : plan[i] * feeD;
					// 일단 일일,한달로만 했을 때를 기본으로 요금계산
					feeTot += feeMD[i];
				}
			}
			// 2. 일일 이용권, 한 달 이용권에다가 일년 이용권까지 있다고 가정했을 때
			// 일일+한달 vs. 일년 중 더 저렴한 요금을 일단 최소요금에 입력
			feeMin = feeTot > feeY ? feeY : feeTot;

			// 3. 3달이용권까지 있을 때.
			// 3달이용권, 1달이용권으로만 사용한다고 가정했을 때
			// 3달이용권의 개수, 1달 이용권의 개수
			int feeQTot = feeTot;
			for (int qtr = 1; qtr <= 4; qtr++) {
				// 1 1 1 .. 1 1 사이에 3이 qtr개 껴서 12를 만들 수 있는 경우의 수 => 중복조합
				int mon = 12 - 3 * qtr + 1;
				selectQuarter(0, mon, qtr, feeQTot);
			}

			System.out.printf("#%d %d\n", testCase, feeMin);
		} // tc
	}

	// N: 1(한달이용권)
	// R: 3(세달이용권)
	static void selectQuarter(int idx, int N, int R, int feeQTot) {
		if (R == 0) {
			System.out.println(feeQTot);
			if (feeMin > feeQTot) {

				feeMin = feeQTot;
			}
			return;
		}

		for (int i = idx; i <= N - R + idx; i++) {
			// i번째에 3달이용권이 들어갔다면
			// i, i+1, i+2의 1달이용권 요금은 빼주고, 거기에 3달이용권을 더한다.

			// 단, 세 달 이용계획이 모두 0이면 이용요금 변동은 없으므로, 따져줄 필요가 없다
			if (plan[i] == 0 && plan[i + 1] == 0 && plan[i + 2] == 0) {
				continue;
			} else {

				// 위치 중복 가능하므로 인덱스는 idx를 그대로 넣되, 넣었으면 +3해줘야 함.
				selectQuarter(idx + 3, N, R - 1, feeQTot - feeMD[i] - feeMD[i + 1] - feeMD[i + 2] + feeQ);

			}
		}
	}
}
