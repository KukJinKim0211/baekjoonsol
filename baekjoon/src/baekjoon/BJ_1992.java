package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 쿼드 트리
public class BJ_1992 {
	static int[][] iArray;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iSize = Integer.parseInt(bf.readLine());
		iArray = new int[iSize][iSize];
		for (int i = 0; i < iSize; i++) {
			String str = bf.readLine();
			for (int j = 0; j < iSize; j++) {
				iArray[i][j] = str.charAt(j) - '0';
			}
		}
		find(iSize);
	}
	
	static void find(int iSize) {
		if (iSize == 0)
			return;
		int iSum = 0;
		// 좌상 사분면 검사
		for (int i = 0; i < iSize / 2; i++) {
			for (int j = 0; j < iSize / 2; j++) {
				iSum += iArray[i][j];
			}
		}

		iSum = 0;
		// 우상 사분면 검사
		for (int i = 0; i < iSize / 2; i++) {
			for (int j = iSize / 2; j < iSize; j++) {
				iSum += iArray[i][j];
			}
		}

		iSum = 0;
		// 좌하 사분면 검사
		for (int i = iSize / 2; i < iSize; i++) {
			for (int j = 0; j < iSize / 2; j++) {
				iSum += iArray[i][j];
			}
		}
		
		iSum = 0;
		// 우하 사분면 검사
		for (int i = iSize / 2; i < iSize; i++) {
			for (int j = iSize / 2; j < iSize; j++) {
				iSum += iArray[i][j];
			}
		}
	}
}
