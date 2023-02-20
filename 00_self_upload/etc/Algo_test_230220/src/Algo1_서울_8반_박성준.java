import java.util.Scanner;

public class Algo1_서울_8반_박성준 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		// 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			// 싸피나라 크기 size
			// 지진의 횟수 eq
			// 싸피나라 보강비용 배열 ssafyNara
			// 보강비용 합계 sum
			int size = sc.nextInt();
			int eq = sc.nextInt();
			int[] ssafyNara = new int[size];
			int sum = 0;

			// 지진 횟수만큼 보강비용 계산
			for (int n = 0; n < eq; n++) {
				// 진원지, 강도 입력
				// 진원지는 배열의 index를 위해 1 빼서 사용함
				int loc = sc.nextInt() - 1;
				int pow = sc.nextInt();
				// 강도가 1인 경우 해당 위치에 1만 더해주면 되므로
				// 그냥 1 더하고 continue (다음 강도로)
				if (pow == 1) {
					ssafyNara[loc] += 1;
					continue;
				}
				// 1이 아니면 일단 해당 위치에 강도 더해주고
				// 인접 위치 여진 계산해줄 예정
				else {
					ssafyNara[loc] += pow;
				}
				// 인접 위치 여진 계산용 int[] d 배열
				// (예) pow == 4
				// d = {3, 2, 1}
				int[] d = new int[pow - 1];
				for (int i = 0; i < d.length; i++) {
					d[i] = pow - i - 1;
				}

				// 해당 위치 (loc)으로부터 양의 위치에 인접 여진을 더해줌
				// 배열 범위를 벗어나면 break
				for (int i = 0; i < d.length; i++) {
					int locP = loc + i + 1;
					if (locP >= size) {
						break;
					}
					ssafyNara[locP] += d[i];
				}
				// 해당 위치 (loc)으로부터 음의 위치에 인접 여진을 더해줌
				// 배열 범위를 벗어나면 break
				for(int i=0; i<d.length; i++) {
					int locN = loc - i - 1;
					if (locN < 0) {
						break;
					}
					ssafyNara[locN] += d[i];

				}
			}
			// 싸피나라에 필요한 보강비용 총합 계산 및 출력
			for (int i=0; i<ssafyNara.length; i++) {
				sum += ssafyNara[i];
			}
			System.out.printf("#%d %d\n", test_case, sum);

		}
	}
}
