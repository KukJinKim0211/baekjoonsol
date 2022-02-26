package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 부분합
public class BJ_1806 {
	static int N, S;	// N:수열의 갯수  S:부분합
	static int[] iArray;	// 수열
	static int Count = Integer.MAX_VALUE;
	static boolean bFind;
	static boolean[] bVisit;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		bVisit = new boolean[N];
		st = new StringTokenizer(bf.readLine());
		iArray = new int[N];
		for (int i = 0; i < N; i++) {
			iArray[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(iArray);
		dfs(N - 1, 0, 0);
		System.out.println(Count);
	}
	
	static void dfs(int idx, int iSum, int icount) {
		if (iSum == S) {
			Count = Math.min(Count, icount);
			return;
		}
		if (iSum > S)
			return;
		
		for (int i = idx; i > -1; i--) {
			if (!bVisit[i]) {
				bVisit[i] = true;
				dfs(i - 1, iSum + iArray[i], icount + 1);
				bVisit[i] = false;
				dfs(i - 1, iSum, icount + 1);
			}
		}
		
	}
}
