
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

//		 System.setIn(new FileInputStream("C:\\Users\\SSAFY\\Desktop\\test_input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = 10;
		// 테스트케이스 10개
		for (int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt();
			// 찾을 문자열 (키워드)와 문장, char배열로 입력
			char[] keyword = sc.next().toCharArray();
			char[] sentence = sc.next().toCharArray();
			int answer = searchWord(keyword, sentence);
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	public static int searchWord(char[] keyword, char[] sentence) {
		int keyLen = keyword.length;
		int sentLen = sentence.length;
		int count = 0;
		for (int i = 0; i < sentLen - keyLen + 1; i++) {
			boolean flag = true;
			for (int j = 0; j < keyLen; j++) {
				if (sentence[i + j] != keyword[j]) {
					flag = false;
					break;
				}
			}
			if (flag)
				count++;
		}

		return count;
	}
}