package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 세금
public class BJ_20492 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iMoney = Integer.parseInt(bf.readLine());
		System.out.print((int)(iMoney * 0.78) + " ");
		System.out.print((int)(iMoney * 0.2 * 0.78) + (int)(iMoney * 0.8));
	}
	
}
