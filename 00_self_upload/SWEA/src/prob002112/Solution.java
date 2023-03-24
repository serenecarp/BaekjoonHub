package prob002112;

import java.util.Scanner;

public class Solution {
	static int D; // 필름두께
	static int W; // 가로너비
	static int K; // 합격기준
	static int[][] film; // 필름정보
	static int[][] filmCopy; // 복사필름 (재귀 후 원상복구용)

	static int[] layerA;
	static int[] layerB;

	static int minInjection;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 필름두께, 가로너비, 합격기준 입력
			D = sc.nextInt();
			W = sc.nextInt();
			// K는 합격 기준이자 약품 투여 최댓값이며..
			// minInjection은 순열 생성시 생각해줄 약품 투여 최댓값
			// 해당 값을 지나면 더이상 고려하지 않음 (pruning)
			K = sc.nextInt();
			minInjection = K;

			// 해당 약품 투여시 갈아끼워줄 레이어 설정
			layerA = new int[W];
			layerB = new int[W];
			for (int i = 0; i < W; i++) {
				layerB[i] = 1;
			}

			// 초기 필름 상태 입력
			film = new int[D][W];
			filmCopy = new int[D][W];
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					int tmp = sc.nextInt();
					film[i][j] = tmp;
					filmCopy[i][j] = tmp;
				}
			}

			injectPermutation(0, 0);

			// 합격기준이 1밖에 안되면 그냥 약 안쳐도 된다.
			// *** 근데 이 코드를 K를 입력한 직후로 옮기면 틀리다고 나온다. 왜??
			if (K == 1)
				minInjection = 0;
			System.out.printf("#%d %d\n", testCase, minInjection);

		} // tc
	}

	// 약품 투여 재귀함수

	static void injectPermutation(int layer, int injection) {
//		System.out.printf("현재 층: " + layer + " / 현재 투여수: " + injection + " / 최소투여수: " + minInjection + "\n");
		// BASE
		// 현재 구한 최소 약품투여보다 더 많이 투여하게 됐거나 (0나오면 바로 종료)
		// 필름 두께를 모두 조사했으면 종료 (다 조사했는데 뭐 없으면 최댓값인 K번 약물 투입)
		if (injection >= minInjection) {
			return;
		}
		if (layer == D) {
			return;
		}

		// RECURSIVE
		// 이번 레이어에 약품 투여 안함
		if (isPass()) {
			minInjection = injection;
		}
		injectPermutation(layer + 1, injection);

		// 이번 레이어에 A 투여
		film[layer] = layerA;
		if (isPass() && minInjection > injection + 1) {
			minInjection = injection + 1;
		}
		injectPermutation(layer + 1, injection + 1);
		film[layer] = filmCopy[layer]; // 복구

		// 이번 레이어에 B 투여
		film[layer] = layerB;
		if (isPass() && minInjection > injection + 1) {
			minInjection = injection + 1;
		}
		injectPermutation(layer + 1, injection + 1);
		film[layer] = filmCopy[layer]; // 복구
	}

	static boolean isPass() {
		// 해당 칸이 합격이면 true
		boolean pass = true;
		// 가로로 탐색
		filmCol: for (int j = 0; j < W; j++) {
			int count = 1;
			// 세로 두께 탐색
			for (int i = 1; i < D; i++) {
				// 동일하면 count++ -> K되면 OK
				if (film[i][j] == film[i - 1][j]) {
					count++;
					// 해당 가로칸이 합격이면 다음 가로칸으로
					if (count == K) {
						continue filmCol;
					}

				}
				// 동일하지 않으면 count 1로 초기화
				else {
					count = 1;
				}
			}

			// 두께 다 따져봤는데도 여기까지 도달했다면 불합격
			pass = false;
			break;
		}
//		if (pass) {
//			for (int i = 0; i < D; i++) {
//				for (int j = 0; j < W; j++) {
//					System.out.print(film[i][j]);
//				}
//				System.out.println();
//			}
//		}
		return pass;
	}
}
