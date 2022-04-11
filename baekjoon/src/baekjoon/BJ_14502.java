package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소
public class BJ_14502 {
	static int N, M;
	static int Max_Safe = 0;
	static int[][] iArray;
	static int[][] del = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	// 세로 길이
		M = Integer.parseInt(st.nextToken());	// 가로 길이
		iArray = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0);
		System.out.println(Max_Safe);
	}
	
	static void DFS(int cnt) {
		if (cnt == 3) {
			BFS(iArray);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (iArray[i][j] == 0) {
					iArray[i][j] = 1;
					DFS(cnt + 1);
					iArray[i][j] = 0;
				}
			}
		}
	}
	
	static void BFS(int[][] iArray) {
		// 연구소의 바이러스 번식을 체크 할 배열 
		int[][] copy = new int[N][M];
		// 배열에 연구소 현재 상태 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = iArray[i][j];
			}
		}
		// 큐
		Queue<Virus> que = new LinkedList<>();
		// 바이러스에 오염된 지역을 큐에 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 2)
					que.offer(new Virus(i, j));
			}
		}
		while (!que.isEmpty()) {
			Virus virus = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int dx = virus.x + del[i][0];
				int dy = virus.y + del[i][1];
				
				if (dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
				if (copy[dx][dy] != 0) continue;
				copy[dx][dy] = 2;
				que.offer(new Virus(dx, dy));
			}
		}
		
		calSafe(copy);
	}
	
	static void calSafe(int[][] arr) {
		int viruscnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0)
					viruscnt++;
			}
		}
		Max_Safe = Math.max(Max_Safe, viruscnt);
	}
	
	public static class Virus {
		int x;
		int y;
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
