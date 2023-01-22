
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arr[] = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
        sc.close();
        
        
        for(int i=0; i<arr.length-1; i++) {
        	for(int j = i+1; j<arr.length; j++) {
        		if(arr[j] < arr[i]) {
        			
        			int tmp = arr[i];
                	arr[i] = arr[j];
                	arr[j] = tmp;
        		}
        		
        		
        	}
        	

        	
        }
        System.out.println(arr[1]);

        
        
    }
}