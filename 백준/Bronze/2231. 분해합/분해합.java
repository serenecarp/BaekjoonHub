
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		// 분해합
		for (int i = 0; i <= N; i++) {
			int num = i;
			int sumI = 0;
			while (num != 0) {
				sumI += num % 10;
				num /= 10;
			}
			
			if (i + sumI == N) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);


	}
}
