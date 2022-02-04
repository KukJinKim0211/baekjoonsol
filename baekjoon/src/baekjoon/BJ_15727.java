package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BJ_15727 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iLength = Integer.parseInt(bf.readLine());
		
		System.out.println((iLength / 5) + (iLength % 5 == 0 ? 0 : 1));
	}
}
