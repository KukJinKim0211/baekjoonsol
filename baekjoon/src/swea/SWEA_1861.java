package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정사각형 방
public class SWEA_1861 {
	static int[][] iArray;
	static boolean[][] bVisit;
	static int MaxCount;
	static int FirstValue;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int itestcase = Integer.parseInt(bf.readLine());
		
		for (int itest = 1; itest <= itestcase; itest++) {
			N = Integer.parseInt(bf.readLine());
			iArray = new int[N][N];
			bVisit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					iArray[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bVisit[i][j] = true;
					fourCheck(i, j, iArray[i][j], 1, iArray[i][j]);
					bVisit[i][j] = false;
				}
			}
			sb.append("#" + itest + " " + FirstValue + " " + MaxCount + "\n");
		}
		System.out.println(sb);
	}
	
	public static void fourCheck(int iX, int iY, int Value, int Count, int iFirstValue) {
		// 윗방향
		if (iX - 1 >= 0) {
			if (iArray[iX - 1][iY] == Value + 1 && bVisit[iX - 1][iY] == false) {
				bVisit[iX - 1][iY] = true;
				fourCheck(iX - 1, iY, Value + 1, Count + 1, iFirstValue);
				bVisit[iX - 1][iY] = false;
			}
			
		}
		// 아랫방향
		if (iX + 1 < N) {
			if (iArray[iX + 1][iY] == Value + 1 && bVisit[iX + 1][iY] == false) {
				bVisit[iX + 1][iY] = true;
				fourCheck(iX + 1, iY, Value + 1, Count + 1, iFirstValue);
				bVisit[iX + 1][iY] = false;
			}
		}
		// 왼쪽방향
		if (iY - 1 >= 0) {
			if (iArray[iX][iY - 1] == Value + 1 && bVisit[iX][iY - 1] == false) {
				bVisit[iX][iY - 1] = true;
				fourCheck(iX, iY - 1, Value + 1, Count + 1, iFirstValue);
				bVisit[iX][iY - 1] = false;
			}
		}
		// 오른쪽방향
		if (iY + 1 < N) {
			if (iArray[iX][iY + 1] == Value + 1  && bVisit[iX][iY + 1] == false) {
				bVisit[iX][iY + 1] = true;
				fourCheck(iX, iY + 1, Value + 1, Count + 1, iFirstValue);
				bVisit[iX][iY + 1] = false;
			}
		}
		
		if (Count > MaxCount)
		{
			MaxCount = Count;
			FirstValue = iFirstValue;
		}
	}
}
