
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		HashMap<String, Integer> enc = new HashMap<>();
		HashMap<Integer, String> encNo = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String pokemon = sc.next();
			enc.put(pokemon, i);
			encNo.put(i, pokemon);
		}
		int index = 1;
		for (int i = 0; i < M; i++) {
			String command = sc.next();
			if (Character.isDigit(command.charAt(0))) {
				System.out.println(encNo.get(Integer.parseInt(command)));
			} else {
				System.out.println(enc.get(command));
			}
		}
	}
}
