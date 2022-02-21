package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// contact
public class SWEA_1238 {
	static int iSize;
	static int iStart;
	static int iMax;
	static int[][] iArray;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int itest = 1; itest <= 10; itest++) {
			st = new StringTokenizer(bf.readLine());
			iSize = Integer.parseInt(st.nextToken());
			iStart = Integer.parseInt(st.nextToken());
			iArray = new int[101][101];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < iSize / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				iArray[from][to] = 1;
			}
			bfs(iStart);
			sb.append("#" + itest + " " + iMax + "\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int iStart) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[101];
		queue.offer(iStart);
		visited[iStart] = true;
		int iMaxValue = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			iMaxValue = -1;

			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				iMaxValue = iMaxValue < current ? current : iMaxValue;

				for (int j = 1; j < iArray[current].length; j++) {
					if (iArray[current][j] == 1 && !visited[j]) {
						queue.offer(j);
						visited[j] = true;
					}
				}
			}
			iMax = iMaxValue;
		}
	}
}
