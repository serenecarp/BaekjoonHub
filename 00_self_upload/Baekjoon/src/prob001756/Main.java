package prob001756;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner sc = new Scanner(System.in);
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] oven = new int[D];
		st = new StringTokenizer(br.readLine());
		int minOv = Integer.MAX_VALUE;
		for (int i = 0; i < D; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
			if (minOv > oven[i]) {
				minOv = oven[i];
			} else {
				oven[i] = minOv;
			}
		}

		st = new StringTokenizer(br.readLine());
		int ddx = D - 1;
		int answer = 0;
		for (int j = 0; j < N; j++) {
			int pizza = Integer.parseInt(st.nextToken());
			while (ddx >= 0) {

				if (oven[ddx] >= pizza) {
					answer = ddx;
					ddx--;

					break;
				}
				ddx--;
			}
			if (ddx < 0) {
				answer = -1;
				break;
			}

		}
		if (answer + 1 < 0) {
			System.out.println(0);
		} else {
			System.out.println(answer + 1);
		}
	}
}
