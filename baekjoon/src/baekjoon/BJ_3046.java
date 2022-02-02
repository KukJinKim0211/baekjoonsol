package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3046 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int iR1 = Integer.parseInt(st.nextToken());
		int iAvg = Integer.parseInt(st.nextToken());
		
		System.out.println(iAvg * 2 - iR1);
	}
}
