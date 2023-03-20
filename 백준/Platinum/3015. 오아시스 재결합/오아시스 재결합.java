
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long answer = 0;
		Stack<Person> people = new Stack<>();
		Person person = new Person(sc.nextInt(), 1);

		people.push(person);
		for (int i = 1; i < N; i++) {

//			System.out.println(answer);
			person = new Person(sc.nextInt(), 1);

			if (people.isEmpty()) {
				people.push(person);
			} else {
				if (people.peek().height < person.height) {
					while (!people.isEmpty() && people.peek().height < person.height) {
						Person temp = people.pop();
						answer += temp.count;
					}
					if (!people.isEmpty() && people.peek().height == person.height) {
						Person temp = people.pop();
						answer += temp.count;
						if (!people.isEmpty()) {
							answer++;
						}
						temp.count++;
						people.push(temp);
					} else {
						if (!people.isEmpty()) {
							answer++;
						}
						people.push(person);
						// 🤣
					}
				} else if (people.peek().height > person.height) {
					people.push(person);
					answer++;
				} else {
					Person temp = people.pop();
					answer += temp.count;
					if (!people.isEmpty()) {
						answer++;
					}
					temp.count++;
					people.push(temp);
				}
			}
//			System.out.println(answer);
//			System.out.println("잘가시지~~~");
		}

		System.out.println(answer);

	}

	static class Person {
		int height;
		int count; // 겹친 사람 수 == 연속 같은 키 사람 수

		Person(int height, int count) {
			this.height = height;
			this.count = count;
		}
	}
}
