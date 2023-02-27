package algo_test_3;

import java.util.Scanner;

public class Algo2_서울_8반_박성준 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 땅의 크기, 땅 상태 입력
			int landSize = sc.nextInt();
			int[][] land = new int[landSize][landSize];
			for (int i = 0; i < landSize; i++) {
				for (int j = 0; j < landSize; j++) {
					land[i][j] = sc.nextInt();
				}
			}
			// 마법 사용 횟수 및 해당 횟수만큼 입력 받기
			int magics = sc.nextInt();
			for (int n = 0; n < magics; n++) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				int range = sc.nextInt();
				int kindOfMagic = sc.nextInt();
				// 입력한 값들과 마법의 종류에 따라 land 배열에 변화
				switch (kindOfMagic) {
				// 0: 백마법
				case 0:
					white(land, i, j, range);
					break;
				// 1: 흑마법
				case 1:
					black(land, i, j, range);
					break;
				// 2: 잿빛마법-> 백마법과 흑마법을 모두 사용
				case 2:
					white(land, i, j, range);
					black(land, i, j, range);
					break;
				}
			}
			// 땅의 에너지 합 계산 및 출력
			int energy = 0;
			for (int y = 0; y < landSize; y++) {
				for (int x = 0; x < landSize; x++) {
					energy += land[y][x];
				}
			}
			System.out.printf("#%d %d\n", test_case, energy);
		}
	}

	// 백마법
	public static void white(int[][] land, int i, int j, int range) {
		// 마법의 범위 지정
		int[] d = new int[range];
		for (int n = 0; n < d.length; n++) {
			d[n] = n + 1;
		}
		// 마법을 사용한 해당 위치만 우선 처리
		// 0이면 1을 더하고
		// 0이 아니면 두배 해준다.
		if(land[i][j] == 0) {
			land[i][j]++;
		} else land[i][j] *=2;

		// 마법을 사용한 위치 주변 범위 처리
		for (int n = 0; n < d.length; n++) {
			// i좌표 + 범위
			// j좌표 + 범위
			// i좌표 - 범위
			// j좌표 - 범위
			int pi = i + d[n];
			int pj = j + d[n];
			int ni = i - d[n];
			int nj = j - d[n];
			// 아래와 같이 조합 => 십자모양 범위

			// 범위 바깥으로 벗어나지 않는 조건에서
			// 해당 위치가 0이 아니면 2배
			// 0이면 +1
			
			// 아래
			if (pi < land.length) {
				if (land[pi][j] != 0) {
					land[pi][j] *= 2;
				} else
					land[pi][j]++;
			}
			// 오른쪽
			if (pj < land.length) {
				if (land[i][pj] != 0) {
					land[i][pj] *= 2;
				} else
					land[i][pj]++;
			}
			// 위
			if (ni >= 0) {
				if (land[ni][j] != 0) {
					land[ni][j] *= 2;
				} else
					land[ni][j]++;
			}
			// 왼쪽
			if (nj >= 0) {
				if (land[i][nj] != 0) {
					land[i][nj] *= 2;
				} else
					land[i][nj]++;
			}
		}
	}

	// 흑마법
	public static void black(int[][] land, int i, int j, int range) {
		// 마법의 범위 지정
		int[] d = new int[range];
		for (int n = 0; n < d.length; n++) {
			d[n] = n + 1;
		}
		// 마법을 사용한 해당 위치만 우선 처리
		land[i][j] /= 2;
		
		// 마법을 사용한 위치 주변 범위 처리
		for (int n = 0; n < d.length; n++) {
			// i좌표 + 범위
			// j좌표 + 범위
			// i좌표 - 범위
			// j좌표 - 범위
			int pi = i + d[n];
			int pj = j + d[n];
			int ni = i - d[n];
			int nj = j - d[n];
			// 아래와 같이 조합 => 엑스모양 범위

			// 범위 바깥으로 벗어나지 않는 조건에서
			// 해당 위치의 에너지 /2
			
			// 우하단
			if (pi < land.length && pj < land.length) {
				land[pi][pj] /= 2;
			}
			// 좌상단
			if (ni >= 0 && nj >= 0) {
				land[ni][nj] /= 2;
			}
			// 좌하단
			if (pi < land.length && nj >= 0) {
				land[pi][nj] /= 2;
			}
			// 우상단
			if (ni >= 0 && pj < land.length) {
				land[ni][pj] /= 2;
			}

		}
	}
}
