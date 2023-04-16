package prob010026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] normal = new int[N][N];
		boolean[][] visitN = new boolean[N][N];
		int[][] disabled = new int[N][N];
		boolean[][] visitD = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				char rgb = line.charAt(j);
				if (rgb == 'R') {
					normal[i][j] = 0;
					disabled[i][j] = 0;
				} else if (rgb == 'G') {
					normal[i][j] = 1;
					disabled[i][j] = 0;
				} else {
					normal[i][j] = 2;
					disabled[i][j] = 2;
				}
			}
		}
		int countN = 0;
		int countD = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitN[i][j]) {
					visitN[i][j] = true;
					DFS(normal, visitN, i, j);
					countN++;
				}
				if (!visitD[i][j]) {
					visitD[i][j] = true;
					DFS(disabled, visitD, i, j);
					countD++;
				}
			}
		}
		System.out.println(countN + " " + countD);

	}

	public static void DFS(int[][] person, boolean[][] visit, int i, int j) {
		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		for (int dir = 0; dir < 4; dir++) {
			int ni = i + di[dir];
			int nj = j + dj[dir];
			if (ni >= N || nj >= N || ni < 0 || nj < 0 || visit[ni][nj] || person[ni][nj] != person[i][j])
				continue;
			visit[ni][nj] = true;
			DFS(person, visit, ni, nj);
		}
	}
}
