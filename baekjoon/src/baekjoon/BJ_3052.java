package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 나머지
public class BJ_3052 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] iArray = new int[42];
		String str = null;
		for (int i = 0; i < 10; i++) {
			iArray[Integer.parseInt(bf.readLine()) % 42]++;
		}
		int iResult = 0;
		for (int i = 0; i < 42; i++) {
			if (iArray[i] != 0)
				iResult++;
		}
		System.out.println(iResult);
	}
}
