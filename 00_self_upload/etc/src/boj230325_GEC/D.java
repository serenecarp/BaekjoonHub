package boj230325_GEC;

import java.math.BigInteger;
import java.util.Scanner;

public class D {
	public static void main(String[] args) {
		BigInteger i = new BigInteger("0");
		BigInteger two = new BigInteger("2");
		BigInteger one = new BigInteger("1");
		BigInteger zero = new BigInteger("0");
		BigInteger six = new BigInteger("6");
		Scanner sc = new Scanner(System.in);
		BigInteger fount = new BigInteger(sc.next());
		BigInteger time = new BigInteger(sc.next());

		
		while (i.compareTo(time) == -1) {
			i = i.add(one);
			if (fount.remainder(two).compareTo(zero) == 0) {
				fount = fount.divide(two).xor(six);
			} else {
				fount = fount.multiply(two).xor(six);
			}
			
		}
		System.out.println(fount);
	}
}
