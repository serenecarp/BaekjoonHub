package prob_tntwkWkrRnd;

import java.util.HashMap;

class Solution {
	public static String solution(String X, String Y) {
		String answer = "";

		HashMap<Integer, Integer> xFreq = new HashMap<>(10);
		HashMap<Integer, Integer> yFreq = new HashMap<>(10);

		char[] xChars = X.toCharArray();
		char[] yChars = Y.toCharArray();

		for (int i = 0; i < xChars.length; i++) {
			int value = 0;
			xFreq.replace(i, ++value);
		}
		
		for (int i = 0; i < yChars.length; i++) {
			int value = 0;
			yFreq.replace(i, ++value);
		}

		System.out.println(xFreq.get(2));
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < Math.min(xFreq.get(i), yFreq.get(i)); j++) {
				answer += i;
			}
		}
		// 0으로 시작하면 (== 이전까지 넣은 숫자가 없어서 0이 제일 큰 숫자면) 0 리턴
		if (answer.substring(0).equals("0")) {
			return "0";
		}
		// 아무것도 없으면 -1 리턴
		if (answer.equals("")) {
			return "-1";
		}
		return answer;
	}
}