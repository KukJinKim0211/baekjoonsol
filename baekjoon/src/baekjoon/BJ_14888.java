package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연산자 끼워넣기
public class BJ_14888 {
	static int N;			// 피연산자의 갯수
	static int Max, Min;
	static int[] operator;	// 연산자 갯수 배열
	static int[] number;	// 피연산자 배열
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		number = new int[N];
		operator = new int[4];
		Min = Integer.MAX_VALUE;
		Max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		dfs(number[0], 1);
		System.out.println(Max);
		System.out.println(Min);
	}
	
	static void dfs(int iNum, int idx) {
		if (idx == N) {
			Max = Math.max(Max, iNum);
			Min = Math.min(Min, iNum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;
				switch (i) {
				case 0: dfs(iNum + number[idx], idx + 1); break;
				case 1: dfs(iNum - number[idx], idx + 1); break;
				case 2: dfs(iNum * number[idx], idx + 1); break;
				case 3: dfs(iNum / number[idx], idx + 1); break;
				}
				operator[i]++;
			}
		}
	}
}
