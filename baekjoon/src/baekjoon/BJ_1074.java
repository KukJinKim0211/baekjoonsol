package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Z
public class BJ_1074 {
	static int NN;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		NN = (int)Math.pow(2, N);
		int[][] iArray = new int[NN][NN];
		
		zz(iArray, 1, 0, 1, N);
	}
	
	static void zz(int[][] iArray, int iValue, int iX, int iY, int N) {
		if (iValue == NN * NN)
			return;
		
		if (iValue % 4 == 3) {
			if (iX == iY) {
				iX = 0;
				iY++;
			}
			else if (iX < iY) {
				
			}
		}
			
		else if (iValue % 4 == 0) {
			iArray[iX][iY] = iValue;
			zz(iArray, iValue + 1, iX, iY + 1, N);
		}
		else if (iValue % 4 == 1) {
			iArray[iX][iY] = iValue;
			zz(iArray, iValue + 1, iX + 1, iY - 1, N);
		}
		else if (iValue % 4 == 2) {
			iArray[iX][iY] = iValue;
			zz(iArray, iValue + 1, iX, iY + 1, N);
		}
	}
}
