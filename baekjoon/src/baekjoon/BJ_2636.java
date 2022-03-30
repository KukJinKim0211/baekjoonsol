package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 치즈
public class BJ_2636 {
	static int N, M;
	static int iArray[][];
	static int[] delx = { 0, -1, 0, 1 };
	static int[] dely = {-1,  0, 1, 0 };
	static boolean[][] bVisit;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		iArray = new int[N][M];
		bVisit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		int cheezecount = 0;
	
		while (true) {
			DFS(0, 0);
			int Result = cheezeDie();
			if (Result != 0)
				cheezecount = Result;
			else
				break;
			count++;
		}
		System.out.println(count);
		System.out.println(cheezecount);
	}
	
	public static int cheezeDie() {
		int iResult = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bVisit[i][j] = false;
				if (iArray[i][j] == 2) {
					iArray[i][j] = 0;
					iResult++;
				}
			}
		}
		return iResult;
	}
	
	public static void DFS(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int dx = x + delx[i];
			int dy = y + dely[i];
			
			if (dx < 0 || dy < 0 || dx >= N || dy >= M)
				continue;
			
			if (!bVisit[dx][dy]) {	// 방문 안한 케이스
				bVisit[dx][dy] = true;
				if (iArray[dx][dy] == 1)
					iArray[dx][dy] = 2;
				else
					DFS(dx, dy);
			}
		}
	}
	
}
