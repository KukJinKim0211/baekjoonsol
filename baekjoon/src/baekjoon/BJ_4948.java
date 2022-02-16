package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 베르트랑 공준
public class BJ_4948 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		StringBuilder sb = new StringBuilder();
		
		while (!(str = bf.readLine()).equals("0")) {
			int iCount = 0;
			int iNum = Integer.parseInt(str);
			
			for (int i = iNum + 1; i <= iNum * 2; i++) {
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						iCount++;
						break;
					}
				}
				
			}
			
			sb.append(iNum - iCount + "\n");
		}
		System.out.println(sb);
	}
}
