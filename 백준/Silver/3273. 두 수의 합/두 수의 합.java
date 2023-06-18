
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nums = Integer.parseInt(br.readLine());
		String seriesRaw = br.readLine();
		StringTokenizer st = new StringTokenizer(seriesRaw);
		int x = Integer.parseInt(br.readLine());
		int[] number = new int[nums];
		for (int i = 0; i < nums; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;

		for (int i = 0; i < nums - 1; i++) {
			int base = number[i];
			int tmp = x - base;
			if(base > x) continue;
			for (int j = i + 1; j < nums; j++) {
				if(number[j] != tmp) continue;
				answer++;
			}
		}
		System.out.println(answer);
	}
}
