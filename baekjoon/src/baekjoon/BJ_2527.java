package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직사각형
public class BJ_2527 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] iRange = new int[4][2];
		for (int itest = 0; itest < 4; itest++) {
			st = new StringTokenizer(bf.readLine());
			
			for (int i = 0; i < 4; i++) {
				iRange[i][0] = Integer.parseInt(st.nextToken());
				iRange[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
			if ((iRange[1][0] == iRange[2][0] && iRange[1][1] == iRange[2][1]) || (iRange[0][0] == iRange[3][0] && iRange[1][1] == iRange[2][1]) ||
			     (iRange[0][0] == iRange[3][0] && iRange[0][1] == iRange[3][1]) || (iRange[1][0] == iRange[2][0] && iRange[0][1] == iRange[3][1]))
				sb.append("c\n");
			// 선
			else if ((iRange[1][0] == iRange[2][0] && iRange[1][1] != iRange[2][1]) || (iRange[0][0] == iRange[3][0] && iRange[1][1] != iRange[2][1]) ||
					 (iRange[0][0] != iRange[3][0] && iRange[0][1] == iRange[3][1]) || (iRange[1][0] != iRange[2][0] && iRange[0][1] == iRange[3][1]))
				sb.append("b\n");
			// 겹치지않을때
			else if (iRange[1][0] < iRange[2][0] || iRange[0][0] > iRange[3][0] || iRange[1][1] < iRange[2][1] || iRange[0][1] > iRange[3][1])
					sb.append("d\n");
			else 
				sb.append("a\n");
		}
		sb.setLength(sb.length() -1);
		System.out.println(sb);
	}
}
