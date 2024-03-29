package prob011650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		/////////// 2안
		HashMap<Integer, List<Integer>> dot = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int tmp = Integer.parseInt(st.nextToken());
			if (!dot.containsKey(x)) {
				List<Integer> y = new ArrayList<>();
				y.add(tmp);
				dot.put(x, y);
			} else {
				dot.get(x).add(tmp);
			}
		}

		List<Integer> dotX = new ArrayList<>(dot.keySet());
		Collections.sort(dotX);
		for (int i = 0; i < dotX.size(); i++) {
			Collections.sort(dot.get(dotX.get(i)));
			for (int j = 0; j < dot.get(dotX.get(i)).size(); j++) {
				System.out.printf("%d %d\n", dotX.get(i), dot.get(dotX.get(i)).get(j));
			}
		}

		/////////// 1안
//		int[][] dot = new int[N][2];
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < 2; j++) {
//				dot[i][j] = sc.nextInt();
//			}
//		}
//		for (int i = 0; i < N - 1; i++) {
//			for (int j = i + 1; j < N; j++) {
//				if (dot[i][0] > dot[j][0]) {
//					swap(dot, i, j);
//				} else if (dot[i][0] == dot[j][0] && dot[i][1] > dot[j][1]) {
//					swap(dot, i, j);
//				}
//			}
//		}
//		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.printf("%d ", dot[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	public static void swap(int[][] dot, int a, int b) {
//		int[] temp = dot[a];
//		dot[a] = dot[b];
//		dot[b] = temp;
//	}
	}
}
