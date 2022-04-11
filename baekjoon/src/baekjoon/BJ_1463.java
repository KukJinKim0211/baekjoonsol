package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1로 만들기
public class BJ_1463 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] DP = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			DP[i] = DP[i - 1] + 1;
			if (i % 3 == 0) DP[i] = Math.min(DP[i], DP[i / 3] + 1);
			if (i % 2 == 0) DP[i] = Math.min(DP[i], DP[i / 2] + 1);
		}
		System.out.println(DP[N]);
	}
}
