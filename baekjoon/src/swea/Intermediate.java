package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Intermediate {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int itestcase = Integer.parseInt(bf.readLine());
		String str = null;
		for (int itest = 1; itest <= itestcase; itest++) {
			int iLength = Integer.parseInt(bf.readLine());
			char cArray[][] = new char[iLength][iLength];
			
			for (int i = 0; i < iLength; i++) {
				cArray[i] = bf.readLine().toCharArray();
			}
			
			for (int i = 0; i < iLength; i++) {
				for (int j = 0; j < iLength; j++) {
					if (cArray[i][j] == 'A') {
						if (i - 1 >= 0) 
							cArray[i - 1][j] = 'X';
						if (j + 1 < iLength) 
							cArray[i][j + 1] = 'X';
						if (i + 1 < iLength)
							cArray[i + 1][j] = 'X';
						if (j - 1 >= 0)
							cArray[i][j - 1] = 'X';
					}
					else if (cArray[i][j] == 'B') {
						if (i - 1 >= 0) {
							cArray[i - 1][j] = 'X';
							if (i - 2 >= 0) 
								cArray[i - 2][j] = 'X';
						}
						if (j + 1 < iLength) {
							cArray[i][j + 1] = 'X';
							if (j + 2 < iLength) 
								cArray[i][j + 2] = 'X';
						}
						if (i + 1 < iLength) {
							cArray[i + 1][j] = 'X';
							if (i + 2 < iLength)
								cArray[i + 2][j] = 'X';
						}
						if (j - 1 >= 0) {
							cArray[i][j - 1] = 'X';
							if (j - 2 >= 0)
								cArray[i][j - 2] = 'X';
						}
						
					}
					else if (cArray[i][j] == 'C') {
						if (i - 1 >= 0) {
							cArray[i - 1][j] = 'X';
							if (i - 2 >= 0) {
								cArray[i - 2][j] = 'X';
								if (i - 3 >= 0) 
									cArray[i - 3][j] = 'X';
							}
						}
						if (j + 1 < iLength) {
							cArray[i][j + 1] = 'X';
							if (j + 2 < iLength) {
								cArray[i][j + 2] = 'X';
								if (j + 3 < iLength)
									cArray[i][j + 3] = 'X';
							}
						}
						if (i + 1 < iLength) {
							cArray[i + 1][j] = 'X';
							if (i + 2 < iLength) {
								cArray[i + 2][j] = 'X';
								if (i + 3 < iLength)
									cArray[i + 3][j] = 'X';
							}
						}
						if (j - 1 >= 0) {
							cArray[i][j - 1] = 'X';
							if (j - 2 >= 0) {
								cArray[i][j - 2] = 'X';
								if (j - 3 >= 0) 
									cArray[i][j - 3] = 'X';
							}
						}
					}
				}
			}
			int iCount = 0;
			for (int i = 0; i < iLength; i++) {
				for (int j = 0; j < iLength; j++) {
					if (cArray[i][j] == 'H')
						iCount++;
				}
			}
			
			sb.append("#" + itest + " " + iCount + "\n");
		}
		System.out.println(sb);
	}
}
