package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 최대공약수와 최소공배수
public class BJ_2609 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int iA = Integer.parseInt(st.nextToken());
		int iB = Integer.parseInt(st.nextToken());
		
		int imin = iA < iB ? iA : iB;
		int ibae = 0;
		
		for (int i = 1; i <= imin; i++) {
			if (iA % i == 0 && iB % i == 0)
				ibae = i;
		}
		
		System.out.println(ibae);
		System.out.println(iA * iB / ibae);
	}
}
