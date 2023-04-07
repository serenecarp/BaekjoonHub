
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int set = 0;
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x;
			String command = st.nextToken();
			switch (command) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				set = set | 1 << x;
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				set = set & ~(1 << x);
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				if ((set & (1 << x)) != 0)
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				set = set ^ (1 << x);
				break;
			case "all":
				set |= (~0);
				break;
			case "empty":
				set &= 0;
				break;
			}
		}
		System.out.println(sb);
	}
}
