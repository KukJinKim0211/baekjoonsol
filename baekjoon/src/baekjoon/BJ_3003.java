package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3003 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int iKing = Integer.parseInt(st.nextToken());
		int iQueen = Integer.parseInt(st.nextToken());
		int iLook = Integer.parseInt(st.nextToken());
		int ibishop = Integer.parseInt(st.nextToken());
		int iknight = Integer.parseInt(st.nextToken());
		int ipone = Integer.parseInt(st.nextToken());
		
		System.out.printf("%d %d %d %d %d %d", 
						  1 - iKing,
						  1 - iQueen,
						  2 - iLook,
						  2 - ibishop,
						  2 - iknight,
						  8 - ipone);
	}
}
