package prob002383;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 사람들이 계단으로 가서 계단을 내려가는 게 아니라
// 계단 괴물이 사람들을 찾아가서 먹고 소화시킨다고 가정한다.

public class Solution {

	static int N;
	static int[][] room;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			room = new int[N][N];
			int human = 0;
			List<Monster> monster = new ArrayList<>();
			Queue<Integer> victim;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					room[i][j] = sc.nextInt();
					// 사람이면 사람 수 세어주고 괴물이면 괴물 객체 생성
					if (room[i][j] == 1) {
						human++;
					} else if (room[i][j] != 0) {
						monster.add(new Monster(i, j, room[i][j]));
					}
				}
			}

			SnapShot snapShot = new SnapShot(0, human, monster);
			// 생존자가 없고, 괴물이 모두 소화시킬 때까지 진행
			while(snapShot.survivors != 0 && !snapShot.allDigested()) {
				snapShot.time++;
			}
		}
	}

}

class SnapShot {
	int time;
	int survivors;
	List<Monster> monsters;

	public SnapShot(int time, int survivors, List<Monster> monsters) {
		this.time = time;
		this.survivors = survivors;
		this.monsters = monsters;
	}

	public boolean allDigested() {
		boolean flag = true;
		for (Monster monster : monsters) {
			if (!monster.digested()) {
				flag = false;
				break;
			}
		}

		return flag;
	}
}

class Monster {

	int i;
	int j;
	int digesTime;
	Queue<Integer> digest;

	public Monster(int i, int j, int digesTime) {
		this.i = i;
		this.j = j;
		this.digesTime = digesTime;
	}

	public void goEat() {
		int[] di = { -1, 0, 1, 0 };
		int[] dj = { 0, 1, 0, -1 };

	}

	public boolean digested() {
		if (digest.isEmpty()) {
			return true;
		} else {
			return true;
		}
	}

}
