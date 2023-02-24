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
			System.out.println(teamA);
			System.out.println(teamB);
			// 우리팀 꼴찌가 상대팀 꼴찌보다 쎄면
			// 맞짱뜨기
			if (teamA.get(teamA.size() - 1) > teamB.get(teamB.size() - 1)) {
				teamA.remove(teamA.size() - 1);
				teamB.remove(teamB.size() - 1);
				score += 2;
			}
			// 우리팀 꼴찌가 상대팀 꼴찌보다 약하면
			// 상대팀 일등한테 버리기
			else if (teamA.get(teamA.size() - 1) < teamB.get(teamB.size() - 1)) {
				teamA.remove(teamA.size() - 1);
				teamB.remove(0);
				score += 0;
			}
			// 우리팀 꼴찌랑 상대팀 꼴찌랑 같으면??
			else {
				// 우리팀 일등이랑 상대팀 일등 비교
				// 우리팀 일등이 더 잘하면 아까우니까
				// 꼴찌끼리 무승부시키기
				if (teamA.get(0) > teamB.get(0)) {
					teamA.remove(teamA.size() - 1);
					teamB.remove(teamB.size() - 1);
					score += 1;
				}
				// 우리팀 일등이랑 상대팀 일등이랑 같으면
				else if(teamA.get(0) == teamB.get(0)) {
					teamA.remove(teamA.size() - 1);
					teamB.remove(teamB.size() - 1);
					score += 1;
				}
				// 우리팀 일등이 더 못하면
				// 상대팀 일등견제하기 -> 일등이랑 꼴찌랑 붙이기
				else {
					teamA.remove(teamA.size() - 1);
					teamB.remove(0);
					score += 0;
				}

			}
			System.out.println(score);
			System.out.println();

		}
		System.out.println(score);
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
