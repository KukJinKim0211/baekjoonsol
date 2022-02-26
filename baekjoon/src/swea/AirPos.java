package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 항공기지 건설
public class AirPos {
	static int N, K, Min, Max, SquareMax;
	static int[][] iArray;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int itestcase = Integer.parseInt(bf.readLine());
		for (int itest = 1; itest <= itestcase; itest++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			iArray = new int[N][N];
			Min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					iArray[i][j] = Integer.parseInt(st.nextToken());
					Min = Math.min(Min, iArray[i][j]);
					Max = Math.max(Max, iArray[i][j]);
				}
			}
			findSquare(Min, Min + K);
			sb.append(SquareMax + "\n");
		}
		System.out.println(sb);
	}
	
	static void findSquare(int iStart, int iEnd) {
		if (iEnd >  Max)
			return;
		
		int[][] iArr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (iArray[i][j] >= iStart && iArray[i][j] <= iEnd) {	// 고도 제한 범위에 속해 있는 경우
					iArr[i][j] = 1;
				}
			}
		}
		int iXCnt = 0;
		int iYCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				iXCnt = 0;
				iYCnt = 0;
				if (iArr[i][j] == 1) {
					for (int k = i; k < N; k++) {
						if (iArr[k][j] == 1)
							iXCnt++;
						else
							break;
					}
					
					for (int k = j; k < N; k++) {
						if (iArr[i][k] == 1)
							iYCnt++;
						else
							break;
					}
					
					SquareMax = Math.max(SquareMax, iXCnt * iYCnt);
				}
			}
		}
		
		findSquare(iStart + 1, iEnd + 1);
		
	}
}
