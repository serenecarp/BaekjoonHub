
class Solution {
	public int solution(int n, int[] lost, int[] reserve) {

		int[] students = new int[n];
		int okStd = n;
		
		if (n == 1) {
			if (lost.length == 1 && reserve.length == 0) {
				return 0;
			} else {
				return 1;
			}
		}

		// students: 체육복 개수 배열 (1로 초기화)

		for (int i = 0; i < n; i++) {
			students[i] = 1;
		}

		for (int i = 0; i < lost.length; i++) {
			students[lost[i]-1] -= 1;
		}

		for (int i = 0; i < reserve.length; i++) {
			students[reserve[i]-1] += 1;
		}

		for (int i = 0; i < n - 1; i++) {
			if (students[i + 1] - students[i] == 2) {
				students[i+1] -=1;
				students[i] +=1;
			}

			if (students[i + 1] - students[i] == -2) {
				students[i+1] +=1;
				students[i] -=1;
			}
		}
		
		for (int i=0; i<n ; i++) {
			if(students[i] == 0) {
				okStd--;
			}
		}

		int answer = okStd;
		
		return answer;
	}
}