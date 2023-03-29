package prob007465;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] member;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 멤버의 index와 정보가 같지만.. 그래도 이름을 붙여줌
			// [0]에 멤버번호, [1]에 멤버부모
			member = new int[N + 1][2];
			for (int x = 1; x <= N; x++) {
				makeSet(x);
			}
			// M개의 edge 정보를 통해 a와 b를 그룹화
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a, b);
			}

			// 그룹장의 번호를 인덱스로 하는 배열 group
			boolean[] group = new boolean[N + 1];
			int count = 0;
			// 그룹장의 수 == 그룹의 수
			// 그룹장의 수를 count
			for (int i = 1; i <= N; i++) {
				int representative = findSet(i);
				if (!group[representative]) {
					group[representative] = true;
					count++;
				}
			}
			System.out.printf("#%d %d\n", testCase, count);
		} // tc
	}

	// 처음 set을 생성할 때, 자기 자신의 정보를 설정하고, 그 부모도 자기 자신으로 설정
	public static void makeSet(int x) {
		member[x][0] = x;
		member[x][1] = x;
	}
	
	// set을 합칠 때
	// 상대 그룹의 짱(f(a))을 우리 그룹의 짱(f(b))으로 갱신시켜 준다. => 그룹 통합
	public static void union(int a, int b) {

		member[findSet(a)][1] = findSet(b);

	}

	// 우리 그룹의 짱 찾기
	public static int findSet(int x) {
		// 본인이 짱이 아니라면,
		// 짱을 찾으러 간다.
		// 찾으러 가면서 만난 사람들의 짱을 최고짱으로 갱신
		if (member[x][0] != member[x][1]) {
			member[x][1] = findSet(member[x][1]);
		}
		return member[x][1];
	}

	
}
