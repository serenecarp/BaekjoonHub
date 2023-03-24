package prob001181;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, TreeSet> wordByLen = new HashMap<>();

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String word = sc.next();
			if (!wordByLen.containsKey(word.length())) {
				TreeSet<String> words = new TreeSet<>();
				words.add(word);
				wordByLen.put(word.length(), words);
			} else {
				wordByLen.get(word.length()).add(word);
			}
		}

		Map<Integer, TreeSet> sortedWordByLen = new TreeMap<>(wordByLen);

		for (Integer key : sortedWordByLen.keySet()) {
			for (Object str : sortedWordByLen.get(key)) {
				System.out.println((String) str);
			}

		}

	}
}
