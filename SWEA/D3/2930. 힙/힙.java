
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.printf("#" + test_case);
			// 명령어 개수, heap 크기는 명령어 개수 +1(삽입만 했을 경우+1)
			// 힙, 현재 가진 원소 개수(마지막 인덱스 == pointer)
			
			int N = sc.nextInt();
			int[] heap = new int[N + 1];
			int pointer = 0;

			for (int i = 0; i < N; i++) {

				int command = sc.nextInt();

				switch (command) {
				// 삽입 명령
				// 배열 마지막 인덱스에 추가 후 root를 향해 올라감
				case 1:
					int num = sc.nextInt();
					heap[++pointer] = num;
					int cur = pointer;
					// 힙의 조건: 부모가 자식보다 클 것 -> 자식이 부모보다 큰 경우 위치 교환
					// curr == 1(루트 노드)이면 끝내야 함
					while (cur > 1 && heap[cur] > heap[cur / 2]) {
						swap(heap, cur, cur / 2);
						cur = cur / 2;
					}
					break;
				// 삽입 명령
				// 루트 노드를 출력 및 삭제, 마지막 원소를 루트로, 이후 힙 조건에 맞게 루트에서 리프로 내려감
				case 2:

					// 비어 있으면 -1 출력 후 탈출
					if (pointer == 0) {
						System.out.print(" " + -1);

					} else {
						System.out.print(" " + heap[1]);
						heap[1] = heap[pointer];
						heap[pointer--] = 0;
						// 루트노드에서 시작
						// curr보다 자식이 크면, 둘 중 더 큰 자식과 교환
						int curr = 1;
						while (true) {
							// 일단 왼쪽 자식으로 놓고
							int child = 2 * curr;
							// 오른쪽 자식이 있는 경우, 오른쪽 자식과도 비교해서 더 큰 값
							if (child + 1 <= pointer && heap[child] < heap[child + 1]) {
								child++;
							}

							// 더이상 자식이 없는 리프노드에 갔거나
							// 부모가 자식보다 큰 정상적인 상태면 종료
							if (child > pointer || heap[child] < heap[curr])
								break;

							swap(heap, curr, child);
							curr = child;
						}
					}
				}
			}
			System.out.println();
//			System.out.println(Arrays.toString(heap));
//			System.out.println(pointer);
		}
	}

	private static void swap(int[] heap, int idx1, int idx2) {
		int temp = heap[idx1];
		heap[idx1] = heap[idx2];
		heap[idx2] = temp;
	}
}
