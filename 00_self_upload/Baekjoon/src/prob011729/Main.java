package prob011729;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int disk = sc.nextInt();
		int iter = 1;
		for (int i = 0; i < disk; i++) {
			iter *= 2;
		}
		System.out.println(--iter);;
		hanoi(disk, 1, 3, 2);
	}

	static void hanoi(int disk, int location, int target, int rest) {
		if (disk == 1) {
			System.out.printf("%d %d\n", location, target);
			return;
		}

		hanoi(disk - 1, location, rest, target);
		System.out.printf("%d %d\n", location, target);
		hanoi(disk - 1, rest, target, location);
	}
}
