package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직사각형 네개의 합집합의 면적 구하기
public class BJ_2669 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] iArray = new int[100][100];
		int iCount = 0;
		
		for (int itest = 0; itest < 4; itest++) {
			st = new StringTokenizer(bf.readLine());
			
			int[] iX = new int[2];
			int[] iY = new int[2];
			
			iX[0] = Integer.parseInt(st.nextToken());
			iY[0] = Integer.parseInt(st.nextToken());
			iX[1] = Integer.parseInt(st.nextToken());
			iY[1] = Integer.parseInt(st.nextToken());
			
			for (int i = iX[0] - 1; i < iX[1] - 1; i++) {
				for (int j = iY[0] - 1; j < iY[1] - 1; j++) {
					if (iArray[i][j] == 0) {
						iArray[i][j] = 1;
						iCount++;
					}
				}
			}
		}
		System.out.println(iCount);
	}
}
