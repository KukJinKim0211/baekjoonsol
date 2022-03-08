package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 연속 구간
public class BJ_2495 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] sArray = new String[3];
		for (int i = 0; i < 3; i++) {
			sArray[i] = bf.readLine();
		}
		
		for (int i = 0; i < 3; i++) {
			int iMax = 0;
			int iCount = 1;
			int iValue = sArray[i].charAt(0);
			for (int j = 1; j < 8; j++) {
				if (sArray[i].charAt(j) == sArray[i].charAt(j - 1)) {
					if (iValue == sArray[i].charAt(j)) {
						iCount++;
					}
					else 
						iCount = 2;
					iValue = sArray[i].charAt(j);
				}
				else 
					iCount = 1;
				iMax = Math.max(iMax, iCount);
			}
			sb.append(iMax + "\n");
		}
		System.out.println(sb);
	}
}
