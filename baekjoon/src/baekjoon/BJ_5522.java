package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5522 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iResult = 0;
		for (int i = 0; i < 5; i++) {
			iResult += Integer.parseInt(bf.readLine());
		}
		
		System.out.println(iResult);
	}
}
