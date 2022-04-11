package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 키 순서
public class BJ_2458 {
	static int MAX_VAL = 1000000;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] iArray = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				iArray[i][j] = MAX_VAL;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			iArray[a][b] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (iArray[i][j] >= iArray[i][k] + iArray[k][j])
						iArray[i][j] = iArray[i][k] + iArray[k][j];
				}
			}
		}
		
		int iResult = 0;
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (iArray[i][j] != MAX_VAL || iArray[j][i] != MAX_VAL) cnt++;
			}
			if (cnt == N - 1) iResult++;
		}
		System.out.println(iResult);
	}
}
