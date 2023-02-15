package prob002869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		float A = Integer.parseInt(st.nextToken());
//		float B = Integer.parseInt(st.nextToken());
//		float V = Integer.parseInt(st.nextToken());
//		// double타입의 수에는 미세한 오차가 존재하여, 큰 수로 연산을 하면 오차가 커진다.
//		System.out.println((int)Math.ceil((V-A)/(A-B))+1);
		
		BigDecimal A = new BigDecimal(st.nextToken());
		BigDecimal B = new BigDecimal(st.nextToken());
		BigDecimal V = new BigDecimal(st.nextToken());
		
		System.out.println((V.subtract(B).divide(A.subtract(B))).setScale(0, BigDecimal.ROUND_CEILING));
	}
}
