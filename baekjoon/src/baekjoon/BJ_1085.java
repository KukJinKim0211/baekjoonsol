package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직사각형에서 탈출
public class BJ_1085 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int iMin = Integer.MAX_VALUE;
		
		int iX = Integer.parseInt(st.nextToken());
		int iY = Integer.parseInt(st.nextToken());
		int iw = Integer.parseInt(st.nextToken());
		int ih = Integer.parseInt(st.nextToken());
		
		iMin = Math.min(iMin, Math.abs(iw - iX));
		iMin = Math.min(iMin, Math.abs(iX));
		iMin = Math.min(iMin,  Math.abs(ih - iY));
		iMin = Math.min(iMin,  Math.abs(iY));
		System.out.println(iMin);
	}
}
