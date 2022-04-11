package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 게리멘더링
public class BJ_17471 {
	static int N;			// 구역의 갯수
	static int MIN = Integer.MAX_VALUE;
	static int LIMIT;		// 부분집합을 제한
	static int[] people;	// 구역의 인구수
	static int[][] link;	// 각 구역 별 연결된 구역 2차원 배열
	static int[] number1, number2;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		people = new int[N + 1];
		link = new int[N + 1][N + 1];
		number1 = new int[N + 1];
		number2 = new int[N + 1];
		visit = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			people[i + 1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			int range = Integer.parseInt(st.nextToken());
			for (int j = 0; j < range; j++) {
				int temp = Integer.parseInt(st.nextToken());
				link[i][temp] = 1;
				link[temp][i] = 1;
			}
		}
		if (N == 2) {
			System.out.println(Math.abs(people[1] - people[2]));
			return;
		}

		combi(1, 0);
		System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
	}
	
	static void combi(int start, int count) {
		if (count == N) {
			if (++LIMIT > Math.pow(2, N) / 2) return;	// 부분집합의 중복 제거
			
			int tempcnt = 0;		
			int[] temp1 = new int[N + 1];
			int[] temp2 = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				if (visit[i]) {
					temp1[i] = 1;
					tempcnt++;
				}
				else {
					temp2[i] = 1;
				}
			}
			
			if (tempcnt == N || tempcnt == 0) return;	// 모든 해를 가지는 부분집합의 경우 하지 않음
			
			// 각 구역별 연결 되어 있는지 체크
			if (!invalid(temp1, temp2)) return;
			
			int result1 = 0;
			int result2 = 0;
			for (int i = 1; i <= N; i++) {
				if (temp1[i] == 1)
					result1 += people[i];
				else
					result2 += people[i];
			}
			MIN = Math.min(MIN, Math.abs(result1 - result2));
			return;
		}
		
		for (int i = start; i <= N ; i++) {
			visit[i] = true;
			combi(i + 1, count + 1);
			visit[i] = false;
			combi(i + 1, count + 1);
		}
	}
	
	// 부분집합으로 완성된 두개의 배열에 대하여 각 구역이 연결되어 있는지 체크
	static boolean invalid(int[] arr1, int[] arr2) {
		boolean[] check = new boolean[N + 1];
		int cnt = 0;
		// 첫번째 배열 체크
		for (int i = 1; i <= N; i++) {
			if (arr1[i] == 1)
				check[i] = true;
		}
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (arr1[i] == 1 && arr1[j] == 1) {
					if (link[i][j] == 1) {
						check[i] = false;
						check[j] = false;
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (check[i]) cnt++;
		}
		
		if (cnt > 1) return false;
		cnt = 0;
		
		// 두번째 배열 체크
		for (int i = 1; i <= N; i++) {
			if (arr2[i] == 1)
				check[i] = true;
		}
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (arr2[i] == 1 && arr2[j] == 1) {
					if (link[i][j] == 1) {
						check[i] = false;
						check[j] = false;
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (check[i]) cnt++;
		}
		if (cnt > 1) return false;
		
		return true;
	}
}
