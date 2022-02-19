package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 직사각형을 만드는법
public class BJ_8320 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		if (n == 1) {
			System.out.println("1");
			return;
		}
		else if (n == 2) {
			System.out.println("2");
			return;
		}
		int iResult = 2;
		for (int i = 3; i <= n; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0)
					iResult++;
			}
			iResult += 1;
		}
		System.out.println(iResult);
			
	}
}
