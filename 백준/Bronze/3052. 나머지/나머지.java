import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] remainder = new int[42];
        for(int i=0; i<10; i++){
            remainder[sc.nextInt()%42]++;
        }
        int count = 0;
        for(int i=0; i<42; i++){
            if(remainder[i] != 0){
                count++;
            }
        }
        System.out.println(count);
	}
}
