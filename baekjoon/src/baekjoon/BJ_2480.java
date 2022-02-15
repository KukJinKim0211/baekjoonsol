package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주사위 세개
public class BJ_2480 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] iArray = new int[3];
		for (int i = 0; i < 3; i++) {
			iArray[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(iArray);
		if (iArray[0] == iArray[1] && iArray[1] == iArray[2])
			System.out.println(10000 + iArray[0] * 1000);
		else if (iArray[0] == iArray[1] || iArray[1] == iArray[2])
			System.out.println(1000 + iArray[1] * 100);
		else
			System.out.println(iArray[2] * 100);
	}
}
