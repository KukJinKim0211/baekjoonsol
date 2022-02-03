package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_13277 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		
		BigInteger i1 = new BigInteger(st.nextToken());
		BigInteger i2 = new BigInteger(st.nextToken());
		
		System.out.println(i1.multiply(i2));
	}
}
