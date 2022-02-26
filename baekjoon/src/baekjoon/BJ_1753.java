package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최단경로
public class BJ_1753 {
	static int V, E, K;
	static int[] distance;
	static ArrayList[] adjList;
	static class Node {
		int vertex;
		Node link;
		public Node (int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		V = Integer.parseInt(st.nextToken());		// 정점의 수
		E = Integer.parseInt(st.nextToken());		// 간선의 수
		K = Integer.parseInt(st.nextToken());		// 시작점
		
		distance = new int[V + 1];			// 거리배열
		Arrays.fill(distance, Integer.MAX_VALUE);   // 거리배열 Max 값 초기화
		
		adjList = new ArrayList[V + 1];		// 인접리스트 초기화
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			//adjList[u].add(new Node())
		}
	}
}
