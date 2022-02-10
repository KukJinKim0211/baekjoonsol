package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열 돌리기3
public class BJ_16935 {
	static int iN, iM;
	static int[][] iArray;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		iN = Integer.parseInt(st.nextToken());
		iM = Integer.parseInt(st.nextToken());
		int itestcase = Integer.parseInt(st.nextToken());
		iArray = new int[iN][iM];
		
		for (int i = 0; i < iN; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < iM; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		
		for (int itest = 1; itest <= itestcase; itest++) {
			int iCalIndex = Integer.parseInt(st.nextToken());
			switch (iCalIndex) {
			case 1: updownSwap(); break;
			case 2: leftrightSwap(); break;
			case 3: rightrotate90(); break;
			case 4: leftrotate90(); break;
			case 5: clockdirectiondiv(); break;
			case 6: revclockdirectiondiv(); break;
			}
		}
		
		for (int[] i1 : iArray) {
			for (int i2: i1) {
				sb.append(i2 + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	// 1번 연산 상하반전
	public static void updownSwap() {
		int iRow = 0;
		int itemp = 0;
		int iRowCount = iN - 1;
		
		while (true) {
			if (iRow >= iRowCount)
				break;
			
			for (int i = 0; i < iM; i++) {
				itemp = iArray[iRow][i];
				iArray[iRow][i] = iArray[iRowCount][i];
				iArray[iRowCount][i] = itemp;
			}
			iRow++;
			iRowCount--;
		}
	}
	
	// 2번 연산 좌우반전
	public static void leftrightSwap() {
		int iCol = 0;
		int itemp = 0;
		int iColCount = iM - 1;
		
		while (true) {
			if (iCol >= iColCount)
				break;
			
			for (int i = 0; i < iN; i++) {
				itemp = iArray[i][iCol];
				iArray[i][iCol] = iArray[i][iColCount];
				iArray[i][iColCount] = itemp;
			}
			iCol++;
			iColCount--;
		}
	}
	
	// 3번 연산 90도 오른쪽 회전
	public static void rightrotate90() {
		int[][] iArray2 = new int[iM][iN];
		for (int i = 0; i < iN; i++) {
			for (int j = 0; j < iM; j++) {
				iArray2[j][iN - 1 - i] = iArray[i][j];
			}
		}
		int itemp = iN;
		iN = iM;
		iM = itemp;
		iArray = iArray2;
	}
	
	// 4번 연산 90도 왼쪽 회전
	public static void leftrotate90() {
		int[][] iArray2 = new int[iM][iN];
		for (int i = 0; i < iN; i++) {
			for (int j = 0; j < iM; j++) {
				iArray2[iM - 1 - j][i] = iArray[i][j];
			}
		}
		int itemp = iN;
		iN = iM;
		iM = itemp;
		iArray = iArray2;
	}
	
	// 5번 연산 시계방향 이
	public static void clockdirectiondiv() {
		int iRowIndex = 0;
		int iColIndex = 0;
		int iNCol = iM / 2;
		int iNRow = iN / 2;
		int[][] iArray2 = new int[iNRow][iNCol];
		// 좌하단 부위 따로 저장
		for (int i = iNRow; i < iN; i++) {
			iColIndex = 0;
			for (int j = 0; j < iNCol; j++) {
				iArray2[iRowIndex][iColIndex++] = iArray[i][j];
			}
			iRowIndex++;
		}
		// 우하단 -> 좌하단
		for (int i = iNRow; i < iN; i++) {
			for (int j = iNCol; j < iM; j++) {
				iArray[i][j - iNCol] = iArray[i][j]; 
			}
		}

		// 우상단 -> 우하단
		for (int i = 0; i < iNRow; i++) {
			for (int j = iNCol; j < iM; j++) {
				iArray[i + iNRow][j] = iArray[i][j];
			}
		}
		// 좌상단 -> 우상단
		for (int i = 0; i < iNRow; i++) {
			for (int j = 0; j < iNCol; j++) {
				iArray[i][j + iNCol] = iArray[i][j];
			}
		}
		// 좌하단 -> 좌상단
		for (int i = 0; i < iNRow; i++) {
			for (int j = 0; j < iNCol; j++) {
				iArray[i][j] = iArray2[i][j];
			}
		}
	}
	
	// 6번 연산 반시계방향 이동
	public static void revclockdirectiondiv() {
		int iRowIndex = 0;
		int iColIndex = 0;
		int iNCol = iM / 2;
		int iNRow = iN / 2;
		int[][] iArray2 = new int[iNRow][iNCol];
		// 좌상단 부위 따로 저장
		for (int i = 0; i < iNRow; i++) {
			iColIndex = 0;
			for (int j = 0; j < iNCol; j++) {
				iArray2[iRowIndex][iColIndex++] = iArray[i][j];
			}
			iRowIndex++;
		}
		// 우상단 -> 좌상단
		for (int i = 0; i < iNRow; i++) {
			for (int j = iNCol; j < iM; j++) {
				iArray[i][j - iNCol] = iArray[i][j];
			}
		}
		// 우하단 -> 우상단
		for (int i = iNRow; i < iN; i++) {
			for (int j = iNCol; j < iM; j++) {
				iArray[i - iNRow][j] = iArray[i][j];
			}
		}
		// 좌하단 -> 우하단
		for (int i = iNRow; i < iN; i++) {
			for (int j = 0; j < iNCol; j++) {
				iArray[i][j + iNCol] = iArray[i][j];
			}
		}
		// 좌상단 -> 좌하단
		for (int i = 0; i < iNRow; i++) {
			for (int j = 0; j < iNCol; j++) {
				iArray[i + iNRow][j] = iArray2[i][j];
			}
		}
	}
}
