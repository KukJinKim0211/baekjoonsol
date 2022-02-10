package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 일곱 난쟁이
public class BJ_2309 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] iArray = new int[9];	// 난쟁이 수
		int[] iArray2 = new int[2];	// 스파이 난쟁이 수
		int iSum = 0;
		for (int i = 0; i < 9; i++) {
			iArray[i] = Integer.parseInt(bf.readLine());
			iSum += iArray[i];
		}
		
		Arrays.sort(iArray);
		
		boolean isSpy = false;
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (iSum - iArray[i] - iArray[j] == 100) {
					iArray2[0] = iArray[i];
					iArray2[1] = iArray[j];
					isSpy = true;
				}
				if (isSpy) break;
			}
			if (isSpy) break;
		}
		
		for (int i = 0; i < 9; i++) {
			if (iArray[i] !=  iArray2[0] && iArray[i] != iArray2[1])
				sb.append(iArray[i] + "\n");
		}
		System.out.println(sb);
	}
}
