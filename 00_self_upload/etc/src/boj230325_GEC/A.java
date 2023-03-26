package boj230325_GEC;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String school = sc.next();
		String answer = "";
		switch(school) {
		case "NLCS":
			answer = "North London Collegiate School";
			break;
		case "BHA":
			answer = "Branksome Hall Asia";
			break;
		case "KIS":
			answer = "Korea International School";
			break;
		case "SJA":
			answer = "St. Johnsbury Academy";
			break;
		}
		System.out.println(answer);
	}
}
