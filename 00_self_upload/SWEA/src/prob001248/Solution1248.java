package prob001248;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1248 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int nodes = sc.nextInt();
			int edges = sc.nextInt();
			int target1 = sc.nextInt();
			int target2 = sc.nextInt();
			sc.nextLine();
			System.out.println(nodes);
			System.out.println(edges);
			System.out.println(target1);
			System.out.println(target2);
			String[] edgeStringBundle = sc.nextLine().split(" ");

			int[] edgeBundle = new int[edgeStringBundle.length];
			for (int i = 0; i < edgeBundle.length; i++) {
				edgeBundle[i] = Integer.parseInt(edgeStringBundle[i]);
			}
			
			System.out.println(Arrays.toString(edgeBundle));
			int k = edgeBundle.length - 1;

			int temp1 = target1;
			int[] parCand1 = new int[nodes];

			int temp2 = target2;
			int[] parCand2 = new int[nodes];

			// 타겟 숫자가 나오면 그때부터 부모님을 찾아가겠다
			// 각각의 부모님 찾은거 대조해서 (더해서 2)
			// ~~~
			while (k >= 0) {
				int child = edgeBundle[k--];
				int parent = edgeBundle[k--];
				if (child == temp1) {
					temp1 = parent;
					parCand1[parent]++;

				}
				if (child == temp2) {
					temp2 = parent;
					parCand2[parent]++;
				}
			}
			int ourParent = 1;
			for (int i = nodes - 1; i >= 0; i--) {
				parCand1[i] += parCand2[i];
				if (parCand2[i] == 2) {
					ourParent = i;
				}
			}
			System.out.println(ourParent);
		}
	}
}
