
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 먹이가 될 후보를 모아 둠
// 거리가 같다면 가장 i가 가장 작고
// i가 같으면 j가 가장 작은 것을 먹음
class Prey implements Comparable<Prey> {
	int i;
	int j;
	int dist;

	public Prey(int i, int j, int dist) {
		this.i = i;
		this.j = j;
		this.dist = dist;
	}

	@Override
	public int compareTo(Prey o) {
		if (this.dist == o.dist) {
			if (this.i == o.i)
				return Integer.compare(this.j, o.j);
			else
				return Integer.compare(this.i, o.i);
		} else
			return Integer.compare(this.dist, o.dist);
	}

}

public class Main {
	static int N, lv, exp;
	static int[][] field, dist;
	static boolean[][] visited;
	static Queue<int[]> sharQ, huntQ;

	static PriorityQueue<Prey> preyQ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 필드 크기 N, 필드 배열, 상어의 이동거리 배열
		N = Integer.parseInt(br.readLine());
		field = new int[N][N];
		dist = new int[N][N];
		// 상어가 먹이를 먹으로 이동한 위치를 나타내는 sharQ, 상어가 실시간으로 이동할 곳을 BFS해줄 huntQ
		sharQ = new LinkedList<>();
		huntQ = new LinkedList<>();

		// 필드 입력 및 상어 위치 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				field[i][j] = tmp;
				if (tmp == 9) {
					int[] shark = { i, j };
					sharQ.offer(shark);
					field[i][j] = 0;
				}
			}
		}
		// BFS 탐색 중 상어의 먹이가 될 먹이들의 큐
		preyQ = new PriorityQueue<>();

		// 상어의 초기 상태: 레벨2, 경험치 0
		lv = 2;
		exp = 0;

		// here: 상어의 마지막 위치를 저장해서 정답으로 출력하는 역할
		int[] here = { 0, 0 };
		// 상어가 더 움직이지 않을 때까지 BFS 실행
		while (!sharQ.isEmpty()) {
			int[] shark = sharQ.poll();
			// 방문배열 초기화
			visited = new boolean[N][N];
			BFS(shark);
			here = shark;
		}
		// 정답 출력
		System.out.println(dist[here[0]][here[1]]);

	}

	// 상어의 위치로부터 먹이를 찾아 BFS 실시
	static void BFS(int[] shark) {
		int[] di = { -1, 0, 0, 1 };
		int[] dj = { 0, -1, 1, 0 };
		// 이전 실행에서 만진 huntQ와 preyQ를 깨끗이 하고 시작
		preyQ.clear();
		huntQ.clear();
		// 상어 이동
		huntQ.offer(shark);
		visited[shark[0]][shark[1]] = true;
		boolean found = false;
		// 상어가 이동할 수 없을 때까지 실행
		while (!huntQ.isEmpty()) {
			int[] now = huntQ.poll();
			int i = now[0];
			int j = now[1];
			for (int dir = 0; dir < 4; dir++) {
				int ni = i + di[dir];
				int nj = j + dj[dir];
				// 범위밖, 기방문, 나보다 크면 탐색x
				if (ni >= N || nj >= N || ni < 0 || nj < 0 || visited[ni][nj] || field[ni][nj] > lv)
					continue;
				visited[ni][nj] = true;
				dist[ni][nj] = dist[i][j] + 1;
				// 0이 아니면서 나보다 작은 녀석을 먹이 후보에 올린다.
				if (field[ni][nj] < lv && field[ni][nj] != 0) {
					// 먹이를 찾은 상태
					found = true;
					Prey prey = new Prey(ni, nj, dist[ni][nj]);
					preyQ.offer(prey);

				}
				// 0이거나 나와 크기가 같으면 그쪽으로 이동 가능
				else if (field[ni][nj] == lv || field[ni][nj] == 0 || !found) {
					int[] next = { ni, nj };
					huntQ.offer(next);

				}
			}
		}
		// 먹이를 찾은 상태에서 while문이 끝났다면
		// 가장 앞에 있는 먹이(최우선먹이)를 먹는다.
		if (found) {
			Prey prey = preyQ.poll();

			int[] sharkNext = { prey.i, prey.j };
			// 먹었으면 경험치 추가, 조건 달성시 레벨업
			exp++;
			if (exp == lv) {
				lv++;
				exp = 0;
			}
//			System.out.println("먹었습니다! " + sharkNext[0] + " " + sharkNext[1] + " 에 있는 " + field[sharkNext[0]][sharkNext[1]] + " /현재 레벨: " + lev + " 현재 경험치: " + exp);
			// 먹이는 죽어 없어졌다.
			field[sharkNext[0]][sharkNext[1]] = 0;
			// 상어의 다음 위치
			sharQ.offer(sharkNext);
		}
	}
}
