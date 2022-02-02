package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_8437 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger iTotal = new BigInteger(bf.readLine());
		BigInteger ichai = new BigInteger(bf.readLine());
		BigInteger itwo = new BigInteger("2");
		
		BigInteger i1 = iTotal.add(ichai).divide(itwo);
		BigInteger i2 = iTotal.subtract(ichai).divide(itwo);
		
		System.out.println(i1);
		System.out.println(i2);
	}
}
