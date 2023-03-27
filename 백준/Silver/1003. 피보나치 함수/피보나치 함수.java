
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[] fibonacci = new int[41];
			fibonacci[0] = 0;
			fibonacci[1] = 1;
			for (int i = 2; i < fibonacci.length; i++) {
				fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
			}

			if (N == 0) {
				System.out.println(1 + " " + 0);
			} else if (N == 1) {
				System.out.println(0 + " " + 1);
			} else
				System.out.println(fibonacci[N - 1] + " " + fibonacci[N]);

		} // tc
	}
}
