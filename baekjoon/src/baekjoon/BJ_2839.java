package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 설탕 배달
public class BJ_2839 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iNum = Integer.parseInt(bf.readLine());
		
		int ifive = iNum / 5;
		int ithree = 0;
		int iResult = -1;
		int i = 0;
		
		for (i = ifive; i >= 0; i--) {
			if (i == 0) {
				if (iNum % 3 == 0) 
					iResult = iNum / 3;
				break;
			}
			if ((iNum - (i * 5)) % 3 == 0) {
				iResult = (iNum - (i * 5)) / 3;
				break;
			}
		}
		
		System.out.println(iResult + i);
	}
}	
