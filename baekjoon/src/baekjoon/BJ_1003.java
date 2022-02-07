package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1003 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int itestcase = Integer.parseInt(bf.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int[][] iArray = new int[41][2];
		
		iArray[0] = new int[] {1, 0};
		iArray[1] = new int[] {0, 1};
		
		
		for (int i = 2; i <= 40; i++) {
			iArray[i][0] = iArray[i - 1][0] + iArray[i - 2][0];
			iArray[i][1] = iArray[i - 1][1] + iArray[i - 2][1];
		}
		
		for (int itest = 1; itest <= itestcase; itest++) {
			int inum = Integer.parseInt(bf.readLine());
			
			sb.append(iArray[inum][0] + " " + iArray[inum][1] + "\n");
		}
		System.out.println(sb);
	}
}
