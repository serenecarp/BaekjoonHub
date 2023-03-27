
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			int tmp = i;
			while (tmp % 5 == 0) {
				tmp /= 5;
				answer++;
			}
		}
		System.out.println(answer);
	}
}
