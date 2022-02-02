package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_8370 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int iBusiness = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		int iEconomic = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		
		System.out.println(iBusiness + iEconomic);
	}
}
