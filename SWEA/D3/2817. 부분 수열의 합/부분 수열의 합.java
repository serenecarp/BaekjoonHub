
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 수열 원소 개수, 목표 합 설정
			int N = sc.nextInt();
			int subSum = sc.nextInt();
			// 부분수열의 합이 subSum이 되는 경우의 수 count
			int count = 0;

			// 전체 수열 입력받기
			int[] seq = new int[N];
			for (int i = 0; i < N; i++) {
				seq[i] = sc.nextInt();
			}

			// 1<<N(==2^N)가지 경우의 수를 모두 따져준다.
			for (int i = 0; i < (1 << N); i++) {
				// 수열의 해당 원소가 존재하면,
				// mySum에 그 원소를 더해준다.
				// 다 더해주면 그 경우의 수의 총합이다.
				int mySum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0) {
						mySum += seq[j];
						
						// 그 합이 목표합보다 커버리면 이미 글러버린 경우이므로 break
						if(mySum > subSum) {
							break;
						}
					}
				}
				// 그 합이 목표 합과 같으면 ok
				if (mySum == subSum) {
					count++;
				}
				
			}
			System.out.printf("#%d %d\n", testCase, count);
		} // tc
	}
}
