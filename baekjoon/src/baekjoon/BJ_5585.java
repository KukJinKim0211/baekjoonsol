package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 거스름돈
public class BJ_5585 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iValue = 1000 - Integer.parseInt(bf.readLine());
		
		int[] iArray = new int[] { 500, 100, 50, 10, 5 ,1 };
		int iCount = 0;
		for (int i = 0; i < iArray.length; i++) {
			iCount += iValue / iArray[i];
			iValue %= iArray[i];
		}
		
		System.out.println(iCount);
	}
}
