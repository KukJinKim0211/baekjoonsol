package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사다리 조작
public class BJ_15684 {
	static int N;	// 세로 선의 갯수
	static int M;	// 가로로 놓을 수 있는 선의 갯수
	static int H;	// 세로선마다 가로선을 놓을 수 있는 위치의 갯수
	static int LadderCnt = -1;
	static int[][] iArray;	// 사다리 맵
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		iArray = new int[H + 1][N + 1];
		// 가로로 놓을 수 있는 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			iArray[x][y] = 1;
			iArray[x][y + 1] = 2;
		}
		
		for (int i = 0; i <= 3; i++) {
			dfs(0, i); 
			if (LadderCnt != -1) {
				System.out.println(LadderCnt);
				return;
			}
		}
		
		System.out.println("-1");
	}
	
	static void dfs(int count, int maxCount) {
		if (LadderCnt != -1)
			return;
		
		if (maxCount == count) {	// 정해진 횟수에 도달했을 경우, 사다리를 체크하여 제약조건에 맞추었는지 체크
			if (checkLadder())
				LadderCnt = count;
			return;
		}
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (iArray[i][j] != 0 || iArray[i][j + 1] != 0) continue;
				iArray[i][j] = 1;
				iArray[i][j + 1] = 2;
				dfs(count + 1, maxCount);
				iArray[i][j] = 0;
				iArray[i][j + 1] = 0;
			}
		}
	}
	
	static boolean checkLadder() {
		check = true;
		for (int i = 1; i <= N; i++) {	// 사다리의 세로 선의 케이스만큼
			int x = i;
			int y = 1;
			while (y <= H) {		// 사다리의 가로 선의 범위까지 루프
				if (iArray[y][x] == 1) 
					x++;			// 1일경우, 오른쪽으로 한칸 이동
				else if (iArray[y][x] == 2) 
					x--;	// 2일경우, 왼쪽으로 한칸 이동
				++y;	// 한칸 밑으로 이동
			}
			if (i != x) {
				check = false;
				break;
			}
		}
		
		return check;
	}
}
