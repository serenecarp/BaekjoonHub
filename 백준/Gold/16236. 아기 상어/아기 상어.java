
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

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
	static int N, lev, exp;
	static int[][] field, dist;
	static boolean[][] visited;
	static Queue<int[]> sharQ, huntQ;

	static PriorityQueue<Prey> preyQ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		field = new int[N][N];
		dist = new int[N][N];
		sharQ = new LinkedList<>();
		huntQ = new LinkedList<>();

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
		preyQ = new PriorityQueue<>();

		lev = 2;
		exp = 0;

		int[] here = { 0, 0 };
		while (!sharQ.isEmpty()) {
			int[] shark = sharQ.poll();
			visited = new boolean[N][N];
			BFS(shark);
			here = shark;

		}
		System.out.println(dist[here[0]][here[1]]);

	}

	static void BFS(int[] shark) {
		int[] di = { -1, 0, 0, 1 };
		int[] dj = { 0, -1, 1, 0 };
		preyQ.clear();
		huntQ.clear();
		huntQ.offer(shark);
		visited[shark[0]][shark[1]] = true;
		boolean found = false;
		while (!huntQ.isEmpty()) {
			int[] now = huntQ.poll();
			int i = now[0];
			int j = now[1];
			for (int dir = 0; dir < 4; dir++) {
				int ni = i + di[dir];
				int nj = j + dj[dir];
				// 범위밖, 기방문, 나보다 크면 탐색x
				if (ni >= N || nj >= N || ni < 0 || nj < 0 || visited[ni][nj] || field[ni][nj] > lev)
					continue;
				visited[ni][nj] = true;
				dist[ni][nj] = dist[i][j] + 1;
				if (field[ni][nj] < lev && field[ni][nj] != 0) {
					found = true;
					Prey prey = new Prey(ni, nj, dist[ni][nj]);
					preyQ.offer(prey);
					
				} else if (field[ni][nj] == lev || field[ni][nj] == 0 || !found) {
					int[] next = { ni, nj };
					huntQ.offer(next);
					
				}
			}
		}
		if (found) {
			Prey prey = preyQ.poll();

			int[] sharkNext = { prey.i, prey.j };
			exp++;
			if(exp == lev) {
				lev++;
				exp = 0;
			}
//			System.out.println("먹었습니다! " + sharkNext[0] + " " + sharkNext[1] + " 에 있는 " + field[sharkNext[0]][sharkNext[1]] + " /현재 레벨: " + lev + " 현재 경험치: " + exp);
			field[sharkNext[0]][sharkNext[1]] = 0;
			sharQ.offer(sharkNext);
		}
	}

	static void selectPrey() {

	}
}
