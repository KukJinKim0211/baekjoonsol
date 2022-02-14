package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백설공주와 일곱난쟁이
public class BJ_3040 {
	static int[] ihobit = new int[7];
	static int[] iArray;
	static boolean[] bVisit;
	static boolean bComplete = false;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		iArray = new int[9];
		for (int i = 0; i < 9; i++) {
			iArray[i] = Integer.parseInt(bf.readLine());
		}
		
		//Arrays.sort(iArray);
		
		bVisit = new boolean[9];
		findhobit(0, 0);
	}
	
	static void findhobit(int iIndex, int iCount) {
		if (iCount == 7) {
			int iSum = 0;
			for (int i = 0; i < 7; i++) {
				iSum += ihobit[i];
			}
			if (iSum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(ihobit[i]);
				}
				bComplete = true;
			}
			return;
		}
		
		for (int i = iIndex; i < 9; i++) {
			if (bComplete)
				return;
			if (bVisit[i] == false) {
				ihobit[iCount] = iArray[i];
				bVisit[i] = true;
				findhobit(iIndex + 1, iCount + 1);
				bVisit[i] = false;
			}
		}
		
	}
}
