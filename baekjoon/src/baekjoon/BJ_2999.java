package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 비밀 이메일
public class BJ_2999 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = bf.readLine();
		int R = 0;
		int C = 0;
		int iIndex = 0;
		for (int i = (int)(Math.sqrt(str.length())); i >= 1 ; i--) {
			if (str.length() % i == 0 || i == 1) {
				R = i;
				C = str.length() / R;
				break;
			}
		}
		char[][] cArray = new char[R][C];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				cArray[j][i] = str.charAt(iIndex++);
			}
		}
		for (char[] c1 : cArray) {
			for (char c2 : c1) {
				sb.append(c2);
			}
		}
		System.out.println(sb);
	}
}
