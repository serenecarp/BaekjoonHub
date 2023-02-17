package prob001489;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] powA = new int[N];
		int[] powB = new int[N];
		List<Integer> teamA = new ArrayList<>();
		List<Integer> teamB = new ArrayList<>();
		int score = 0;

		for (int i = 0; i < N; i++) {
			powA[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			powB[i] = sc.nextInt();
		}

		for (int i = 0; i < N - 1; i++) {
			int minIdxA = i;
			int minIdxB = i;
			for (int j = i + 1; j < N; j++) {
				if (powA[minIdxA] > powA[j]) {
					minIdxA = j;
				}
				if (powB[minIdxB] > powB[j]) {
					minIdxB = j;
				}
			}
			swap(powA, minIdxA, i);
			swap(powB, minIdxB, i);
		}

		for (int i = N - 1; i >= 0; i--) {
			teamA.add(powA[i]);
			teamB.add(powB[i]);
		}

		while (teamA.size() > 0) {
//			System.out.println(teamA);
//			System.out.println(teamB);
			if (teamA.get(teamA.size() - 1) > teamB.get(teamB.size() - 1)) {
				teamA.remove(teamA.size() - 1);
				teamB.remove(teamB.size() - 1);
				score += 2;
			} else if (teamA.get(teamA.size() - 1) < teamB.get(teamB.size() - 1)) {
				teamA.remove(teamA.size() - 1);
				teamB.remove(0);
				score += 0;
			} else {
				if (teamA.get(0) > teamB.get(0)) {
					teamA.remove(teamA.size() - 1);
					teamB.remove(teamB.size() - 1);
					score += 1;
				}

				else {
					teamA.remove(teamA.size() - 1);
					teamB.remove(0);
					score += 0;
				}

			}
		}
		System.out.println(score);
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
