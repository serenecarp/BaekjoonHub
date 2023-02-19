
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] mn = { sc.next().toCharArray(), sc.next().toCharArray() };
		int m = 0;
		int n = 1;
		int k = n;
		for (int i = 2; i >= 0; i--) {
			if (mn[m][i] > mn[n][i]) {
				k = m;
				break;
			} else if (mn[m][i] < mn[n][i]) {
				k = n;
				break;
			} else continue;
		}
		for (int i = 2; i >= 0; i--) {
			System.out.print(mn[k][i]);
		}
	}
}
