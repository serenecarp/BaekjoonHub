package prob001289;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		List<Integer> testCase = new ArrayList<>();

		for (int test_case = 1; test_case <= T; test_case++) {
			int count = 0;
			String n = "0"+sc.next();
			for (int j = 0; j < n.length()-1; j++) {
				String checker1 = n.substring(j, j+1);
				String checker2 = n.substring(j + 1, j+2);
				
				if (!(checker1.equals(checker2))) {
					count++;
				}
			}
			testCase.add(count);
		}
		for(int i=0; i<T; i++) {
			System.out.printf("#%d %d\n", i+1, testCase.get(i));
		}
		sc.close();
	}
}
