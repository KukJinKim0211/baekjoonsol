package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빙고
public class BJ_2578 {
	static int[][] iArray;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		iArray = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 5; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int iNumIndex = 0;
		int[] iNum = new int[25];
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(bf.readLine());
			iNum[5 * i] = Integer.parseInt(st.nextToken());
			iNum[5 * i + 1] = Integer.parseInt(st.nextToken());
			iNum[5 * i + 2] = Integer.parseInt(st.nextToken());
			iNum[5 * i + 3] = Integer.parseInt(st.nextToken());
			iNum[5 * i + 4] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (iArray[i][j] == iNum[iNumIndex]) {
						iArray[i][j] = 0;
						if (bingoCheck()) {
							System.out.println(iNumIndex + 1);
							return;
						}
						else {
							iNumIndex++;
							continue;
						}
					}
				}
			}
		}
	}
	
	public static boolean bingoCheck() {
		int iSum = 0;
		int iBingoCnt = 0;
		for (int i = 0; i < 5; i++) {
			iSum = 0;
			for (int j = 0; j < 5; j++) {
				iSum += iArray[i][j];
			}
			if (iSum == 0)
				iBingoCnt++;
		}
		
		for (int i = 0; i < 5; i++) {
			iSum = 0;
			for (int j = 0; j < 5; j++) {
				iSum += iArray[j][i];
			}
			if (iSum == 0)
				iBingoCnt++;
		}
		
		iSum = 0;
		iSum = iArray[0][0] + iArray[1][1] + iArray[2][2] + iArray[3][3] + iArray[4][4];
		if (iSum == 0)
			iBingoCnt++;
		iSum = 0;
		iSum = iArray[0][4] + iArray[1][3] + iArray[2][2] + iArray[3][1] + iArray[4][0];
		if (iSum == 0)
			iBingoCnt++;
		if (iBingoCnt >= 3) 
			return true;
		
		return false;
	}
}
