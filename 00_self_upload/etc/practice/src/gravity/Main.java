package gravity;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 전체 가로세로 길이 지정
		int boxMax = 10;
		
		// 쌓인 상자의 개수를 담은 배열 (가로 100)
		int[] boxes = new int[boxMax];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < boxes.length; i++) {
			// 각 칸의 상자 개수 입력
			boxes[i] = sc.nextInt();
			// 상자 개수가 100 넘게 들어오면 그냥 100으로 해줌 (세로 100)
			if (boxes[i] > boxMax) {
				boxes[i] = boxMax;
			}
		}
		// 최대 낙차 리턴
		System.out.println(boxFalling(boxes));
	}

	// 상자의 최대 낙차를 구해주는 메소드
	public static int boxFalling(int[] boxes) {

		// 각 줄의 최대 낙차(==가장 위에 쌓인 녀석의 낙차)를 담은 배열
		int[] boxFall = new int[boxes.length];

		// 맨 오른쪽 index부터 세어준다.
		// 각 index의 최대 낙차 구하기
		for (int i = boxes.length - 1; i >= 0; i--) {
			
			// 각 자리(i)의 '최대 낙차 잠재력'	== (99 - i)이다.
			
			// 왜냐하면..
			
			// 0번째 (맨앞) 최대낙차잠재력		== 99
			// 1번째 최대낙차잠재력 			== 98
			// ...
			// 99번째 (맨오른쪽) 최대낙차잠재력 	== 0
			boxFall[i] = (boxes.length - 1) - i;

			// index i보다 앞에 있는 녀석 중 더 크거나 같은 녀석이 있다면
			// '최대 낙차 잠재력'에서 하나씩 빼 준다.
			for (int j = boxes.length - 1; j > i; j--) {
				if (boxes[i] <= boxes[j]) {
					boxFall[i] -= 1;
				}
			}
		}

		// 이제 낙차들 중에서 최대값을 찾는다.
		int maxFall = Integer.MIN_VALUE;
		for (int i = 0; i < boxes.length; i++) {
			if (boxFall[i] > maxFall) {
				maxFall = boxFall[i];
			}
		}
		// 최대값 반환
		return maxFall;
	}
}
