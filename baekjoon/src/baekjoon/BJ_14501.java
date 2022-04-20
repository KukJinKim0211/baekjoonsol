package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사
public class BJ_14501 {
	static int N;			// 일하는 일 수
	static int[][] iArray;	// 날짜별 일 배열 
	static int MaxValue = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		iArray = new int[N + 1][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			iArray[i + 1][0] = Integer.parseInt(st.nextToken());
			iArray[i + 1][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, 0, false);
		System.out.println(MaxValue);
	}
	
	static void dfs(int count, int value, boolean flag) {
		if (flag) {
			MaxValue = Math.max(MaxValue, value);
			return;
		}
		for (int i = count; i <= N; i++) {
			int inext = iArray[i][0];
			if (i + inext > N)
				if (i + inext == N + 1)
					dfs(i + inext, value + iArray[i][1], true);
				else
					dfs(i + inext, value, true);
			else
				dfs(i + inext, value + iArray[i][1], false);
		}
	}
}
