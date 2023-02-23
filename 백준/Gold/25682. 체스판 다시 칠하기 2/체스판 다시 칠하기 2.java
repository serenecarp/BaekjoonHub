
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int chessSize = sc.nextInt();

		char[][] boardB = new char[N][M];
		char[][] boardW = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] row = sc.next().toCharArray();
			boardB[i] = row;
			boardW[i] = row;
		}

//		int[][] zeroOrOneB = new int[N][M];
//		int[][] zeroOrOneW = new int[N][M];
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if ((i + j) % 2 == 0) {
//					zeroOrOneB[i][j] = (boardB[i][j] == 'B') ? 0 : 1;
//					zeroOrOneW[i][j] = (boardW[i][j] == 'W') ? 0 : 1;
//
//				} else {
//					zeroOrOneB[i][j] = (boardB[i][j] == 'W') ? 0 : 1;
//					zeroOrOneW[i][j] = (boardW[i][j] == 'B') ? 0 : 1;
//
//				}
//			}
//		}
		int[][] zeroOrOneB = new int[N+1][M+1];
		int[][] zeroOrOneW = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if ((i + j) % 2 == 0) {
					zeroOrOneB[i][j] = (boardB[i-1][j-1] == 'B') ? 0 : 1;
					zeroOrOneW[i][j] = (boardW[i-1][j-1] == 'W') ? 0 : 1;

				} else {
					zeroOrOneB[i][j] = (boardB[i-1][j-1] == 'W') ? 0 : 1;
					zeroOrOneW[i][j] = (boardW[i-1][j-1] == 'B') ? 0 : 1;

				}
			}
		}
//		System.out.println(Arrays.deepToString(zeroOrOneB));


		int[][] countB = new int[N + 1][M + 1];
		int[][] countW = new int[N + 1][M + 1];

//		for (int i = 1; i < N; i++) {
//			for (int j = 1; j < M; j++) {
//				countB[i][j] += zeroOrOneB[i][j] + countB[i - 1][j] + countB[i][j - 1]
//						- countB[i - 1][j - 1];
//				countW[i][j] += zeroOrOneW[i][j] + countW[i - 1][j] + countW[i][j - 1]
//						- countW[i - 1][j - 1];
//			}
//		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				countB[i][j] += zeroOrOneB[i][j] + countB[i - 1][j] + countB[i][j - 1]
						- countB[i - 1][j - 1];
				countW[i][j] += zeroOrOneW[i][j] + countW[i - 1][j] + countW[i][j - 1]
						- countW[i - 1][j - 1];
			}
		}

//		System.out.println(Arrays.deepToString(countB));
		int minCount = Integer.MAX_VALUE;

		for (int i = chessSize; i <= N; i++) {
			for (int j = chessSize; j <= M; j++) {
				int colorCountB = countB[i][j] - countB[i - chessSize][j] - countB[i][j - chessSize]
						+ countB[i - chessSize][j - chessSize];
				int colorCountW = countW[i][j] - countW[i - chessSize][j] - countW[i][j - chessSize]
						+ countW[i - chessSize][j - chessSize];
//				System.out.println(colorCountB + " " + colorCountW);
				if (minCount > colorCountB) {
					minCount = colorCountB;
				}
				if (minCount > colorCountW) {
					minCount = colorCountW;
				}
			}
		}
		

		System.out.println(minCount);
	}
}
