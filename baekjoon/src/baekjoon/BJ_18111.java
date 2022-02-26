package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 마인크래프트
public class BJ_18111 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] iArray = new int[N][M];
		int iMin = Integer.MAX_VALUE;
		int iMax = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
				iMin = Math.min(iMin, iArray[i][j]);
				iMax = Math.max(iMax, iArray[i][j]);
			}
		}
		int iMinTime = Integer.MAX_VALUE;
		int iMinArea = 0;
		for (int k = iMin; k <= iMax; k++) { 
			int iTime = 0;		// 작업 시간
			int iArea = B;		// 블록갯수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (iArray[i][j] > k) {
						iTime += 2 * (iArray[i][j] - k);
						iArea += iArray[i][j] - k;
					}
					else if (iArray[i][j] < k) {
						iTime += k - iArray[i][j];
						iArea -= k - iArray[i][j];
					} else
						continue;
				}
			}
			if (iArea >= 0 && iMinTime >= iTime) {
				iMinTime = iTime;
				iMinArea = k;
			}
		}
		System.out.println(iMinTime + " " + iMinArea);
	}
}
