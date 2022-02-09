package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// N과 M(1)
public class BJ_15649 {
	static int iMaxCount;
	static int iCnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String str = bf.readLine();
		
		iMaxCount = Integer.parseInt(str.split(" ")[0]);
		iCnt = Integer.parseInt(str.split(" ")[1]);
		
		int[] iArray = new int[iCnt];
		boolean[] bSelected = new boolean[iMaxCount];
		
		recall(0, bSelected, iArray);
		
		System.out.println(sb);
	}
	
	// [입력값] iMaxCount:수열의 길이 iNum:수열의마지막값  iCount:수열의 카운트
	public static void recall(int iCount, boolean[] bSelected, int[] iArray) {
		if (iCount == iCnt) {
			for (int i = 0; i < iArray.length; i++) {
				sb.append(iArray[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < iMaxCount; i++) {
			if (bSelected[i] == false) {
				bSelected[i] = true;
				iArray[iCount] = i + 1;
				recall(iCount + 1, bSelected, iArray);
				bSelected[i] = false;
			}
		}
	}
}
