
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[] nums = new int[N];
		for (int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		for (int num: nums) {
			if (num<X) {
				System.out.print(num+" ");
			}
		}
		
	}
}
