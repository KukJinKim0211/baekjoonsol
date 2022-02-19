package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블랙잭
public class BJ_2798 {
	static int size;
	static int Value;
	static int[] iArray;
	static int[] ia = new int[3];
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		size = Integer.parseInt(st.nextToken());
		Value = Integer.parseInt(st.nextToken());
		iArray = new int[size];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < size; i++) {
			iArray[i] = Integer.parseInt(st.nextToken());
		}
		int isum = 0;
		int iValue = 0;
		for (int i = 0; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					isum = iArray[i] + iArray[j] + iArray[k];
					if (isum == Value) {
						System.out.println(isum);
						return;
					}
					if (iValue < isum && isum <= Value)
						iValue = isum;
				}
			}
		}
		System.out.println(iValue);
	}
}
