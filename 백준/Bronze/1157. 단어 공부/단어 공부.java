
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int[] freq = new int[26];

		for (int i = 0; i < word.length(); i++) {
			
			int idx = word.charAt(i)-'A';
			if (idx >= 32) {
				idx -= 32;
			}
			freq[idx]++;

		}
		
		char answer = '0';
		int maxFrq = 0;
		for (int i = 0; i < freq.length; i++) {
			if(maxFrq < freq[i]) {
				maxFrq = freq[i];
				answer = (char)(i+'A');
			} else if (maxFrq == freq[i]) {
				answer = '?';
			}
		}
		System.out.println(answer);
	}
}
