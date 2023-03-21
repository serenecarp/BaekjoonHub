
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "ascending";
		int note = sc.nextInt();
		int tmp = note;
		for (int i = 1; i < 8; i++) {
			note = sc.nextInt();
			
			if (tmp + 1 == note) {
				
			} else if (tmp - 1 == note) {
				str = "descending";
				
			} else {
				str = "mixed";
				break;
			}
			tmp = note;
		}
		System.out.println(str);
	}
}
