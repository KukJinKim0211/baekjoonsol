package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_6749 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iYoung = Integer.parseInt(bf.readLine());
		int iMiddle = Integer.parseInt(bf.readLine());
		
		System.out.println(iMiddle + (iMiddle - iYoung));
	}
}
