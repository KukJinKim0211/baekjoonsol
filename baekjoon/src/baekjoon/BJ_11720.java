package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11720 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iCount = Integer.parseInt(bf.readLine());
		int iResult = 0;
		String str = bf.readLine();
		for (int i = 0; i < iCount; i++) {
			iResult += str.charAt(i) - '0';
		}
		
		System.out.println(iResult);
	}
}
