package prob001989;

import java.util.Scanner;

class Solution1989 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 단어(string)을 char 배열로 가져오기
			char[] word = sc.next().toCharArray();
			// 단어 길이
			int wordLength = word.length;
			
			// '글자가 일치한다' 를 뜻하는 boolean 변수
			boolean flag = true;
			
			// 단어 처음부터 순회할 때 글자와
			// 단어 끝부터 순회할 때 글차가
			// 일치하지 않으면 flag = false => 탈출 후 0 출력
			// 일치하면 flag = true로 유지 => 1 출력
			for (int i = 0; i < wordLength; i++) {
				if (word[i] != word[wordLength - i - 1]) {
					flag = false;
					break;
				}
			}
			if(flag) System.out.printf("#%d %d\n", test_case, 1);
			else System.out.printf("#%d %d\n", test_case, 0);
		}
		
	}
}