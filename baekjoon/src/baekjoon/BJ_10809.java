package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 알파벳 찾기
public class BJ_10809 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		int[] iArray = new int[26];
		for (int i = 0; i < iArray.length; i++) {
			iArray[i] = -1;
		}
		for (int i = 0; i < str.length(); i++) {
			if (iArray[str.charAt(i) - 'a'] == -1)
				iArray[str.charAt(i) - 'a'] = i;
		}
		
		for (int i: iArray) {
			System.out.print(i + " ");
		}
	}
}
