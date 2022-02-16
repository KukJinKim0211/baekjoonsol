package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 종이 자르기
public class BJ_2628 {	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int itestcase = Integer.parseInt(bf.readLine());
		int[] iArray1 = new int[itestcase];
		int[] iArray2 = new int[itestcase];
		for (int i = 0; i < itestcase; i++) {
			st = new StringTokenizer(bf.readLine());
			int j = Integer.parseInt(st.nextToken());
			if (j == 0)
				iArray1[i] = Integer.parseInt(st.nextToken());
			else
				iArray2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(iArray1);
		Arrays.sort(iArray2);
		int iMaxX = 0;
		int iMaxY = 0;
		int iM = M;
		int iN = N;
		for (int i = itestcase - 1; i >= 0; i--) {
			if (i == 0) {
				iMaxX = Math.max(iMaxX, iArray1[i]);
				iMaxX = Math.max(iMaxX, iM - iArray1[i]);
				break;
			}
			iMaxX = Math.max(iMaxX, iM - iArray1[i]);
			iM = iArray1[i];
		}
		
		for (int i = itestcase - 1; i >= 0; i--) {
			if (i == 0) {
				iMaxY = Math.max(iMaxY, iArray2[i]);
				iMaxY = Math.max(iMaxY, iN - iArray2[i]);
			}
			iMaxY = Math.max(iMaxY, iN - iArray2[i]);
			iN = iArray2[i];
		}
		
		if (iMaxX == 0)
			iMaxX = M;
		if (iMaxY == 0)
			iMaxY = N;
		
		System.out.println(iMaxX * iMaxY);
	}
}
