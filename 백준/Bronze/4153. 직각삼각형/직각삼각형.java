
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int hyp = Integer.MIN_VALUE;
			int a = sc.nextInt();

			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a == 0 && b == 0 && c == 0)
				break;

			hyp = Math.max(Math.max(a, b), c);
			String answer = "wrong";

			if (a * a + b * b + c * c - hyp * hyp == hyp * hyp) {
				answer = "right";
			}
			System.out.println(answer);
		}
	}
}
