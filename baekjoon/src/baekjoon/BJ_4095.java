package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대 정사각형
public class BJ_4095 {
	static int N, M;
	static int MaxValue;
	static int[][] iArray;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = null;
		while (!(str = bf.readLine()).equals("0 0")) {	
			StringTokenizer st = new StringTokenizer(str);
			MaxValue = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			boolean existone = false;
			iArray = new int[N + 1][M + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < M; j++) {
					iArray[i][j] = Integer.parseInt(st.nextToken());
					if (iArray[i][j] == 1) existone = true;
				}
			}
			
			MaxValue = existone == true ? 1: 0;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (iArray[i][j] == 0) continue;
					int min = Math.min(iArray[i - 1][j - 1], Math.min(iArray[i - 1][j], iArray[i][j - 1])) + 1;
					MaxValue = Math.max(MaxValue, min);
					iArray[i][j] = min;
				}
			}
			//MaxValue = MaxValue == 1 ? 0 : MaxValue;
			sb.append(MaxValue + "\n");
		}// while문 종료
		System.out.println(sb);
	}
}
