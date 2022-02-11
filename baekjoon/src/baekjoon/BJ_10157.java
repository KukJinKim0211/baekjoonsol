package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10157 {
	static int iIndex;
	static int iCnt;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		int iN = Integer.parseInt(str.split(" ")[0]);
		int iM = Integer.parseInt(str.split(" ")[1]);
		int iNum = iN + iN + iM + iM - 4; // 첫번째외곽까지 앉을 수 있는 카운트
		iIndex = Integer.parseInt(bf.readLine());
		
		recall(iNum, 0);
		
	}
	
	public static void recall(int iNum, int iCount) {
		if (iNum > iIndex) {
			iCnt = iCount;
			return;
		}
		
		recall(iNum, iCount);
	}
}
