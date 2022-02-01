package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2845 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(bf.readLine());
		
		int iCnt = Integer.parseInt(str.nextToken());
		int iPeople = Integer.parseInt(str.nextToken());
		
		int iTotal = iCnt * iPeople;
		
		str = new StringTokenizer(bf.readLine());
		
		System.out.printf("%d %d %d %d %d", Integer.parseInt(str.nextToken()) - iTotal,
											Integer.parseInt(str.nextToken()) - iTotal,
											Integer.parseInt(str.nextToken()) - iTotal,
											Integer.parseInt(str.nextToken()) - iTotal,
											Integer.parseInt(str.nextToken()) - iTotal);
	}
}
