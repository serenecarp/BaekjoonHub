import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        long val = A*B*C;
        int[] digit = new int[10];
        while(val!=0){
            digit[(int)val%10]++;
            val/=10;
        }
        for(int i=0; i<10; i++){
            System.out.println(digit[i]);
        }

	}
}
