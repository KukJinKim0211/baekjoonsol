package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 정렬하기
public class BJ_10989 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] array = new int[10001];
		int N = Integer.parseInt(bf.readLine());
		for (int i = 0; i < N; i++) {
			array[Integer.parseInt(bf.readLine())]++;
		}
		int count = 0;
		for (int i = 1; i < 10001; i++) {
			if (count == N)
				break;
			while (array[i] > 0) {
				sb.append(i).append("\n");
				array[i]--;
				count++;
			}
		}
		System.out.println(sb);
	}
}
