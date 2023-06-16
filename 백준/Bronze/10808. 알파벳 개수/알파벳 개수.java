
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str = sc.next().toCharArray();
		int[] countArr = new int[26];
		for (int i = 0; i < str.length; i++) {
			countArr[str[i] - 97]++;
		}
		for (int i = 0; i < countArr.length; i++) {
			System.out.print(countArr[i] + " ");
		}
	}
}
