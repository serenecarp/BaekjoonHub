package prob002007;

import java.util.Scanner;

class Solution2007 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 문자열을 char배열로 입력
			char[] wordWordWord = sc.next().toCharArray();
			for (int i = 1; i < wordWordWord.length; i++) {
				boolean isPattern = true;

				// 만약 첫글자와 i번째 글자가 일치한다면 검사를 해본다
				if (wordWordWord[i] == wordWordWord[0]) {
					// 범위를 넘어버리면 탈출, 바로 해당 i가 패턴인걸로
					for (int d = 1; d < i; d++) {
						if(i+d >= wordWordWord.length) {
							break;
						}
						// 검사해보고 틀리면 탈출, 패턴이 아니었던 걸로
						if (wordWordWord[d] != wordWordWord[i + d]) {
							isPattern = false;
							break;
						}
					}
					// 검사했는데 패턴이 맞으면 해당 길이 출력
					if (isPattern) {
						System.out.printf("#%d %d\n", test_case, i);
						break;
					}
				}
			}
		}
	}
}