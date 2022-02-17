package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 세개의 점
public class BJ_3009 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] iArray = new int[3][2];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(bf.readLine());
			iArray[i][0] = Integer.parseInt(st.nextToken());
			iArray[i][1] = Integer.parseInt(st.nextToken());
		}
		int iNum1 = 0;
		int iNum2 = 0;
		if (iArray[0][0] == iArray[1][0])
			iNum1 = iArray[2][0];
		else if (iArray[1][0] == iArray[2][0])
			iNum1 = iArray[0][0];
		else
			iNum1 = iArray[1][0];
		if (iArray[0][1] == iArray[1][1])
			iNum2 = iArray[2][1];
		else if (iArray[1][1] == iArray[2][1])
			iNum2 = iArray[0][1];
		else
			iNum2 = iArray[1][1];
		System.out.println(iNum1 + " " + iNum2);
	}
}
