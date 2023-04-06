package prob017136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

// 이번에는 1칸종이, 2칸종이, 3칸종이, 4칸종이, 5칸종이의 개수를
// 각각 0~5장이 있다고 가정해서, 6의 5제곱가지의 경우를 모두 따져주고자 했다.
// 복잡도가 엄청나게 높아질 것을 우려하여 map에 n짜리 크기의 정사각형이 들어갈 가능성이 높은 후보를 따로 저장해두었다.
// 이후 종이의 개수에 따라 가장 큰 종이부터 채워 나가고자 했다.

// 근데 너무 복잡해져서 그냥 안하기로 했다.

public class Main_1 {
	static int[][] paperMain;
	static int[][] paperMainCopy;
	static HashMap<Integer, List<int[]>> possible;
	static int totOnes;

	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 정사각형이 될 가능성이 있는 좌표들을 모을 map 초기화
		possible = new HashMap<>();
		for (int size = 2; size <= 5; size++) {
			List<int[]> coords = new ArrayList<>();
			possible.put(size, coords);
		}
		// 1이 총 몇개인지 - 다 채웠는지 여부 판별용
		totOnes = 0;
		// 입력
		paperMain = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			int count = 0;
			for (int j = 0; j < 10; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				paperMain[i][j] = tmp;
				// 1이 연속으로 n개 나온 부분 => n*n 정사각형 들어갈 가능성 있는 부분
				if (tmp == 1) {
					totOnes++;
					count++;
					if (5 >= count && count >= 2 && j + count < 10) {
						int[] coord = { i, j };
						possible.get(count).add(coord);
					}
				} else {
					count = 0;
				}
			}
		}

		answer = -1;
		putPaper(0, 0, 0, 0, 0);
		System.out.println(answer);

	}

	static void putPaper(int p1, int p2, int p3, int p4, int p5) {
		if(p1 == 6 || p2 == 6 || p3 == 6 || p4 == 6 || p5 == 6) {
			return;
		}
		int[] paper = { p1, p2, p3, p4, p5 };
		System.out.println(Arrays.toString(paper));

		copyPaperMain();
		int totOnesNow = totOnes;

		for (int p = 4; p >= 0; p--) {
			// 이제 1개짜리만 넣으면 될 때
			if (p == 0) {
				if (totOnesNow == p1) {
					answer = p1 + p2 + p3 + p4 + p5;
					return;
				} else {
					break;
				}

			} else {
				int size = p + 1;
				totOnesNow -= checkSquare(size) * size * size;
			}

		}

		putPaper(p1 + 1, p2, p3, p4, p5);
		putPaper(p1, p2 + 1, p3, p4, p5);
		putPaper(p1, p2, p3 + 1, p4, p5);
		putPaper(p1, p2, p3, p4 + 1, p5);
		putPaper(p1, p2, p3, p4, p5 + 1);

	}

	static int checkSquare(int size) {
		if (possible.get(size).size() == 0) {
			return 0;
		}
		int count = 0;
		outLoop: while (!possible.get(size).isEmpty()) {
			int y = possible.get(size).get(0)[0];
			int x = possible.get(size).get(0)[1];
			possible.get(size).remove(0);

			for (int i = y + 1; i <= y + size; i++) {
				for (int j = x; j <= x + size; j++) {
					if (paperMainCopy[i][j] != 1) {
						continue outLoop;
					}
				}
			}
			coverPaper(size, y, x);
			count++;
		}
		return count;
	}

	static void coverPaper(int size, int y, int x) {

		for (int i = y; i <= y + size; i++) {
			for (int j = x; j <= x + size; j++) {
				paperMainCopy[i][j] = 0;
			}
		}
	}

	static void copyPaperMain() {
		paperMainCopy = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				paperMainCopy[i][j] = paperMain[i][j];
			}
		}
	}

}
