
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		// scanner 런타임에러뜸
		Scanner sc = new Scanner(System.in);
		System.out.println(recursion(sc.nextInt()));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println(recursion(Integer.parseInt((br.readLine()))));
	}

	// 재귀함수
	public static int recursion(int N) {
		if (N == 0) {
			return 1;
		}

		return N * recursion(N - 1);
	}
}
