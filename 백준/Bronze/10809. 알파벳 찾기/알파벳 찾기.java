
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int[] alphabet = new int[26];
        for(int i=0; i<26; i++){
            alphabet[i] = -1;
        }
		String word = sc.next();
        for(int i= word.length()-1; i>=0; i--){
            alphabet[(int)word.charAt(i)-'a'] = i;
        }
        for(int i=0; i<26; i++){
            System.out.print(alphabet[i] + " ");
        }

	}
}
