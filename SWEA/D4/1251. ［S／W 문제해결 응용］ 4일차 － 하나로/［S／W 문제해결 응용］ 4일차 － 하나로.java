
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 섬들의 정보 입력
			int N = sc.nextInt();
			Island[] island = new Island[N];
			for (int i = 0; i < N; i++) {
				island[i] = new Island(sc.nextInt(), 0);
			}
			for (int i = 0; i < N; i++) {
				island[i].y = sc.nextInt();
			}
			// 환경 부담 세율 E
			double E = sc.nextDouble();

			// 모든 edge의 리스트 == 인접리스트 (각 섬당 연결된 edge들의 배열)
			List<Tunnel>[] adjList = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adjList[i] = new ArrayList<>();
			}
			// 가능한 모든 섬들의 edge를 입력
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					Tunnel edge1 = new Tunnel(i, j, getDistance(island[i], island[j]));
					Tunnel edge2 = new Tunnel(j, i, getDistance(island[i], island[j]));
					adjList[i].add(edge1);
					adjList[j].add(edge2);
				}
			}
			// 현재 갈 수 있는 edge의 후보 pq
			PriorityQueue<Tunnel> tunnelGroup = new PriorityQueue<>();

			// 첫 섬 하나를 선택하고 시작
			island[0].visited = true;
			tunnelGroup.addAll(adjList[0]);
			int selected = 1;
			double totCost = 0;

			// N개를 고를 때까지
			while (selected < N) {
				// 정렬되었으므로, 터널 후보 중 가장 짧은 터널을 선택해서 뽑음
				Tunnel tunnel = tunnelGroup.poll();
				// 이미 방문한 섬이면 다음 후보 선택, continue
				if (island[tunnel.ed].visited) {
					continue;
				}
				// 해당 터널을 선택하고,
				// 터널과 연결된 다음 섬을 방문처리,
				// 다음 섬과 연결된 다음 터널을 터널후보메 넣기
				totCost += E * tunnel.dist * tunnel.dist;
				island[tunnel.ed].visited = true;
				tunnelGroup.addAll(adjList[tunnel.ed]);
				selected++;
			}
			System.out.printf("#%d %.0f\n", testCase, totCost);
		} // tc

	}

	// 두 섬 사이의 거리 구해주는 메소드
	public static double getDistance(Island a, Island b) {
		double dx = Math.abs(a.x - b.x);
		double dy = Math.abs(a.y - b.y);
		double dist = Math.sqrt(dx * dx + dy * dy);
		return dist;
	}
}

// 섬의 정보 (x좌표, y좌표, 방문여부)
class Island {
	int x;
	int y;
	boolean visited;

	public Island(int x, int y) {
		this.x = x;
		this.y = y;
		this.visited = false;
	}
}

// 터널 정보 (시작섬, 끝섬, 터널길이)
class Tunnel implements Comparable<Tunnel> {
	// a, b: Island[] 의 인덱스 (섬번호)
	int st;
	int ed;
	double dist;

	public Tunnel(int st, int ed, double dist) {
		this.st = st;
		this.ed = ed;
		this.dist = dist;
	}

	// priority queue 를 위한 compareTo
	@Override
	public int compareTo(Tunnel o) {
		return Double.compare(this.dist, o.dist);
	}

}