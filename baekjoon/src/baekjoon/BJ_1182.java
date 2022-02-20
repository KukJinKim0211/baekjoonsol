package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분수열의 합
public class BJ_1182 {
	static int N, S;
	static int[] iArray;
	static int iCount;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		iArray = new int[N];
		for (int i = 0; i < N; i++) {
			iArray[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		if (S == 0)
			iCount--;
		System.out.println(iCount);
	}
	
	static void dfs(int idx, int iSum) {
		if (idx == N) {
			if (iSum == S) 
				iCount++;
			return;
		}
		
        dfs(idx + 1, iSum + iArray[idx]);
        dfs(idx + 1, iSum);
	}
}
