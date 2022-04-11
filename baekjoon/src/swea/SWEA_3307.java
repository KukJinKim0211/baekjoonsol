package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최장 증가 부분 수열
public class SWEA_3307 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(bf.readLine());
		for (int test = 1; test <= testcase; test++) {
			int N = Integer.parseInt(bf.readLine());
			int max = 0;
			int[] iArray = new int[N];
			int[] DP = new int[N];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				iArray[i] = Integer.parseInt(st.nextToken());
				DP[i] = 1;
				for (int j = 0; j < i; j++) {
					if (iArray[i] > iArray[j] && DP[i] < DP[j] + 1)
						DP[i] = DP[j] + 1;
				}
				max = Math.max(DP[i], max);
			}
			sb.append("#" + test + " " + max + "\n");
		}
		System.out.print(sb);
	}
}
