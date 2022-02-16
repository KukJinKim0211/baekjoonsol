package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 요리사
public class SWEA_4012 {
	static int iMin;
	static int[][] iArray;
	static boolean[] bVisit;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int itestcase = Integer.parseInt(bf.readLine());
		for (int itest = 1; itest <= itestcase; itest++) {
			iMin = Integer.MAX_VALUE;
			int iN = Integer.parseInt(bf.readLine());
			iArray = new int[iN][iN];
			bVisit = new boolean[iN];
			for (int i = 0; i < iN; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < iN; j++) {
					iArray[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combination(iN, 0, 0);
			sb.append("#" + itest + " " + iMin + "\n");
		}
		System.out.println(sb);
	}
	
	static void combination (int iN, int iStart, int iCount) {
		if (iCount == iN / 2) {
			cal(iN);
			return;
		}
		for (int i = iStart; i < iN; i++) {
			bVisit[i] = true;
			combination(iN, i + 1, iCount + 1);
			bVisit[i] = false;
		}
	}
	
	static void cal(int iN) {
		int iA = 0;
		int iB = 0;
		for (int i = 0; i < iN - 1; i++) {
			for (int j = i + 1; j < iN; j++) {
				if (bVisit[i] && bVisit[j])
					iA += iArray[i][j] + iArray[j][i];
				else if (!bVisit[i] && !bVisit[j])
					iB += iArray[i][j] + iArray[j][i];
			}
		}
		iMin = Math.min(Math.abs(iA - iB), iMin);
	}
}
