package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 슈퍼 마리오
public class BJ_2851 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iResult = 0;
		int icurrSum = 0;
		for (int i = 0; i < 10; i++) {
			int iValue = Integer.parseInt(bf.readLine());
			if(icurrSum < 100){
				icurrSum += iValue; 
				if(Math.abs(100 - iResult) > Math.abs(100 - icurrSum)) { 
					iResult = icurrSum; 
				} 
				else if(Math.abs(100 - iResult) == Math.abs(100 - icurrSum)) {
					iResult = iResult > icurrSum ? iResult : icurrSum; 
				}
			}
		}
		System.out.println(iResult);
	}
}
