package josephus;

import java.util.Scanner;

public class Josephus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int k = sc.nextInt();
		MyList josephus = new MyList(people, k);
		josephus.print();
		josephus.kKill();
	}
}

class MyList {
	int people;
	int k;

	Person head;
	Person tail;

	class Person {
		int myNo;
		Person next = null;

		public Person(int myNo) {
			this.myNo = myNo;
		}

	}

	public MyList(int people, int k) {
		this.people = people;
		this.k = k;
		this.setList();
	}

	public void setList() {
		for (int i = 1; i <= this.people; i++) {
			addPerson(i);
		}
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	public void addPerson(int myNo) {
		Person person = new Person(myNo);
		if (head == null) {
			head = person;
			person.next = person;
		} else {
			Person temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			person.next = head;
			temp.next = person;

			tail = person;
		}
	}

	public void delPerson(Person before) {
		if (head == null) {
			System.out.println("제거할 인원이 없습니다.");
		} else {

			before.next = before.next.next;
//			target.next = null;
		}
	}

	public void kKill() {
		//
		Scanner sc = new Scanner(System.in);
		int count = 0;
		Person temp = head;
		while (!isEmpty() && sc.nextInt() == 1) {

//			System.out.printf("%d번 말고\n", temp.myNo);

			if (count++ % k== k - 1) {

				System.out.printf("%d번 제거\n", temp.next.myNo);
				delPerson(temp);

			} else {
				System.out.printf("%d번 말고\n", temp.next.myNo);
			}
			print();
			temp = temp.next;
			System.out.println(temp.myNo);
		}
	}

	public void print() {
		System.out.print("참여자: ");
		if (head == null) {
			System.out.print("없음");
		} else if (head.next == head) {
			System.out.printf("%d번", head.myNo);
		} else {
			Person temp = head;
			while (temp.next != head) {
				System.out.printf("%d번 ", temp.myNo);
				temp = temp.next;
			}
			System.out.printf("%d번", temp.myNo);
		}
		System.out.println();

	}
}