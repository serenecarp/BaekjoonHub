package prob010815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] myCard = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			myCard[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(myCard);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (binarySearch(myCard, num)) {
				System.out.print("1 ");
			} else {
				System.out.print("0 ");
			}
		}
	}

	static boolean binarySearch(int[] myCard, int num) {

		int start = 0;
		int end = myCard.length - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			if (myCard[mid] == num) {
				return true;
			} else if (myCard[mid] < num) {
				start = mid + 1;
			} else if (num < myCard[mid]) {
				end = mid - 1;
			}
		}
		return false;
	}
}
