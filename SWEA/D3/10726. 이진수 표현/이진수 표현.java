
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 검사할 N자리, 검사할 숫자 M
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 검사할 자리만 남기기 위해 왼쪽으로 쭉 밀어 덜어내고, 다시 오른쪽으로 쭉 밀기
			int shift = 32 - N;
			int cutBinary = M << shift >>> shift;
			String answer = "OFF";
			// 남은 수가 111..11 형태면 2^n -1 형태
			if (Math.pow(2, N) - 1 == cutBinary) {
				answer = "ON";
			}
			System.out.printf("#%d %s\n", testCase, answer);
		} // tc
	}
}
