
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hear = sc.nextInt();
		int see = sc.nextInt();
		HashSet<String> name = new HashSet<>();
		List<String> whoRU = new ArrayList<>();
		for (int i = 0; i < hear; i++) {
			name.add(sc.next());
		}
		for (int i = 0; i < see; i++) {
			String unknown = sc.next();
			if(name.contains(unknown)) {
				whoRU.add(unknown);
			}
				
		}
		Collections.sort(whoRU);
		System.out.println(whoRU.size());
		for(int i=0; i<whoRU.size(); i++) {
			System.out.println(whoRU.get(i));
		}
	}
}
