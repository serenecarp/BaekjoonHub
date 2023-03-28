
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
// 1. 치즈의 좌표에 따른 날짜 정보를 2차원 배열(cheese)에도 담고, map에도 담는다.
// (나중에 x번째 날에 요정이 파먹은 부분의 좌표를 바로바로 찾기 위함)

public class Solution {
	static Map<Integer, List<int[]>> day_loc;

	static int N;
	static int[][] cheese;
	static boolean[][] visited;

	static int maxChunk;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			cheese = new int[N][N];

			// 정렬을 위해 TreeMap으로 생성
			day_loc = new TreeMap<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int day = sc.nextInt();
					// 치즈 날짜정보 저장
					cheese[i][j] = day;
					// 해당 좌표의 day값 정보를 day_loc (map)에 저장
					int[] loc = { i, j };
					// 해당 day에 대한 좌표가 없으면, 새로 리스트를 만들어 map에 삽입
					if (!day_loc.containsKey(day)) {
						day_loc.put(day, new ArrayList<int[]>());
					}
					day_loc.get(day).add(loc);
				}
			}

			maxChunk = 1;
			// 날짜가 지남에 따라 전체 치즈에서 사라지는 부분을 처리
			for (int day : day_loc.keySet()) {
				// 날짜마다 방문배열 초기화
				visited = new boolean[N][N];
				for (int k = 0; k < day_loc.get(day).size(); k++) {
					// 'day'일자에 저장된 좌표들을 훔쳐먹어, 모두 0으로 처리
					int i = day_loc.get(day).get(k)[0];
					int j = day_loc.get(day).get(k)[1];
					cheese[i][j] = 0;
				}
				// 해당 날짜 (day)의 chunk 개수 측정 및 최댓값 갱신
				int chunk = countChunks();
				if (maxChunk < chunk) {
					maxChunk = chunk;
				}
			}

			// 정답 출력
			System.out.printf("#%d %d\n", testCase, maxChunk);

		} // tc
	}

	// DFS 메소드(하나의 chunk를 찾고 처리하는 메소드)가 호출된 횟수만큼
	// 치즈덩어리의 개수++
	public static int countChunks() {

		// 모든 좌표를 탐색하며,
		// 치즈를 훔쳐가 0이 된 부분이거나 이미 방문한 부분이면 세어주지 않는다.
		int chunk = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && cheese[i][j] != 0) {
					DFS(i, j);
					chunk++;
				}
			}
		}
		return chunk;
	}

	// 방문하지 않은, 0이 아닌(아직 훔쳐가지 않은 치즈부분) 한 점을 기준으로
	// 한 덩어리의 visited를 모두 true로 만드는 메소드

	// 탐색을 위해 델타 배열 생성
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void DFS(int i, int j) {

		visited[i][j] = true;
		// 델타탐색을 하는데,
		// 범위 밖이거나, 치즈를 파먹어서 0이 된 부분이거나, 이미 방문한 곳이면 탐색하지 않음
		// 탐색한 한 덩어리를 모두 true로 바꿈
		for (int dir = 0; dir < 4; dir++) {
			int ni = i + di[dir];
			int nj = j + dj[dir];
			if (ni >= N || nj >= N || ni < 0 || nj < 0 || cheese[ni][nj] == 0 || visited[ni][nj]) {
				continue;
			}
			visited[ni][nj] = true;
			DFS(ni, nj);
		}
	}
}
