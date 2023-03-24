
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
			myCard = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18));
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
		if (gameRound == 9) {
//			System.out.println(myScore + " vs " + yourScore);
			if (myScore > yourScore) {
				myWins++;
			} else if (myScore < yourScore) {
				yourWins++;
			} 
			return;
		}

		// recur
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
