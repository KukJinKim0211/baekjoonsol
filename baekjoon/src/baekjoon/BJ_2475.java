package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2475 {
	
	public static void main (String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int iNum = 0;
		int iHash = 0;
		
		for (int i = 0; i < 5; i++) {
			iNum = Integer.parseInt(st.nextToken());
			iHash += iNum * iNum;
		}
		
		System.out.println(iHash % 10);
	}
}
