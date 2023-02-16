
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {


		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] fly = new int[N][N];
			int[] flapper = new int[M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					fly[i][j] = sc.nextInt();
				}
			}
			
			for (int i=0; i<M; i++) {
				flapper[i] = i;
			}
			
			
			int maxKill = 0;
			

			for (int i = 0; i < N - M +1; i++) {
				for (int j = 0; j < N - M+1; j++) {
					int killable = 0;
					for (int k = 0; k < M*M; k++) {
						int newI = i + flapper[k % M];
						int newJ = j + flapper[k / M];
						killable += fly[newI][newJ];
					}
					if (maxKill < killable) {
						maxKill = killable;
						
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, maxKill);
		}
	}
}