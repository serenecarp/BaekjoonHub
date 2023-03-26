package boj230326_UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E {
	static Course[] courses;
	static int N;
	static int K;

	static int maxVal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		courses = new Course[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			Course course = new Course(a, b, c);
			courses[i] = course;

		}
		maxVal = Integer.MIN_VALUE;
		selectCourse(0, 0, 0, 0, 0, 0);
		System.out.println(maxVal);

	}

	// lecIdx : 전체 강의 idx
	// selecNo : 내가 이제 고를 강의 dix
	// selected: 내가 골랐는지 안골랐는지 방문 비트
	static void selectCourse(int lecIdx, int selectNo, int selected, int aSum, int bSum, int cSum) {
		// base
		// 다골랐으면 돌아가기
		if (selectNo == K) {
			System.out.println("a: " + aSum + ", b: " + bSum + ", c: " + cSum);
			if (maxVal < aSum + bSum) {
				maxVal = aSum + bSum;
			}
			if (maxVal < bSum + cSum) {
				maxVal = bSum + cSum;
			}
			if (maxVal < cSum + aSum) {
				maxVal = cSum + aSum;
			}
			return;
		}

		// recursive
		for (int i = lecIdx; i <= N - K + selectNo; i++) {

			if ((selected & (1 << i)) != 0) {
				continue;
			}
			selectCourse(lecIdx + 1, selectNo + 1, selected | (1 << i), aSum + courses[i].a, bSum + courses[i].b,
					cSum + courses[i].c);
		}
	}
}

class Course {
	int a = 0;
	int b = 0;
	int c = 0;

	public Course(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

}
