
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int V;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		p = new int[V + 1];
		makeSet();
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a, b);
		}
		System.out.println(countSet());
	}

	public static void makeSet() {
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
	}

	public static int findSet(int x) {
		if (p[x] == x)
			return x;
		return p[x] = findSet(p[x]);
	}

	public static void union(int a, int b) {
		p[findSet(a)] = p[findSet(b)];
	}

	public static int countSet() {
		int answer = 0;
		int[] count = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			count[findSet(i)]++;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0)
				answer++;
		}
		return answer;
	}
}
