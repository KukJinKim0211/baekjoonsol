package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 소수
public class BJ_2581 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iN = Integer.parseInt(bf.readLine());
		int iM = Integer.parseInt(bf.readLine());
		
		boolean bsosu = true;
		int iSum = 0;
		int iMin = 0;
		for (int i = iN; i <= iM; i++) {
			bsosu = true;
			if (i == 1)
				continue;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					bsosu = false;
					break;
				}
			}
			
			if (bsosu) {
				iSum += i;
				if (iMin == 0)
					iMin = i;
			}
		}
		
		if (iMin == 0)
			System.out.println(-1);
		else {
			System.out.println(iSum);
			System.out.println(iMin);
		}
	}
}
