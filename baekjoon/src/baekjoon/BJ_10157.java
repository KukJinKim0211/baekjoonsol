package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10157 {
	static int iIndex;
	static int iCnt;
	static int iN;
	static int iM;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		iN = Integer.parseInt(str.split(" ")[0]);
		iM = Integer.parseInt(str.split(" ")[1]);
		int iNum = iN + iN + iM + iM - 4; // 첫번째외곽까지 앉을 수 있는 카운트
		iIndex = Integer.parseInt(bf.readLine());
		
		recall(iM, iN - 2, 1, iIndex, 0);
		
	}
	
	public static void recall(int N, int M, int iAdd, int iIndex, int iCount) {
		if (2 * N + 2 * M + iAdd <= iIndex)
			recall(N - 2, M - 2, 2 * N + 2 * M + iAdd, iIndex, iCount + 1);
		else {
			if (iAdd + N > iIndex)
				System.out.println((iCount + iIndex - 1) + " " + (iCount));
			else if (iAdd + N + M > iIndex)
				System.out.println((iM - iCount) + " " + )
			return;
		}
	}
}
