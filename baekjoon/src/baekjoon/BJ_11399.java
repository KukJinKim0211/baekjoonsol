package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//ATM
public class BJ_11399 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iSum = 0;
		int ipeople = Integer.parseInt(bf.readLine());
		int[] iArray = new int[ipeople];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < ipeople; i++) {
			iArray[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(iArray);
		
		for (int i = 0; i < ipeople; i++) {
			for (int j = 0; j <= i; j++) {
				iSum += iArray[j];
			}
		}
		System.out.println(iSum);
	}
}
