
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			char[] word = sc.next().toCharArray();
			int wordLength = word.length;

			boolean flag = true;

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