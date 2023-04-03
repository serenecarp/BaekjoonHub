package prob001267;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스
		for (int testCase = 1; testCase <= 10; testCase++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			// 인접리스트
			List<Integer>[] list = new ArrayList[V + 1];
			for (int i = 1; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			// 진입차수 배열
			int[] inDeg = new int[V + 1];

			for (int i = 0; i < E; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				list[st].add(ed);
				// 끝노드 진입차수++
				inDeg[ed]++;
			}
			// 큐
			Queue<Integer> queue = new LinkedList<>();

			// 위상정렬 시작
			// 진입차수가 0인 노드를 queue에 삽입
			StringBuilder sb = new StringBuilder();
			for (int node = 1; node < V + 1; node++) {
				if (inDeg[node] == 0) {
					queue.add(node);
				}
			}
			// 큐가 빌 때까지 진행
			while (!queue.isEmpty()) {
				// 큐에서 하나 뽑는다. (뽑는 대로 정답에 append)
				int selectedNode = queue.poll();
				sb.append(selectedNode + " ");
				// 뽑힌 노드와 연결된 다른 노드의 진입차수를 1 감소시키고,
				// 만약 0이 되었다면 queue에 넣는다.
				for (int node = 0; node < list[selectedNode].size(); node++) {
					int edNode = list[selectedNode].get(node);
					inDeg[edNode]--;
					if(inDeg[edNode] == 0) {
						queue.add(edNode);
					}
				}
			}
			System.out.printf("#%d %s\n", testCase, sb);

		} // tc
	}
}
