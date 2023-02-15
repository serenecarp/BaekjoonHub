
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] sum = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			sum[i] = A[i];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					sum[i] = Math.max(sum[j] + A[i], sum[i]);
				}
			}
		}
		int maxVal = 0;

		for(int sumVal : sum) {
			if (sumVal > maxVal) {
				maxVal = sumVal;
			}
		}
		System.out.println(maxVal);
	}
}
