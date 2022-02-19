package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나무 자르기
public class BJ_2805 {	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int iSize = Integer.parseInt(st.nextToken());
		int iNeed = Integer.parseInt(st.nextToken());
		int[] iArray = new int[iSize];
		st = new StringTokenizer(bf.readLine());
		int iMax = 0;
		for (int i = 0; i < iSize; i++) {
			iArray[i] = Integer.parseInt(st.nextToken());
			iMax = Math.max(iMax, iArray[i]);
		}
		Arrays.sort(iArray);
		int iHeight = iArray[iSize - 1] - iNeed;
		while (true) {
			int iSum = 0;
			for (int i = iSize -1; i >= 0; i--) {
				if (iArray[i] - iHeight > 0)
					iSum += iArray[i] - iHeight;
				else
					break;
			}
			if (iSum <= iNeed) {
				System.out.println(iHeight);
				return;
			}
			iHeight++;
		}
	}
}
