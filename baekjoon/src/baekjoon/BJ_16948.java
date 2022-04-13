package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 데스 나이트
public class BJ_16948 {
	static int N;
	static int r1, r2, c1, c2;
	static int[][][] iArray;
	static int[] delx = { -2, -2, 0, 0, 2, 2 };
	static int[] dely = { -1, 1, -2, 2, -1, 1 };
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		iArray = new int[N][N][1];
		bfs();
		System.out.println(iArray[r2][c2][0] == 0 ? -1 : iArray[r2][c2][0]);
	}
	
	static void bfs() {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(r1, c1, 0));
		
		while (!que.isEmpty()) {
			Point point = que.poll();
			
			for (int i = 0; i < 6; i++) {
				int dx = point.x + delx[i];
				int dy = point.y + dely[i];
				
				if (dx < 0 || dx >= N || dy < 0 || dy >= N) continue;	// 배열범위 벗어날 시
				if (iArray[dx][dy][0] == 0 || iArray[dx][dy][0] > point.count + 1) {
					iArray[dx][dy][0] = point.count + 1;
					que.offer(new Point(dx, dy, point.count + 1));
				}
			}
		}
	}
	
	static class Point {
		int x;
		int y;
		int count;
		
		public Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
