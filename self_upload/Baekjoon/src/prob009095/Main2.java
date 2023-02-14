package prob009095;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-- > 0) {
			System.out.println(recursive(sc.nextInt()));
		}
	}
	
	public static int recursive(int n) {
		switch(n) {
		case 1: return 1;
		case 2: return 2;
		case 3: return 4;
		default: return recursive(n-1)+recursive(n-2)+recursive(n-3);
		}
	}
}

