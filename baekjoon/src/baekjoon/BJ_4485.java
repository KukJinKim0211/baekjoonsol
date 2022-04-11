package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 녹색 옷을 입은 애가 젤다지?
public class BJ_4485 {
	static int N;
	static int[][] DP;
	static int[][] map;
	static int[][] del = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int count = 1;
		while ((N = Integer.parseInt(bf.readLine())) != 0) {
			DP = new int[N][N];
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					DP[i][j] = Integer.MAX_VALUE;
				}
			}
			BFS();
			sb.append("Problem " + count++ + ": " + DP[N-1][N-1] + "\n");
		}
		System.out.println(sb);
	}
	public static void BFS() {
		PriorityQueue<Point> que = new PriorityQueue<>();
		que.add(new Point(0, 0, map[0][0]));
		DP[0][0] = map[0][0];
		while (!que.isEmpty()) {
			Point point = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int dx = point.x + del[i][0];
				int dy = point.y + del[i][1];
				if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
					if (DP[dx][dy] > DP[point.x][point.y] + map[dx][dy]) {
						DP[dx][dy] = DP[point.x][point.y] + map[dx][dy];
						que.add(new Point(dx, dy, DP[dx][dy]));
					}
				}
			}
		}
	}
	
	public static class Point implements Comparable<Point> {
		int x;
		int y;
		int move;
		public Point(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}
		@Override
		public int compareTo(Point arg0) {
			// TODO Auto-generated method stub
			return move - arg0.move;
		}
	}
}
