package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 부녀회장이 될테야
public class BJ_2775 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] iArray = new int[15][15];
		
		for (int i = 0; i < 15; i++) {
			iArray[i][0] = 1;
			iArray[0][i] = i + 1;
		}
		
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				iArray[i][j] = iArray[i - 1][j] + iArray[i][j - 1];
			}
		}
		
		int itestcase = Integer.parseInt(bf.readLine());
		
		for (int itest = 1; itest <= itestcase; itest++) {
			int iRow = Integer.parseInt(bf.readLine());
			int iCol = Integer.parseInt(bf.readLine());
			
			System.out.println(iArray[iRow][iCol - 1]);
		}
	}
}
