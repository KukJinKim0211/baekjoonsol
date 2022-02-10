package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 수열
public class BJ_2491 {	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iNumCount = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Queue<Integer> q = new LinkedList<>();
		int[] iArray = new int[iNumCount];
		for (int i = 0; i < iNumCount; i++) {
			iArray[i] = Integer.parseInt(st.nextToken());
		}
		
		int iMax = 0;
		int iCount = 1;
		for (int i = 0; i < iNumCount - 1; i++) {
			if (iArray[i] <= iArray[i + 1])
				iCount++;
			else {
				iMax = Math.max(iMax,  iCount);
				iCount = 1;
			}
		}
		iMax = Math.max(iMax, iCount);
		iCount = 1;
		for (int i = 0; i < iNumCount - 1; i++) {
			if (iArray[i] >= iArray[i + 1])
				iCount++;
			else {
				iMax = Math.max(iMax,  iCount);
				iCount = 1;
			}
		}
		iMax = Math.max(iMax, iCount);
		System.out.println(iMax);
	}
}
