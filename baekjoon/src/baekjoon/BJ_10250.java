package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10250 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int itestcase = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int itest = 1; itest <= itestcase; itest++) {
			st = new StringTokenizer(bf.readLine());
			int iFloor = Integer.parseInt(st.nextToken());
			int iCount = Integer.parseInt(st.nextToken());
			int iNum = Integer.parseInt(st.nextToken());
			
			sb.append(iNum % iFloor == 0 ? iFloor : iNum % iFloor);
			sb.append(String.format("%02d\n", iNum % iFloor == 0 ?  iNum / iFloor : iNum / iFloor + 1));
			
		}
		System.out.println(sb);
	}
}
