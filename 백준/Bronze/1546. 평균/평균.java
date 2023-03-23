import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        double N = sc.nextInt();
        double maxVal = Integer.MIN_VALUE;
        double scoreSum = 0;
        for(int i=0; i<N; i++){
            double score = sc.nextInt();
            scoreSum += score;
            if(maxVal < score){
                maxVal = score;
            }
        }
        System.out.println((scoreSum*100/maxVal)/N);
	}
}
