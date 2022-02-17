package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 알파벳
public class BJ_1987 {
	static int R, C, iMax;
	static char[][] cArray;
	static boolean[] bVisit = new boolean[26];
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		R = Integer.parseInt(str.split(" ")[0]);
		C = Integer.parseInt(str.split(" ")[1]);
		cArray = new char[R][C];
		for (int i = 0; i < R; i++) {
			str = bf.readLine();
			for (int j = 0; j < C; j++) {
				cArray[i][j] = str.charAt(j);
			}
		}
		find(0, 0, 0);
		System.out.println(iMax);
	}
	
	static void find(int startX, int startY, int iCount) {
		if (bVisit[cArray[startX][startY] - 'A']) {
			iMax = Math.max(iMax, iCount);
			return;
		}
		iCount++;
		//위쪽
		if (startX - 1 >= 0) {
			bVisit[cArray[startX][startY] - 'A'] = true;
			find(startX - 1, startY, iCount);
			bVisit[cArray[startX][startY] - 'A'] = false;
		}
		//오른쪽
		if (startY + 1 < C) {
			bVisit[cArray[startX][startY] - 'A'] = true;
			find(startX, startY + 1, iCount);
			bVisit[cArray[startX][startY] - 'A'] = false;
		}
		//아래쪽
		if (startX + 1 < R) {
			bVisit[cArray[startX][startY] - 'A'] = true;
			find(startX + 1, startY, iCount);
			bVisit[cArray[startX][startY] - 'A'] = false;
		}
		//왼쪽
		if (startY - 1 >= 0) {
			bVisit[cArray[startX][startY] - 'A'] = true;
			find(startX, startY - 1, iCount);
			bVisit[cArray[startX][startY] - 'A'] = false;
		}
	}
}
