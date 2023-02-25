package prob001230;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution1230 {
	public static void main(String args[]) throws Exception {

//		System.setIn(new FileInputStream("C:\\Users\\Carp\\Downloads\\input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.printf("#%d ", test_case);
			LinkedPassword myPW = new LinkedPassword();
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				myPW.addPW(sc.nextInt());
			}
			myPW.printTen();

			int commands = sc.nextInt();
			for (int i = 0; i < commands; i++) {
				String command = sc.next();
				switch (command) {
				case "I":
					int x = sc.nextInt();
					int yI = sc.nextInt();
					for (int jI = 0; jI < yI; jI++) {
						myPW.insertPW(x, sc.nextInt());
					}
					myPW.printTen();

					break;

				case "D":
					myPW.deletePW(sc.nextInt(), sc.nextInt());
					myPW.printTen();

					break;
				case "A":
					int yA = sc.nextInt();
					for (int jA = 0; jA < yA; jA++) {
						myPW.addPW(yA);
					}
					myPW.printTen();

				}
			}
			myPW.printTen();
			System.out.println();
		}
	}
}

class LinkedPassword {

	Password head;
	Password tail;

	class Password {
		int pw;
		Password next = null;

		public Password(int pw) {
			this.pw = pw;
			this.next = null;
		}

//		public Password(int pw, Password next) {
//			this.pw = pw;
//		}
	}

//	}
//	public void createPW(int pw) {
//		Password password = new Password(pw);
//	}

	public void insertPW(int beforeIdx, int pw) {
		Password password = new Password(pw);
		if (head == null) {
			head = password;
		} else {
			Password temp = head;
			for (int i = 0; i < beforeIdx; i++) {
				temp = temp.next;

			}
			password.next = temp.next;
			temp.next = password;
		}
	}

	public void deletePW(int beforeIdx, int n) {
		Password temp = head;
		for (int i = 0; i < beforeIdx; i++) {
			temp = temp.next;
		}
		Password temp1 = temp;

		for (int i = 0; i < n; i++) {
			temp = temp.next;
		}
		temp1.next = temp;
	}

	public void addPW(int pw) {
		Password password = new Password(pw);
//		System.out.println(password.next);
		if (head == null) {
			this.head = password;
		} else {
			lastPW().next = password;
		}
	}

	public Password lastPW() {
		Password temp = head;
		while (head.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	public Password indexPW(int idx) {
		Password temp = head;
		int count = 0;
		while (idx != count) {
			temp = temp.next;
			count++;
		}
		return temp;
	}

	public void printTen() {
		Password temp = head;
		for (int i = 0; i < 10; i++) {
			if (temp.next == null) {
				break;
			}
			System.out.print(temp.pw + " ");

			temp = temp.next;
		}
	}

}