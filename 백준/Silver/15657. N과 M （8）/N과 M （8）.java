
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, visited;

	static int[] arr, arrAns;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		arrAns = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		selectNum(0);
	}

	static void selectNum(int select) {
		if (select == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arrAns[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {

			if (select > 0 && arrAns[select - 1] > arr[i])
				continue;
			arrAns[select] = arr[i];
			selectNum(select + 1);
		}
	}
}
