package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 분해합
public class BJ_2231 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String N = bf.readLine();
		int iN = Integer.parseInt(N);
		int iM = 1;
		for (int i = 1; i < iN; i++) {
			String M = Integer.toString(iM);
			int iNum = iM;
			for (int j = 0; j < M.length(); j++) {
				iNum += M.charAt(j) - '0';
			}
			if (iNum == iN) {
				System.out.println(iM);
				return;
			}
			iM++;
		}
		System.out.println("0");
	}
}
