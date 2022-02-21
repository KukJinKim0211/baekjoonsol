package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// DFS와 BFS
public class BJ_1260 {
	static int N, M, V;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		int[][] iArray = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int iFrom = Integer.parseInt(st.nextToken());
			int iTo = Integer.parseInt(st.nextToken());
			
			iArray[iFrom][iTo] = iArray[iTo][iFrom] = 1;
		}
		dfs(iArray, new boolean[N + 1], V);
		sb.append("\n");
		bfs(iArray, V);
		System.out.println(sb);
	}
	
	static void bfs(int[][] iArray, int iStart) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];
		queue.offer(iStart);
		visited[iStart] = true;
		
		while (!queue.isEmpty() ) {
			int current = queue.poll();
			sb.append(current + " ");
			// current 정점은 인접정점 처리(단, 방문하지 않은 인접정점만)
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && iArray[current][j] != 0) {
					queue.offer(j);
					visited[j] = true;
				}
					
			}
		}
	}
	
	static void dfs(int[][] iArray, boolean[] visited, int current) {
		visited[current] = true;
		sb.append(current + " ");
		
		for (int j = 1; j <= N; j++) {
			if (!visited[j] && iArray[current][j] > 0) {
				dfs(iArray, visited, j);
			}
		}
	}

}
