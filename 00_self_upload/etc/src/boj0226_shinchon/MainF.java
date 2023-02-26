package boj0226_shinchon;

import java.util.Scanner;

public class MainF {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		String[] banner = sc.nextLine().split(" ");
//		System.out.println(Arrays.toString(banner));

		int temp = (M * 9 % 10 == 0) ? 0 : 1;
		int k = M * 9 / 10 + temp;
		
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(banner[i]);
		}

		// 초기 M개
		int[] checkA = new int[1000001];
		boolean yes = false;
		for (int i = 0; i < M; i++) {
			checkA[A[i]]++;
			if (checkA[A[i]] >= k) {
				yes = true;
				break;
			}
		}
		// M+1부터
		for (int i = M; i < N; i++) {
			checkA[A[i - M]]--;
			checkA[A[i]]++;
			if (checkA[A[i]] >= k) {
				yes = true;
				break;
			}
		}
		
		if(yes)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
