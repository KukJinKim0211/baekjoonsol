package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이
public class BJ_2563 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iCount = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		
		int[][] iArray = new int[100][100];
		int iSum = 0;
		for (int itest = 1; itest <= iCount; itest++) {
			st = new StringTokenizer(bf.readLine());
			int iX = Integer.parseInt(st.nextToken()) - 1;
			int iY = Integer.parseInt(st.nextToken()) - 1;
			
			for (int i = iX; i < iX + 10; i++) {
				for (int j = iY; j < iY + 10; j++) {
					if (iArray[i][j] == 1)
						continue;
					else {
						iArray[i][j] = 1;
						iSum++;
					}
				}
			}
		}
		
		System.out.println(iSum);
	}
}
