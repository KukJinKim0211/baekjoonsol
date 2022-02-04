package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(bf.readLine());
		int isize;
		
		char[][] cArray;
		
		String str;
		
		for (int test = 1; test <= testcase; test++) {
			isize = Integer.parseInt(bf.readLine());
			cArray = new char[isize][isize];
			for (int i = 0; i < isize; i++) {
				str = bf.readLine();
				for (int j = 0; j < isize; j++) {
					cArray[i][j] = str.charAt(j);
				}
			}
		
			int iResult = 0;

			for (int i = 0; i < isize; i++) {
				// 마름모 처음부터 마름모 중심까지
				if (i <= isize / 2) {
					for (int j = (isize / 2) - i; j <= (isize / 2) + i; j++) {
						iResult += cArray[i][j] - '0';
					}
				}
				// 마름모 중심+1부터 마름모 끝까지
				else {
					for (int j = i - (isize / 2); j <= (isize / 2) * 3  - i; j++) {
						iResult += cArray[i][j] - '0';
					}
				}
			}
			
			System.out.println("#" + test + " " + iResult);
		}
	}
}
