
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
        int m = sc.nextInt();
        int time = (h*60 + m + 1440);
        int nh = ((time-45)/60)%24;
        int nm = (time-45)%60;
        System.out.println(nh + " " + nm);
	}
}
