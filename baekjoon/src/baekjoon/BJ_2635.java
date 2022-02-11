package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 수 이어가기
public class BJ_2635 {
	static int MaxCount;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iNum = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i <= iNum; i++) {
			pibo(2, iNum, i, new StringBuilder(iNum + " " + i + " "));
		}
		
		System.out.println(MaxCount);
		System.out.println(sb);
	}
	
	public static void pibo (int iIndex, int iBefore, int iNext, StringBuilder stb) {
		if (iBefore - iNext < 0) {
			if (MaxCount < iIndex) {
				MaxCount = iIndex;
				sb = stb;
			}
			return;
		}
		
		pibo(iIndex + 1, iNext, iBefore - iNext, stb.append(iBefore - iNext + " "));
	}
}
