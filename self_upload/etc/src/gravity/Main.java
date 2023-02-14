package gravity;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 쌓인 상자의 개수를 담은 배열 (가로 100)
		int[] boxes = new int[100];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < boxes.length; i++) {
			boxes[i] = sc.nextInt();
			// 상자 개수가 100 넘게 들어오면 그냥 100으로 해줌 (세로 100)
			if (boxes[i] > 100) {
				boxes[i] = 100;
			}
		}
		// 최대 낙차 리턴
		System.out.println(boxFalling(boxes));
	}

	// 상자의 최대 낙차를 구해주는 메소드
	public static int boxFalling(int[] boxes) {

		// 각 줄의 최대 낙차(==가장 위에 쌓인 녀석의 낙차)를 담은 배열
		int[] boxFall = new int[100];

		// 맨 오른쪽 줄은 돌려도 떨어지지 못해서 최대낙차가 0이다.
		boxFall[99] = 0;

		// 뒤에서부터 최대낙차를 구해 나간다.(99는 알고 있고, 98부터 0까지 내려간다)
		for (int i = 98; i >= 0; i--) {
			// 뒤에 녀석보다 작으면 뒤에 녀석과 낙차가 같다
			if (boxes[i] <= boxes[i + 1]) {
				boxFall[i] = boxFall[i + 1];
			}
			// 내가 뒤에 녀석보다 크면 한 칸 더 떨어질 수 있다! (최대낙차 +1)
			else {
				boxFall[i] = boxFall[i + 1] + 1;
			}
		}

		// 이제 낙차들 중에서 최대값을 찾는다. (맘편하게 i는 0~99)
		int maxFall = Integer.MIN_VALUE;
		for (int i = 0; i < 99; i++) {
			if (boxFall[i] > maxFall) {
				maxFall = boxFall[i];
			}
		}
		// 최대값 반환
		return maxFall;

		// 인자를 index로 받고 어케어케 하면 재귀로 풀 수 있을 것 같다.
	}
}
