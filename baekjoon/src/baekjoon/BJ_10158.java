package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 개미
public class BJ_10158 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int iN = Integer.parseInt(st.nextToken()) + 1;
		int iM = Integer.parseInt(st.nextToken()) + 1;
		st = new StringTokenizer(bf.readLine());
		int iRow = Integer.parseInt(st.nextToken());
		int iCol = Integer.parseInt(st.nextToken());
		int iCnt = Integer.parseInt(bf.readLine());
		int iX = -1;
		int iY = 1;
		while (true) {
			if (iCnt == 0)
				break;
			if ( (iRow + iX >= 0 && iRow + iX < iN) && (iCol + iY >= 0 && iCol + iY < iM) ) {
				iRow += iX;
				iCol += iY;
				iCnt--;
			}
			else {
				if (iRow + iX < 0 && iCol + iY < 0) {
					iX = 1;
					iY = 1;
					continue;
				}
				else if (iRow + iX == iN && iCol + iY < 0) {
					iX = -1;
					iY = 1;
					continue;
				}
				else if (iRow + iX == iN && iCol + iY == iM) {
					iX = -1;
					iY = -1;
					continue;
				}
				else if (iRow + iX < 0 && iCol + iY == iM) {
					iX = 1;
					iY = -1;
					continue;
				}
				
				if (iRow + iX < 0)
					iX = 1;
				else if (iRow + iX == iN)
					iX = -1;
				else if (iCol + iY < 0)
					iY = 1;
				else if (iCol + iY == iM)
					iY = -1;
			}
		}
		
		System.out.println(iRow + " " + iCol);
		System.out.println(Math.abs(iN - iRow) + " " + iCol);
	}
}
