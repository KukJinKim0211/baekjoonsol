package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5554 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iSec = 0;
		
		for (int i = 0; i < 4; i++) {
			iSec += Integer.parseInt(bf.readLine());
		}
		
		System.out.println(iSec / 60);
		System.out.println(iSec % 60);
	}
}
