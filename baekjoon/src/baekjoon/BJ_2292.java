package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2292 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iData = Integer.parseInt(bf.readLine());
		
		if (iData == 1) {
			System.out.println("1");
			return;
		}
		
		iData--;
		
		int iCnt = 1;
		while (iData > 0) {
			iData -= 6 * iCnt++;
			
		}
		
		System.out.println(iCnt);
	}
}
