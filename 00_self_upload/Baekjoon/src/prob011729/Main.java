package prob011729;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int disk = sc.nextInt();
		int location = 1;
		System.out.println(hanoi(disk, location));
	}

	static int hanoi(int disk, int location) {
		int locA = (location + 1) % 3;
		int locB = (location + 2) % 3;
		if (disk == 1) {
			System.out.printf("%d %d\n", disk, 3);
			return 1;
		}

		return hanoi(disk - 1, locA) + hanoi(disk - 1, locB);
	}
}
