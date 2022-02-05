package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 파리
public class SWEA_2001 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		
		for (int test = 1; test <= testcase; test++) {
			System.out.println("!");
			st = new StringTokenizer(bf.readLine());
			int iSize = Integer.parseInt(st.nextToken());
			int iPari = Integer.parseInt(st.nextToken());
			int iMax = 0;
			int iSum = 0;
			int[][] iArray = new int[iSize][iSize];
			for (int i = 0; i < iSize; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < iSize; j++) {
					iArray[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < iSize - iPari + 1; i++) {
				for (int j = 0; j < iSize - iPari + 1; j++) {
					iSum = 0;
					for (int k = 0; k < iPari; k++) {
						for (int r = 0; r < iPari; r++) {
							iSum += iArray[i + k][j + r];
							iMax = Math.max(iMax, iSum);
						}
					}
				}
			}
			
			System.out.println("#" + test + " " + iMax);
		}
	}
}
