package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_14928 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger i1 = new BigInteger(bf.readLine());
		
		System.out.println(i1 / 20000303);
	}
}
