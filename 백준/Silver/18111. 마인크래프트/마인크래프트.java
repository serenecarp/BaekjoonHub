
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] ground;
	static int inven;

	static int maxH;
	static int minH;
	static int ansH = Integer.MIN_VALUE;
	static int ansT = Integer.MAX_VALUE;

	static int timeTaken;

	// 가장 낮은 층의 높이까지 모든 곳을 평탄화하고 시작
	// 이후 한 층씩 높여 가면서, 걸리는 시간이 최소인 곳을 찾을 예정
	// 걸리는 시간이 같을 경우 가장 높은 곳을 선택하도록 해줘야 함
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ground = new int[N][M];
		inven = Integer.parseInt(st.nextToken());

		maxH = Integer.MIN_VALUE;
		minH = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				if (maxH < ground[i][j]) {
					maxH = ground[i][j];
				}
				if (minH > ground[i][j]) {
					minH = ground[i][j];
				}
			}
		}

		flattenUp();

		System.out.printf("%d %d", ansT, ansH);

	}

	public static void flattenUp() {

		// recur
		timeTaken = time_digAsPossible();
//		System.out.println("다 팠을때, 기본 시간: " + timeTaken);
		// 가장 깊게 팠을 때부터, 아무것도 안 팔 경우까지 고려
		for (int curLayer = minH + 1; curLayer <= maxH; curLayer++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 본 땅이 더 높다면 괜히 판거니까 판거 복구: 총 시간 -2, inven -1
					if (curLayer <= ground[i][j]) {
						timeTaken -= 2;
						inven -= 1;
					}
					// 본 땅이 더 낮은 경우라면 이제 쌓아줘야 하니까: 총 시간 +1, inven -1
					else if (curLayer > ground[i][j]) {
						timeTaken += 1;
						inven -= 1;
					}

					if (inven == -1) {
						// 인벤 다썼는데 땅이 필요하면 이제부터 층은 고려할 필요 없음, 종료
						return;
					}

				}
			}
//			System.out.println("소요시간: " + timeTaken + ", 현재 층: " + curLayer + ", 최소시간: " + ansT + "\n");
			if (ansT >= timeTaken) {
				ansT = timeTaken;
				ansH = curLayer;
			}
		}
	}

	// 가장 낮은 층만큼 파냈을 때 걸리는 시간
	// 내 인벤토리에 들어있는 흙블록도 계산
	public static int time_digAsPossible() {
		int timeTaken = 0;
		int diggedBlocks = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				diggedBlocks += ground[i][j] - minH;
			}
		}
		//
		inven += diggedBlocks;
		timeTaken = 2 * diggedBlocks;
		ansH = minH;
		ansT = timeTaken;
		return timeTaken;
	}
}
