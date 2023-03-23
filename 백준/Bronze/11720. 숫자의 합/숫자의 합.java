import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] digit = new int[N];

		String num = sc.next();

		int answer = 0;

		for (int i = 0; i < N; i++) {
			answer += Integer.parseInt(num.substring(i, i+1));
		}
		System.out.println(answer);
	}
}