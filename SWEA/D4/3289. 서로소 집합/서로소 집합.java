
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 숫자 1~N
			// 각 숫자가 속한 대표 p[]
			int N = sc.nextInt();
			p = new int[N + 1];
			// 초기 설정: 각 숫자의 대표는 자기 자신
			makeSet();
			// 명령어의 개수 M과 명령어 입력 받기
			int M = sc.nextInt();
			sb = new StringBuilder();
			for (int commandLine = 0; commandLine < M; commandLine++) {
				int command = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				switch (command) {
				// 0: a와 b를 합침
				case 0:
					union(a, b);
					break;
				// 1: a와 b의 집합 검사
				case 1:
					int yes = 1;
					if (!checkSet(a, b))
						yes = 0;
					sb.append(yes);
					break;
				}
			}
			// 출력
			
			System.out.printf("#%d %s\n", testCase, sb);
		} // tc
	}

	// 집합 초기 상태 설정 - 자기 자신을 대표자로
	static void makeSet() {
		for (int i = 1; i < p.length; i++) {
			p[i] = i;
		}
	}

	static int findSet(int x) {
		if (p[x] == x) {
			return x;
		}
		return p[x] = findSet(p[x]);
	}

	// 두 숫자가 같은 집합인지 검사
	static boolean checkSet(int a, int b) {
		boolean check = false;
		if (findSet(a) == findSet(b)) {
			check = true;
		}
		return check;
	}

	// 두 숫자를 같은 집합으로: 대표자를 일치시킴
	static void union(int a, int b) {
		if (findSet(a) > findSet(b)) {
			p[findSet(a)] = findSet(p[b]);
		} else {
			p[findSet(b)] = findSet(p[a]);
		}
	}
}
