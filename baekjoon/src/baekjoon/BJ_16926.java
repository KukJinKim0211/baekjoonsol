package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 배열 돌리기1
public class BJ_16926 {
	static int iN,iM;
	static int[][] iArray;
	static int[][] idelta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		iN = Integer.parseInt(st.nextToken());
		iM = Integer.parseInt(st.nextToken());
		int iCnt = Integer.parseInt(st.nextToken());
		
		iArray = new int[iN][iM];
		
		for (int i = 0; i < iN; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < iM; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int itest = 0; itest < iCnt; itest++) {
			arrayRotate(0, 0, 0, 0);
		}
		
		for (int[] i1 : iArray) {
			for (int i2 : i1) {
				sb.append(i2 + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void arrayRotate(int iRow, int iCol, int idIndex, int iinIndex) {
		int iSetRow = iRow;
		int iSetCol = iCol;
		int itemp = iArray[iRow][iCol];
		while (true) {
			if (idIndex == 3 && (iRow - 1 == iSetRow && iCol == iSetCol)) {
				iArray[iRow][iCol] = itemp;
				break;
			}
			if ( (iRow + idelta[idIndex][0] >= iinIndex && iRow + idelta[idIndex][0] < iN - iinIndex) &&
				 (iCol + idelta[idIndex][1] >= iinIndex && iCol + idelta[idIndex][1] < iM - iinIndex)) {
				iArray[iRow][iCol] = iArray[iRow + idelta[idIndex][0]][iCol + idelta[idIndex][1]];
				iRow += idelta[idIndex][0];
				iCol += idelta[idIndex][1];
			}
			else
				idIndex++;
		}

		if (iinIndex + 1 < iN - iinIndex - 1 && iinIndex  + 1 < iM - iinIndex - 1) {
			arrayRotate(iinIndex + 1, iinIndex + 1, 0, iinIndex + 1);
		}
		else
			return;
	}
}
