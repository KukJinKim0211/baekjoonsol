package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 경비원
public class BJ_2564 {
	static int garo;
	static int sero;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		garo = Integer.parseInt(st.nextToken());
		sero = Integer.parseInt(st.nextToken());
		int iStoreCount = Integer.parseInt(bf.readLine());
		int[] iStore = new int[iStoreCount + 1];
		for (int i = 0; i < iStoreCount + 1; i++) {
			st = new StringTokenizer(bf.readLine());
			int iArea = Integer.parseInt(st.nextToken());
			int iNum = Integer.parseInt(st.nextToken());
			
			if (iArea == 1 ) 
				iStore[i] = iNum;
			else if (iArea == 2) 
				iStore[i] = garo + sero + garo - iNum;
			else if (iArea == 3) 
				iStore[i] = garo + sero + garo + sero - iNum;
			else 
				iStore[i] = garo + iNum;
			
		}
		int iLength = 0;
		int iResult = 0;
		for (int i = 0; i < iStoreCount; i++) {
			iLength = Math.abs(iStore[iStoreCount] - iStore[i]);
			iResult += Math.min(iLength, (garo + sero) * 2 - iLength);
		}
		System.out.println(iResult);
	}
}
