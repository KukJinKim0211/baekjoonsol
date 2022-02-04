package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1954 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iCnt = Integer.parseInt(bf.readLine());
		int[][] ibang = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
		int ibangCnt = 0;
		
		for (int test = 1; test <= iCnt; test++) {
			int iSize = Integer.parseInt(bf.readLine());
			int[][] iArray = new int[iSize][iSize];
			int iX = 0;
			int iY = 0;
			ibangCnt = 0;

			for (int i1 = 0; i1 < iSize * iSize; i1++) {
				iArray[iX][iY] = i1 + 1;
				
				iX += ibang[ibangCnt][0];
				iY += ibang[ibangCnt][1];
				
				// 범위 벗어날 시
				if ((iX < 0 || iX >= iSize) || (iY < 0 || iY >= iSize)) {
					iX -= ibang[ibangCnt][0];
					iY -= ibang[ibangCnt][1];
					
					ibangCnt = (ibangCnt + 1) % 4;
					
					iX += ibang[ibangCnt][0];
					iY += ibang[ibangCnt][1];
				}
				
				// 값이있을때
				if (iArray[iX][iY] != 0) {
					iX -= ibang[ibangCnt][0];
					iY -= ibang[ibangCnt][1];
					
					ibangCnt = (ibangCnt + 1) % 4;
					
					iX += ibang[ibangCnt][0];
					iY += ibang[ibangCnt][1];
				}
			}
			
			System.out.println("#" + test);
			for (int[] a1 : iArray) {
				for (int a : a1) {
					System.out.printf("%d ", a);
				}
				System.out.println();
			}
			
		}
	}
}
