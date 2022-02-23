package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 적록색약
public class BJ_10026 {
	static int N;
	static char[][] cArray1;
	static char[][] cArray2;
	static int FirstArrayMin;
	static int SecondArrayMin;
	static boolean[][] bVisit;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		cArray1 = new char[N][N];
		cArray2 = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < N; j++) {
				char cData = str.charAt(j);
				cArray1[i][j] = cData;
				if (cArray1[i][j] == 'R')
					cArray2[i][j] = 'G';
				else
					cArray2[i][j] = cData;
			}
		}
		bVisit = new boolean[N][N];
		findArea(cArray1, 1);
		bVisit = new boolean[N][N];
		findArea(cArray2, 2);
		System.out.println(FirstArrayMin + " " + SecondArrayMin);
	}
	
	static void findArea(char[][] cArray, int flag) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cArray[i][j] == 'R' || cArray[i][j] == 'G' || cArray[i][j] == 'B') {
					bVisit[i][j] = true;
					AreaSet(i, j, cArray, flag);
					bVisit[i][j] = false;
					if (flag == 1)
						FirstArrayMin++;
					else
						SecondArrayMin++;
				}
			}
		}
	}
	
	static void AreaSet(int X, int Y, char[][] cArray, int flag) {
		char cData = cArray[X][Y];
		cArray[X][Y] = '0';
		if (X - 1 >= 0 && cArray[X - 1][Y] == cData && !bVisit[X - 1][Y]) {	// 위쪽 체크
			bVisit[X - 1][Y] = true;
			AreaSet(X - 1, Y, cArray, flag);
			bVisit[X - 1][Y] = true;
		}
		if (Y + 1 < N && cArray[X][Y + 1] == cData && !bVisit[X][Y + 1]) {	// 오른쪽 체크
			bVisit[X][Y + 1] = true;
			AreaSet(X, Y + 1, cArray, flag);
			bVisit[X][Y + 1] = false;
		}
		if (X + 1 < N && cArray[X + 1][Y] == cData && !bVisit[X + 1][Y]) {	// 아래쪽 체크
			bVisit[X + 1][Y] = true;
			AreaSet(X + 1, Y, cArray, flag);
			bVisit[X + 1][Y] = false;
		}
		if (Y - 1 >= 0 && cArray[X][Y - 1] == cData && !bVisit[X][Y - 1]) {	// 왼쪽 체크
			bVisit[X][Y - 1] = true;
			AreaSet(X, Y - 1, cArray, flag);
			bVisit[X][Y - 1] = false;
		}
	}
}
