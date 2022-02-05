package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11650 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int iCount = Integer.parseInt(bf.readLine());
		int[][] iArray = new int[iCount][2];

		for (int i = 0; i < iCount; i++) {
			st = new StringTokenizer(bf.readLine());
			iArray[i][0] = Integer.parseInt(st.nextToken());
			iArray[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(iArray, (e1, e2) -> {
			if (e1[0] == e2[0])
				return e1[1] - e2[1];
			else
				return e1[0] - e2[0];
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < iCount; i++) {
			sb.append(iArray[i][0] + " " + iArray[i][1] + "\n");
		}
		
		System.out.println(sb);
	}
}	
