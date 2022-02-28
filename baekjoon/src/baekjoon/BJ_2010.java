package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 플러그
public class BJ_2010 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(bf.readLine());
		int[] iArray = new int[size];
		for (int i = 0; i < size; i++) {
			iArray[i] = Integer.parseInt(bf.readLine());
		}
		
		int iCount = 0;
		for (int i = 0; i < size - 1; i++) {
			iCount += iArray[i] - 1;
		}
		System.out.println(iCount + iArray[size - 1]);
	}
}
