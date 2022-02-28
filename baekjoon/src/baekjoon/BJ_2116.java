package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2116 {
	static int N;
	static int Max = Integer.MIN_VALUE;
	static int[][] iArray;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		iArray = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 6; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		diceBuild(0);
		System.out.println(Max);
	}
	
	static void diceBuild(int idx) {
		if (idx == 6)
			return;
		
		int[] iarr = new int[2];
		int iSum = 0;
		int iDiceDownValue = iArray[0][idx];
		
		for (int i = 0; i < N; i++) {
			iarr = diceValueFind(i, iDiceDownValue, iSum);
			iDiceDownValue = iarr[0];
			iSum = iarr[1];
		}
		Max = Math.max(iarr[1], Max);
		diceBuild(idx + 1);
	}
	
	static int[] diceValueFind(int idx, int diceDownValue, int iSum) {	// 주사위가 몇번째인지, 주사위의 아랫값이되어야할 값
		int diceIndex = 0;
		for (int i = 0; i < 6; i++) {
			if (iArray[idx][i] == diceDownValue)
				diceIndex = i;
		}
		int diceUpValue = 0;
		switch (diceIndex) {
		case 0: diceUpValue = iArray[idx][5]; break;
		case 1: diceUpValue = iArray[idx][3]; break;
		case 2: diceUpValue = iArray[idx][4]; break;
		case 3: diceUpValue = iArray[idx][1]; break;
		case 4: diceUpValue = iArray[idx][2]; break;
		case 5: diceUpValue = iArray[idx][0]; break;
		}
		
		int maxValue = 0;
		for (int i = 0; i < 6; i++) {
			if (iArray[idx][i] != diceDownValue && iArray[idx][i] != diceUpValue) 
				maxValue = Math.max(maxValue, iArray[idx][i]);
		}
		
		return new int[] { diceUpValue, iSum + maxValue };
	}
}
