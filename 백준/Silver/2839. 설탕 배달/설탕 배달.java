
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sugar = sc.nextInt();
		if(sugar%5 == 0) {
			System.out.println(sugar/5);
		} else if(sugar == 4 || sugar == 7) {
			System.out.println(-1);
		} else if((sugar-3)%5 == 0) {
			System.out.println((sugar-3)/5 + 1);
		} else if((sugar-6)%5 == 0) {
			System.out.println((sugar-6)/5 + 2);
		} else if((sugar-9)%5 == 0) {
			System.out.println((sugar-9)/5 + 3);
		} else if((sugar-12)%5 == 0) {
			System.out.println((sugar-12)/5 + 4);
		} else {
			System.out.println(-1);
		}
	}
}
