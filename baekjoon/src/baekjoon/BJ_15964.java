package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_15964 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		BigInteger i1 = new BigInteger(st.nextToken());
		BigInteger i2 = new BigInteger(st.nextToken());
		
		BigInteger i3 = i1.add(i2);
		BigInteger i4 = i1.subtract(i2);
		
		System.out.println(i3.multiply(i4));
	}
}
