package prob001228;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution1228 {
	public static void main(String args[]) throws Exception {

//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

//			LinkedPW linkedPW = new LinkedPW(N);
			int[] origin = new int[N];
			for (int i = 0; i < N; i++) {
				origin[i] = sc.nextInt();
			}

			char command = sc.next().charAt(0);

			switch (command) {
			case 'I':
				int xI = sc.nextInt();
				int yI = sc.nextInt();
				int[] plusPW = new int[yI];
				for (int i = 0; i < yI; i++) {
					plusPW[i] = sc.nextInt();
				}
				break;
			default:

			}
		}
	}

	class LinkedPW {
		int originSize;
		Password head;

		Password tempFront;
		Password tempRear;

		public LinkedPW(int originSize) {
			this.originSize = originSize;
		}

		public void setPW(int N, int[] PW) {

		}

		public void addPW(int N, int[] PW) {
			Password pw0 = new Password(PW[0]);
			Password curr = head;
			if (head == null) {
				head = pw0;
			} else {
				
				while (curr.next != null) {
					curr = curr.next;
				}
				curr.next = pw0;
			}

			for (int i = 1; i < N; i++) {
				Password pw = new Password(PW[i]);
						
				curr.next = pw;

			}
		}

		public void insertPW(int x, int y, int[] plusPW) {

		}

		class Password {
			int digits;
			Password next = null;

			public Password(int digits) {
				this.digits = digits;
			}
		}
	}
}
