package prob001238;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static List<Integer>[] contact;
	static boolean[] visited;
	static int deepest;
	static List<Integer> lastContact;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			int inputLen = sc.nextInt();
			int start = sc.nextInt();
			contact = new ArrayList[101];
			for (int i = 0; i < contact.length; i++) {
				contact[i] = new ArrayList<>();
			}
			visited = new boolean[101];

			for (int i = 0; i < inputLen / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				contact[from].add(to);
			}
			

			deepest = 0;
			lastContact = new ArrayList<>();
			visited[start]= true;
			DFS(0, start);
			
			int answer = 0;
			for(int i=0; i<lastContact.size(); i++) {
				if(answer < lastContact.get(i))
					answer = lastContact.get(i);
			}
			System.out.printf("#%d %d\n", testCase, answer);
		} // tc
	}

	static void DFS(int depth, int from) {
		// base

		if (depth > deepest) {
			deepest = depth;
			lastContact = new ArrayList<>();
		}
		if(depth == deepest)
			lastContact.add(from);
		else if(depth < deepest && lastContact.contains(from)) {
			lastContact.remove(Integer.valueOf(from));
		}
		
		System.out.println(deepest + " " + depth + " " +lastContact + " " + from);

		// recursive
		for (int i = 0; i < contact[from].size(); i++) {
			int next = contact[from].get(i);
			if (visited[next]) {
				continue;
			}
			visited[next] = true;
			DFS(depth + 1, contact[from].get(i));
			visited[next] = false;
		}

	}
}
