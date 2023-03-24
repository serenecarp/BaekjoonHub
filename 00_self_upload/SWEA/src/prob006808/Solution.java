package prob006808;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	// my == 인영, your == 규영
	static List<Integer> myCard;
	static List<Integer> yourCard;

	static int myWins;
	static int yourWins;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 인영 카드
			myCard = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18));
			// 규영 카드
			yourCard = new ArrayList<>();
			for (int i = 0; i < 18 / 2; i++) {
				int card = sc.nextInt();
				myCard.remove(Integer.valueOf(card));
				yourCard.add(card);
			}

			myWins = 0;
			yourWins = 0;

			letsGame(0, 0, 0, 0);

			System.out.printf("#%d %d %d\n", testCase, yourWins, myWins);
		} // tc
	}

	public static void letsGame(int gameRound, int picked, int myScore, int yourScore) {
		// base
		// 9라운드 모두 끝나면 종료
		// 인영이가 이기면 인영++, 규영이가 이기면 규영++
		if (gameRound == 9) {
			if (myScore > yourScore) {
				myWins++;
			} else if (myScore < yourScore) {
				yourWins++;
			} 
			return;
		}

		// recur
		// 다 따져보는 순열
		for (int i = 0; i < 9; i++) {
			if (((1 << i) & picked) != 0) {
				continue;
			}
			if (myCard.get(i) > yourCard.get(gameRound))
				letsGame(gameRound + 1, (1 << i) | picked, myScore + myCard.get(i) + yourCard.get(gameRound),
						yourScore);
			else
				letsGame(gameRound + 1, (1 << i) | picked, myScore,
						yourScore + myCard.get(i) + yourCard.get(gameRound));
		}
	}
}
