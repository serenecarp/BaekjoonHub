package prob_tntwkWkrRnd;

class Solution1 {
	public String solution(String X, String Y) {
		String answer = "";

		int[] xFreq = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] yFreq = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		String[] xChars = X.split("");
		String[] yChars = Y.split("");

		for (int i = 0; i < xChars.length; i++) {
			xFreq[Integer.parseInt(xChars[i])] += 1;
		}

		for (int i = 0; i < yChars.length; i++) {
			yFreq[Integer.parseInt(yChars[i])] += 1;
		}

		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < Math.min(xFreq[i], yFreq[i]); j++) {
				
				answer += i;
			}

		}
		// 0으로 시작하면 (== 이전까지 넣은 숫자가 없어서 0이 제일 큰 숫자면) 0 리턴
		if(answer.substring(0).equals("0")) {
			return "0";
		}
		// 아무것도 없으면 -1 리턴
		if(answer.equals("")) {
			return "-1";
		}
		return answer;
	}
}