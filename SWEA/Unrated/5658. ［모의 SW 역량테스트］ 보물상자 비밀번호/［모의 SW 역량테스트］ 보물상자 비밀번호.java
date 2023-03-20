
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트케이스
		for (int testCase = 1; testCase <= T; testCase++) {
			// 입력받을 숫자 개수 N, 몇 번째 숫자 가져올지 K
			int N = sc.nextInt();
			int K = sc.nextInt();

			// 문자로 입력받기
			char[] arr = new char[N];
			arr = sc.next().toCharArray();

			// TreeSet<>(Comparator.reverseOrder())
			// 중복을 허용하지 않고 내림차순으로 정렬
			Set<Integer> password = new TreeSet<>(Comparator.reverseOrder());

			// 예를 들어 N=12이면
			// [0]부터 3글자 / [1]부터 3글자 / [2]부터 3글자 검사하도록 해주는 변수
			for (int n = 0; n < N / 4; n++) {
				// n으로 세팅됐을 때 나올 수 있는 N/4개의 비밀번호들
				for (int j = 0; j < N; j += N / 4) {
					int num = 0;
					int realNum = 0;
					// 각 자릿수를 16진수로 더해주는 과정
					for (int i = 0; i < N / 4; i++) {
						int index = (n + i + j) % N;
						// 'A'부터는 7을 더 빼줘야 내가 원하는 16진수 'A'==10을 얻을 수 있다.
						num = (arr[index] - '0') >= 17 ? (arr[index] - '0' - 7) : (arr[index] - '0');
						// 해당 자릿수에 맞게 16의 제곱수를 곱해준다.
						realNum += (int) (num * Math.pow(16, N / 4 - i - 1));
					}
					password.add(realNum);
				}
			}
			int answer = 0;
//			System.out.println(password);
			// TreeSet에서 원하는 원소를 찾기 위해 iterator 사용, K번 next()
			Iterator<Integer> itr = password.iterator();
			for (int i = 0; i < K; i++) {
				answer = itr.next();
			}
			System.out.printf("#%d %d\n", testCase, answer);
		}
	}
}
