// 마이쮸 개수 3 이하에서 작동 안됨!!
package myChu;

import java.util.Scanner;

public class MyChu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("전체 마이쮸의 개수 입력: ");
		int totalChu = sc.nextInt();
		MyChuSimulation simul = new MyChuSimulation(totalChu);
		// 마이쮸 다 떨어질 때까지 수행
		while (simul.nowTotalChu > 0) {
			// 엔터를 누르면 step 진행
			System.out.println("다음 step으로 진행하려면 enter를 누르세요..\n\n");

			if (sc.nextLine().length() == 0) {
				simul.proceedNprint();
			}
		}
	}
}
// 원형큐 구현 (필요한 기능만 구현)
class MyChuSimulation {
	int totalChu;
	int nowTotalChu;
	int qSize;
	Person[] rowForChu;
	int front = 0;
	int rear = 0;
	Person person;
	int count;
	Person temp;

	// 마이쮸시뮬레이션 생성자
	public MyChuSimulation(int totalChu) {
		this.totalChu = totalChu;
		this.nowTotalChu = totalChu;
		// 원형큐 사이즈 == 사람 수는 대충 마이쮸개수보단 적을 테니..
		this.qSize = totalChu;
		this.rowForChu = new Person[qSize];
		this.count = 1;
	}
	
	// 마이쮸 시뮬레이션에 참가할 사람들의 명단
		class Person {
			int personNum;
			int myTurnChu;
			int myTotalChu;

			public Person(int num) {
				this.personNum = num;
				this.myTurnChu = 1;
				this.myTotalChu = 0;
			}
		}

	// 마이큐 뒤에 사람 넣기
	public void enQueue(Person person) {
		rear = ++rear % qSize;
		rowForChu[rear] = person;
	}

	// 마이큐 앞에서 사람 빼기
	public Person deQueue() {
		front = ++front % qSize;
		return rowForChu[front];
	}

	// 마이쮸를 나눠주는 과정
	// 사람이 없으면 사람을 넣는다.
	// 사람이 있으면 맨 앞사람을 빼고 마이쮸를 쥐어준다. (전체마이쮸에서 해당 개수 빠짐)
	// 그 사람을 맨 뒤에 다시 넣고 (받아야할 개수 ++)
	// 새로운 사람을 또 넣는다.
	public void distribute() {
		if (this.count == 1) {
			enQueue(new Person(this.count++));
		} else {
			Person iGotIt = deQueue();
			iGotIt.myTotalChu += iGotIt.myTurnChu;
			this.nowTotalChu -= iGotIt.myTurnChu;
			iGotIt.myTurnChu += 1;
			enQueue(iGotIt);
			enQueue(new Person(this.count++));
		}
	}

	// 현재 사람이 몇 명 있는지
	// 사람 번호의 최대값
	public int peopleNow() {
		int peopleNow = 0;
		if (peopleNow < rowForChu[rear].personNum) {
			peopleNow = rowForChu[rear].personNum;
		}
		return peopleNow;
	}

	// 제일 앞에 있는 사람은 누구인지
	public Person peek() {
		return rowForChu[front + 1];
	}

	// 단계 진행 및 출력
	public void proceedNprint() {
		// 나눠줘보고
		// 마이쮸가 다 떨어졌으면 마무리멘트 출력
		// 마이쮸가 남았으면 진행멘트 출력
		distribute();
		if (nowTotalChu <= 0) {
			System.out.printf("* 마지막에 %d번이 %d개 받았습니다!\n", this.temp.personNum, nowTotalChu + this.temp.myTurnChu - 1);
			return;
		} else {
			System.out.printf("* 현재 %d명이 마이쮸를 기다리고 있습니다.\n", peopleNow());
			System.out.printf("* 총 %d개 중, %d개 나눠줘서, %d개 남았습니다.\n", totalChu, totalChu - nowTotalChu, nowTotalChu);
			System.out.printf("* 다음에는 %d번에게 %d개 줘야 합니다.\n\n", peek().personNum, peek().myTurnChu);
			this.temp = peek();
		}
	}	
}