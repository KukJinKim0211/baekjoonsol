package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15964 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		BigInteger i1 = new BigInteger(st.nextToken());
		BigInteger i2 = new BigInteger(st.nextToken());
		
		System.out.println((i1 + i2) * (i1 - i2));
	}
}
