package prob005432;

import java.util.Scanner;

class Solution5432 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 괄호 입력받기, 겹친 막대 개수 count, 정답 개수 선언
			char[] bracket = sc.next().toCharArray();
			int count = 0;
			int answer = 0;
			// '(' 나오면 막대 개수 추가된 것
			// ')' 나오면 막대가 마감된 것
			// 단, '(' ')' 연속으로 나오면 마감된 것이 아니라 현재 쌓인 막대가 통째로 잘린 것
			for (int i = 0; i < bracket.length; i++) {
				if (bracket[i] == '(') {
					count++;
				} else if (bracket[i] == ')') {
					count--;
					if (bracket[i - 1] == '(') {
						answer += count;
					} else
						answer += 1;
				}
			}
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}