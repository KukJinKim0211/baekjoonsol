package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열
public class BJ_2559 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int iSize = Integer.parseInt(st.nextToken());
		int iCount = Integer.parseInt(st.nextToken());
		int[] iArray = new int[iSize];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < iSize; i++) {
			iArray[i] = Integer.parseInt(st.nextToken());
		}
		int iMax = Integer.MIN_VALUE;
		for (int i = 0; i <= iSize - iCount; i++) {
			int iSum = 0;
			for (int j = i; j < i + iCount; j++) {
				iSum += iArray[j];
			}
			iMax = Math.max(iMax, iSum);
		}
		System.out.println(iMax);
	}
}
