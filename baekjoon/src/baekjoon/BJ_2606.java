package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 바이러스
public class BJ_2606 {
	static int N, Count;
	static int[][] iArray;
	static int[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		iArray = new int[N + 1][N + 1];
		visit = new int[N + 1];
		int M = Integer.parseInt(bf.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			iArray[a][b] = 1;
			iArray[b][a] = 1;
		}
		bfs(1);
		System.out.println(Count);
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		visit[start] = 1;
		que.offer(start);
		
		while (!que.isEmpty()) {
			int a = que.poll();
			for (int i = 2; i <= N; i++) {
				if (iArray[a][i] == 1 && visit[i] != 1) {
					Count++;
					visit[i] = 1;
					que.offer(i);
				}
			}
		}
	}
}
