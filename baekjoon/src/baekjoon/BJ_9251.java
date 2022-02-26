package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// LCS
public class BJ_9251 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str1 = bf.readLine();
		String str2 = bf.readLine();
		int[][] iArray = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i < iArray.length; i++) {
			iArray[i][0] = 0;
		}
		for (int i = 0; i < iArray[0].length; i++) {
			iArray[0][i] = 0;
		}
		
		for (int i = 1; i < iArray.length; i++) {
			for (int j = 1; j < iArray[i].length; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					iArray[i][j] = iArray[i - 1][j - 1] + 1;
				else
					iArray[i][j] = Math.max(iArray[i - 1][j], iArray[i][j - 1]);
			}
		}
		System.out.println(iArray[str1.length()][str2.length()]);
	}
}
