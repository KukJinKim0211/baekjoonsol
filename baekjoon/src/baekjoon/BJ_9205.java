package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 맥주 마시면서 걸어가기
public class BJ_9205 {
	static String Msg;
	static int N;
	static int[][] iArray;
	static int[] iArrive;
	static boolean[] bVisit;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(bf.readLine());	// 테스트 케이스
		for (int test = 1; test <= testcase; test++) {
			N = Integer.parseInt(bf.readLine());
			iArray = new int[N + 2][2];
			bVisit = new boolean[N + 2];
			Msg = "sad";
			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				iArray[i][0] = Integer.parseInt(st.nextToken());
				iArray[i][1] = Integer.parseInt(st.nextToken());
			}
			BFS();
			sb.append(Msg + "\n");
		}
		System.out.println(sb);
	}
	
	static void BFS() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[]{iArray[0][0], iArray[0][1]}); 
		
		iArrive = new int[] {iArray[N + 1][0], iArray[N + 1][1]};
		while (!que.isEmpty()) {
			int[] ipoint = que.poll();
			if (arriveCheck(ipoint, iArrive)) {
				Msg = "happy";
				que.clear();
				break;
			}
				
			for (int i = 1; i <= N; i++) {
				if ( !bVisit[i] && arriveCheck(ipoint, new int[] { iArray[i][0], iArray[i][1] }) ) {
					bVisit[i] = true;
					que.offer(new int[] {iArray[i][0], iArray[i][1]});
				}
			}
		}
	}
	
	static boolean arriveCheck(int[] point1, int[] point2) {
		int x = Math.abs(point1[0] - point2[0]);
		int y = Math.abs(point1[1] - point2[1]);
		if (x + y <= 1000)
			return true;
		return false;
	}
}
