
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		int stores = sc.nextInt();

		int[][] store = new int[stores][2];
		for (int i = 0; i < stores; i++) {
			store[i][0] = sc.nextInt();
			store[i][1] = sc.nextInt();
		}
		int[] dong = new int[2];
		dong[0] = sc.nextInt();
		dong[1] = sc.nextInt();

		int answer = 0;

		for (int i = 0; i < stores; i++) {
			int dist = 0;
			int indicator = dong[0] + store[i][0];
			if (dong[0] == store[i][0]) {
				dist = store[i][1] - dong[1];
				if (dist < 0)
					dist *= -1;
			} else if (indicator == 3)
				dist = store[i][1] + dong[1] + H;
			else if (indicator == 7)
				dist = store[i][1] + dong[1] + W;
			else if (indicator == 4)
				dist = store[i][1] + dong[1];
			else if (indicator == 6)
				dist = W + H - store[i][1] - dong[1];
			else {
				if (dong[0] == 1 && store[i][0] == 4)
					dist = W - dong[1] + store[i][1];
				else if (dong[0] == 4 && store[i][0] == 1)
					dist = dong[1] + W - store[i][1];
				else if (dong[0] == 3 && store[i][0] == 2)
					dist = H - dong[1] + store[i][1];
				else
					dist = dong[1] + H - store[i][1];
			}
			dist = (dist < 2 * W + 2 * H - dist) ? dist : 2 * W + 2 * H - dist;
			answer += dist;

		}
		System.out.println(answer);

	}
}
