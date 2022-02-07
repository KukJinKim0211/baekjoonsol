package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 모든 순열
public class BJ_10974 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iNum = Integer.parseInt(bf.readLine());
		int[] iArray = new int[iNum];
		int[] inumbers = new int[iNum];
		for (int i = 1; i <= iNum; i++) {
			iArray[i - 1] = i;
		}
		boolean[] isSelected = new boolean[iNum];
		
		soon(0, iNum, iArray, inumbers, isSelected);
		
		System.out.println(sb);
	}
	
	public static void soon(int iCount, int iNum, int[] iArray, int[] inumbers, boolean[] isSelected) {
		if (iCount == iNum) {
			for (int i = 0; i < inumbers.length; i++) {
				sb.append(inumbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < iNum; i++) {
			if (isSelected[i] == true)
				continue;
			inumbers[iCount] = iArray[i];
			isSelected[i] = true;
			soon(iCount + 1, iNum, iArray, inumbers, isSelected);
			isSelected[i] = false;
		}
	}
}
