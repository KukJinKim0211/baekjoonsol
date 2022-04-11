package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 말이 되고픈 원숭이
public class BJ_1600 {
	static int K, W, H, minCount;
	static int[][] iArray;
	static boolean[][][] bVisit;
	static int[][] monkeyMove = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	static int[][] horseMove = { {-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2} }; 
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		iArray = new int[H][W];
		bVisit = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < W; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(BFS());
	}
	
	public static int BFS() {
		Queue<Monkey> que = new LinkedList<>();
		que.offer(new Monkey(0, 0, 0, 0));
		bVisit[0][0][0] = true;
		while (!que.isEmpty()) {
			Monkey monkey = que.poll();
			
			if (monkey.x == H - 1 && monkey.y == W - 1)
				return monkey.count;
			
			for (int i = 0; i < 4; i++) {
				int dx = monkey.x + monkeyMove[i][0];
				int dy = monkey.y + monkeyMove[i][1];
				
				if (dx >= 0 && dx < H && dy >= 0 && dy < W && !bVisit[dx][dy][monkey.k] && iArray[dx][dy] == 0) {
					bVisit[dx][dy][monkey.k] = true; 
					que.offer(new Monkey(dx, dy, monkey.k, monkey.count + 1));
				}
			}
			
			if (monkey.k == K) continue;
			
			for (int i = 0; i < 8; i++) {
				int dx = monkey.x + horseMove[i][0];
				int dy = monkey.y + horseMove[i][1];
				if (dx >= 0 && dx < H && dy >= 0 && dy < W && !bVisit[dx][dy][monkey.k + 1] && iArray[dx][dy] == 0) {
					bVisit[dx][dy][monkey.k + 1] = true; 
					que.offer(new Monkey(dx, dy, monkey.k + 1, monkey.count + 1));
				}
			}
		}
		
		return -1;
	}
	
	public static class Monkey {
		int x;
		int y;
		int k;
		int count;
		public Monkey(int x, int y, int k, int count) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.count = count;
		}
	}
}
