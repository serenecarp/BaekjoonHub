
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int disk = sc.nextInt();
		int iter = 1;
		for (int i = 0; i < disk; i++) {
			iter *= 2;
		}
		sb.append(--iter).append('\n');
		
		hanoi(disk, 1, 3, 2);
		System.out.println(sb);
	}

	static void hanoi(int disk, int location, int target, int rest) {
		if (disk == 1) {
//			System.out.printf("%d %d\n", location, target);
			sb.append(location + " " + target + "\n");
			return;
		}

		hanoi(disk - 1, location, rest, target);
		sb.append(location + " " + target + "\n");
//		System.out.printf("%d %d\n", location, target);
		hanoi(disk - 1, rest, target, location);
	}
}
