package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소수 구하기
public class BJ_1929 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int iN = Integer.parseInt(st.nextToken());
		int iM = Integer.parseInt(st.nextToken());
		boolean bsosu = true;
		for (int i = iN; i <= iM; i++) {
			if (i == 1)
				continue;
			bsosu = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					bsosu = false;
					break;
				}
			}
			if (bsosu)
				sb.append(i + "\n");
		}
		System.out.println(sb);
	}
}
