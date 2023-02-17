package prob001213;

import java.util.Scanner;

class Solution1213 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;
		// 테스트케이스 10개
		for (int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt();
			// 찾을 문자열 (키워드)와 문장, char배열로 입력
			char[] keyword = sc.next().toCharArray();
			char[] sentence = sc.next().toCharArray();
			// searchWord: 키워드 일치 개수 찾아주는 메소드
			int answer = searchWord(keyword, sentence);
			
			// 정답 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	// 문장 안에 일치하는 keyword가 몇 개 있는지 반환하는 메소드
	public static int searchWord(char[] keyword, char[] sentence) {
		int keyLen = keyword.length;
		int sentLen = sentence.length;
		int count = 0;
		// 문장을 쭉 탐색하면서
		for (int i = 0; i < sentLen - keyLen + 1; i++) {
			boolean flag = true;
			// 해당 문자로부터 키워드길이만큼 검사했을 때
			// 일치하지 않으면 탈출
			for (int j = 0; j < keyLen; j++) {
				if (sentence[i + j] != keyword[j]) {
					flag = false;
					break;
				}
			}
			// 일치한다면 일치개수(count)++
			if (flag)
				count++;
		}

		return count;
	}
}