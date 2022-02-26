package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 해밀턴 순환회로
public class JO_1681 {
	static int N, MinValue;
	static int[][] iArray;
	static boolean[] bVisit;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		iArray = new int[N][N];
		bVisit = new boolean[N];
		MinValue = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, 0);
		System.out.println(MinValue);
	}
	
	static void dfs(int iCurrent, int iCount, int iCost) {
		if (iCost >= MinValue)
			return;
		
		if(iCount==N-1) {
			if(iArray[iCurrent][0]==0) return;
			
			MinValue = Math.min(MinValue, iCost + iArray[iCurrent][0]);
		}
		
		bVisit[iCurrent] = true;
		for (int i = 0; i < N; i++) {
			if (bVisit[i] || iArray[iCurrent][i] == 0) continue;
			dfs(i, iCount + 1, iCost + iArray[iCurrent][i]);
		}
		bVisit[iCurrent] = false;
	}
}
