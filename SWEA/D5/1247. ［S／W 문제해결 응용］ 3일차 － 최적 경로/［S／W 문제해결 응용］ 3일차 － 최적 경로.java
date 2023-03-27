
import java.util.Scanner;

// 방문해야 하는 지점의 x, y값을 가진 클래스
class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int N;
	static Point[] point;
	static Point[] route;
	static int minDist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 방문할 고객의 수
			N = sc.nextInt();

			// 회사외 집(출발점과 도착점)을 포함한 방문해야 하는 지점들을 담은 배열
			point = new Point[N + 2];
			// 실제 김대리가 어떤 루트로 갈지 시뮬레이션을 돌려 볼 배열
			route = new Point[N + 2];
			// 시작점, 끝점은 회사와 집으로 고정되어 있음
			point[0] = new Point(sc.nextInt(), sc.nextInt());
			point[point.length - 1] = new Point(sc.nextInt(), sc.nextInt());
			route[0] = point[0];
			route[route.length - 1] = point[point.length - 1];
			// 방문할 고객의 좌표 입력
			for (int i = 1; i <= N; i++) {
				point[i] = new Point(sc.nextInt(), sc.nextInt());
			}

			// 경로의 최솟값을 구하고 출력
			minDist = Integer.MAX_VALUE;
			permutation(1, 0, 0);
			System.out.printf("#%d %d\n", testCase, minDist);

		} // tc
	}

	// routeIdx의 0에는 시작점, 끝 N+1에는 끝점이 있으므로
	// 실제 변하는 부분은 1~N 범위의 인덱스 => permutation(1, 0, 0)입력, routeIdx == N+1에서 종료
	public static void permutation(int routeIdx, int visited, int totDist) {
		// base
		if (routeIdx == N + 1) {
			// 마지막 도착점과의 거리까지 더해준 뒤 최솟값이면 갱신
			totDist += getDistance(route[routeIdx], route[routeIdx - 1]);
			if (minDist > totDist) {
				minDist = totDist;
			}
			return;
		}

		// recursive

		// 방문할 고객의 모든 순서를 고려
		// point배열의 고객정보는 1~N 인덱스에 담겨 있어 편의상 j도 1부터 N까지 반복문을 돌림
		// (비트마스킹에서는 1<<(j-1)로 계산)
		for (int j = 1; j <= N; j++) {
			if ((visited & (1 << (j - 1))) != 0) {
				continue;
			}
			// 이번 경로에 해당 고객 위치를 입력하고
			// 다음 고객을 지정하러 routeIdx+1 재귀호출
			// (현재 루트까지의 거리+추가된 거리를 인자로 입력)
			route[routeIdx] = point[j];
			permutation(routeIdx + 1, visited | (1 << (j - 1)),
					totDist + getDistance(route[routeIdx], route[routeIdx - 1]));
		}

	}

	// 두 지점 사이의 거리를 구하는 메소드
	public static int getDistance(Point a, Point b) {
		return abs(a.x - b.x) + abs(a.y - b.y);
	}

	// 절댓값을 구하는 메소드
	public static int abs(int N) {
		if (N < 0) {
			N *= -1;
		}
		return N;
	}
}
