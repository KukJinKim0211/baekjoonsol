package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2558 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iNum1 = Integer.parseInt(bf.readLine());
		int iNum2 = Integer.parseInt(bf.readLine());
		
		System.out.println(iNum1 + iNum2);
	}
}
