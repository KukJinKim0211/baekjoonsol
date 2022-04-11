package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB거리
public class BJ_1149 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(bf.readLine());
		int[][] array = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
			array[i][2] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			array[i][0] = Math.min(array[i - 1][1], array[i - 1][2]) + array[i][0];
			array[i][1] = Math.min(array[i - 1][0], array[i - 1][2]) + array[i][1];
			array[i][2] = Math.min(array[i - 1][0], array[i - 1][1]) + array[i][2];
		}
		System.out.println(Math.min(array[N][0], Math.min(array[N][1], array[N][2])));
	}
}
