package prob001251;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_Kruskal {
	static int N;
	static int[][] island;
	static double[][] tunnel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			// 섬들의 좌표 정보 (x좌표, y좌표, 대표자 idx)
			island = new int[N][3];
			// 초기 set 세팅: 자신의 부모를 자기 자신으로
			makeSet();

			// 섬 정보 입력
			for (int i = 0; i < N; i++) {
				island[i][0] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				island[i][1] = sc.nextInt();
			}

			// 환경 부담 세율
			double E = sc.nextDouble();

			// 섬 사이의 거리 (edge) 정보 (== 지어질 터널의 길이) 입력
			// { 시작섬 idx, 끝섬 idx, 거리 }
			tunnel = new double[N * (N - 1) / 2][3];
			putTunnelInfo();

			// 섬을 N-1개 골랐으면 종료
			int selectedIsland = 0;
			double answer = 0;

			for (int i = 0; i < tunnel.length; i++) {
				// 두 점이 속한 그룹의 대표가 같다면 사이클이 만들어진 것이므로 따지지 않도록 한다.
				if (findSet((int) tunnel[i][0]) == findSet((int) tunnel[i][1])) {
					continue;
				}
//				System.out.println((int) tunnel[i][0] + " " + (int) tunnel[i][1]);
				union((int) tunnel[i][0], (int) tunnel[i][1]);
//				System.out.println(tunnel[i][2]);
				answer += E * tunnel[i][2] * tunnel[i][2];
				selectedIsland++;

				if (selectedIsland == N - 1) {
					break;
				}
			}
			for (int i = 0; i < island.length; i++) {
				System.out.println(island[i][2]);
			}

			System.out.printf("#%d %.0f\n", testCase, answer);
		} // tc
	}

	// 초기 set 세팅: 자신의 부모를 자기 자신으로
	// 메인에서 반복문 돌리지 않고 스태틱 island를 그냥 메소드 안에서 설정함.
	static void makeSet() {
		for (int i = 0; i < N; i++) {
			island[i][2] = i;
		}
	}

	static int findSet(int a) {
		// 자신의 부모가 자신이 아니면 부모를 찾아 떠난다
		if (a != island[a][2]) {
			island[a][2] = findSet(a);
		}
		return island[a][2];
	}

	static void union(int a, int b) {
		island[findSet(b)][2] = findSet(a);
	}

	static void putTunnelInfo() {
		// 섬 두 개를 골라 두 섬 사이의 거리를 tunnel 배열에 입력
		// 두 개만 고르면 되니 2중 for문 사용
		int idx = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				tunnel[idx][0] = i;
				tunnel[idx][1] = j;
				tunnel[idx][2] = getDistance(i, j);
				idx++;
			}
		}
		// 정렬
		Arrays.sort(tunnel, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[2], o2[2]);
			}
		});
	}

	// a섬, b섬 사이의 거리 반환 메소드
	static double getDistance(int a, int b) {
		int x = Math.abs(island[a][0] - island[b][0]);
		int y = Math.abs(island[a][1] - island[b][1]);
		return Math.sqrt(x * x + y * y);
	}
}
