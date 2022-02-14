package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 도영이가 만든 맛있는 음식
public class BJ_2961 {
	static int iN;
	static int[] isin;
	static int[] issn;
	static int iMax = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		iN = Integer.parseInt(bf.readLine());
		isin = new int[iN];
		issn = new int[iN];
		for (int i = 0; i < iN; i++) {
			st = new StringTokenizer(bf.readLine());
			isin[i] = Integer.parseInt(st.nextToken());
			issn[i] = Integer.parseInt(st.nextToken());
		}
		permu(0, 1, 0, 0);
		System.out.println(iMax);
	}
	
	static void permu(int iIndex, int sin, int ssn, int icheck) {
		if (iIndex == iN) {
			if (iMax > Math.abs(sin - ssn) && icheck != 0)
				iMax = Math.abs(sin - ssn);
			return;
		}
		
		permu(iIndex + 1, sin * isin[iIndex], ssn + issn[iIndex], icheck + 1);
		permu(iIndex + 1, sin, ssn, icheck);
	}
}
