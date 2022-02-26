package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class BJ_7576 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] iArray = new int[N][M];
		int[] ideltaX = new int[] { -1, 0, 1,  0};
		int[] ideltaY = new int[] {  0, 1, 0, -1};
		Queue<int[]> que = new LinkedList<>();
		boolean bzeroCheck = false;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
				if (iArray[i][j] == 1) 
					que.add(new int[] { i, j });
				if (iArray[i][j] == 0)
					bzeroCheck = true;
			}
		}
		if (!bzeroCheck) {
			System.out.println("0");
			return;
		}
		int iCount = 0;
		while (!que.isEmpty()) {
			boolean bChanged = false;
			int quesize = que.size();
			for (int i = 0; i < quesize; i++) {
				int[] itomato = que.poll();
				for (int j = 0; j < 4; j++) {
					if (!(itomato[0] + ideltaX[j] >= 0 && itomato[0] + ideltaX[j] < N && itomato[1] + ideltaY[j] >= 0 && itomato[1] + ideltaY[j] < M))
						continue;
					if (iArray[itomato[0] + ideltaX[j]][itomato[1] + ideltaY[j]] == 0) {
						iArray[itomato[0] + ideltaX[j]][itomato[1] + ideltaY[j]] = 1;
						que.add(new int[] { itomato[0] + ideltaX[j], itomato[1] + ideltaY[j]});
						bChanged = true;
					}
				}
			}
			if (!bChanged) 
				break;
			else
				iCount++;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (iArray[i][j] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(iCount);
	}
}
