
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static List<Integer>[] adjList;
	static boolean[] visited;

	static Stack<Integer> dfs;
	static Queue<Integer> bfs;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int st = sc.nextInt();
		adjList = new ArrayList[V + 1];

		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			adjList[to].add(from);
		}
		for (int i = 0; i < adjList.length; i++) {
			Collections.sort(adjList[i]);
		}

		dfs = new Stack<>();
		bfs = new LinkedList<>();
		visited = new boolean[V + 1];

		DFS(st);
		System.out.println();
		visited = new boolean[V + 1];

		BFS(st);
	} // tc

	public static void DFS(int st) {

		visited[st] = true;
		System.out.print(st + " ");

		for (int i = 0; i < adjList[st].size(); i++) {
			if (visited[adjList[st].get(i)] == true)
				continue;
			DFS(adjList[st].get(i));
		}

	}

	public static void BFS(int st) {
		bfs.offer(st);
		visited[st] = true;
		while (!bfs.isEmpty()) {
			int node = bfs.poll();
			System.out.print(node + " ");
			for (int i = 0; i < adjList[node].size(); i++) {
				if (!visited[adjList[node].get(i)]) {
					bfs.offer(adjList[node].get(i));
					visited[adjList[node].get(i)] = true;
				}
			}
		}
	}
}
