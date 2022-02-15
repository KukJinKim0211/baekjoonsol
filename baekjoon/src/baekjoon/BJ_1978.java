package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 소수 찾기
public class BJ_1978 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iCount = Integer.parseInt(bf.readLine());
		int isosu = 0;
		StringTokenizer st = new StringTokenizer(bf.readLine());
		boolean bTrue = true;
		for (int i = 0; i < iCount; i++) {
			int iNum = Integer.parseInt(st.nextToken());
			bTrue = true;
			if (iNum == 1)
				continue;
			for (int j = 2; j <= Math.sqrt(iNum); j++) {
				if (iNum % j == 0) {
					bTrue = false;
					break;
				}
			}
			if (bTrue)
				isosu++;
		}
		System.out.println(isosu);
	}
}
