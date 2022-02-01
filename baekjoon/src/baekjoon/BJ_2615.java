package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2615 {
	final static int iSize = 19;
	static int[][] iArray = new int[iSize][iSize];
	
	// 우상 조건 체크
	public static int toprightCheck(int x, int y) {
		// 오목조건체크
		for (int i = 1; i < 5; i++) {
			if (iArray[x][y] != iArray[x - i][y + i]) 
				return 0;
		}
		
		// 육목조건체크
		if (x - 5 >= 0 && y + 5 < iSize) {
			if (iArray[x][y] == iArray[x - 5][y + 5])
				return 0;
		}
		if (x + 1 < iSize && y - 1 >= 0) {
			if (iArray[x][y] == iArray[x + 1][y - 1])
				return 0;
		}
		return iArray[x][y];
	}
	
	// 우측 조건 체크
	public static int rightCheck(int x, int y) {
		// 오목조건체크
		for (int i = 1; i < 5; i++) {
			if (iArray[x][y] != iArray[x][y + i])
				return 0;
		}
		
		// 육목조건체크
		if (y + 5 < iSize) {
			if (iArray[x][y] == iArray[x][y + 5])
				return 0;
		}
		if (y - 1 >= 0) {
			if (iArray[x][y] == iArray[x][y - 1])
				return 0;
		}
		
		return iArray[x][y];
	}
	
	// 우측하단 조건 체크
	public static int bottomrightCheck(int x, int y) {
		// 오목조건체크
		for (int i = 1; i < 5; i++) {
			if (iArray[x][y] != iArray[x + i][y + i])
				return 0;
		}
		
		// 육목조건체크
		if (x + 5 < iSize && y + 5 < iSize) {
			if (iArray[x][y] == iArray[x + 5][y + 5])
				return 0;
		}
		if (x - 1 >= 0 && y - 1 >= 0) {
			if (iArray[x][y] == iArray[x - 1][y - 1])
				return 0;
		}
		
		return iArray[x][y];
	}
	
	// 하단 조건 체크
	public static int bottomCheck(int x, int y) {
		// 오목조건체크
		for (int i = 1; i < 5; i++) {
			if (iArray[x][y] != iArray[x + i][y])
				return 0;
		}
		
		// 육목조건체크
		if (x + 5 < iSize) {
			if (iArray[x][y] == iArray[x + 5][y])
				return 0;
		}
		if (x - 1 >= 0) {
			if (iArray[x][y] == iArray[x - 1][y])
				return 0;
		}
		
		return iArray[x][y];
	}
	
	public static void main (String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < iSize; i++) {
			st = new StringTokenizer(bf.readLine());
			
			for (int j = 0; j < iSize; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int iWin = 0;
		
		// 바둑판의 모든 점
		for (int i = 0; i < iSize; i++) {
			for (int j = 0; j < iSize; j++) {
				// 우상범위체크 
				if (i - 4 >= 0 && j + 4 < iSize) {
					iWin = toprightCheck(i, j);
					if (iWin != 0) {
						System.out.println(iWin);
						System.out.println((i + 1) + " " + (j + 1));
						return;
					}
				}
				
				// 우측범위체크
				if (j + 4 < iSize) {
					iWin = rightCheck(i, j);
					if (iWin != 0) {
						System.out.println(iWin);
						System.out.println((i + 1) + " " + (j + 1));
						return;
					}
				}
				
				// 우하범위체크
				if (i + 4 < iSize && j + 4 < iSize) {
					iWin = bottomrightCheck(i, j);
					if (iWin != 0) {
						System.out.println(iWin);
						System.out.println((i + 1) + " " + (j + 1));
						return;
					}
				}
				
				// 하단범위체크
				if (i + 4 < iSize) {
					iWin = bottomCheck(i, j);
					if (iWin != 0) {
						System.out.println(iWin);
						System.out.println((i + 1) + " " + (j + 1));
						return;
					}
				}
			}
		}
		
		System.out.println(0);
	}
}
