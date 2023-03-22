import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int answer = 0;
       
        if(year % 4 == 0){
            answer =1;
        }
        if(year % 100 == 0){
            answer = 0;
        }
         if(year%400 == 0){
           answer = 1;
        }
        System.out.println(answer);
    }
}