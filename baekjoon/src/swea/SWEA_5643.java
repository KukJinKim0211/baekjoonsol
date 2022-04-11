package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 키 순서
public class SWEA_5643 {
	static int MAX_VAL = 1000000;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(bf.readLine());
		for (int itest = 1; itest <= testcase; itest++) {
			int N = Integer.parseInt(bf.readLine());
			int M = Integer.parseInt(bf.readLine());
			int[][] iArray = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					iArray[i][j] = MAX_VAL;
				}
			}
			StringTokenizer st;
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
			
			sb.append("#" + itest + " " + iResult + "\n");
		}
		System.out.println(sb);
	}
}
