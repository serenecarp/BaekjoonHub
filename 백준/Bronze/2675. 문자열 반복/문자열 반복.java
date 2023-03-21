
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());

			String[] str = st.nextToken().split("");
			for (int i = 0; i < str.length; i++) {
				for (int r = 0; r < R; r++) {
					System.out.print(str[i]);
				}
			}
			System.out.println();
		}
	}
}
