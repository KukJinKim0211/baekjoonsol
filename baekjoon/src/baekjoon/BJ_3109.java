package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빵집
public class BJ_3109 {
	static int N, M;
	static char[][] pos;
	static int result;
	static int[] move = { -1, 0, 1};
	static boolean bcheck;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pos = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			pos[i] = st.nextToken().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			bcheck = false;
			dfs(i, 0);
		}
		System.out.println(result);
	}
	
	static void dfs(int x, int y) {
		if (y + 1 == M) {
			result++;
			bcheck = true;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int iNextX = x + move[i];
			if (iNextX >= 0 && iNextX < N) {
				if (pos[iNextX][y + 1] == 'x')
					continue;
				if (bcheck)
					return;

				pos[iNextX][y + 1] = 'x';
				dfs(iNextX, y + 1);
			}
		}
	}

}
