package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 소인수분해
public class BJ_11653 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iNum = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		while (true) {
			if (iNum == 1)
				break;
			for (int i = 2; i <= iNum; i++) {
				if (iNum % i == 0) {
					sb.append(i + "\n");
					iNum /= i;
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
