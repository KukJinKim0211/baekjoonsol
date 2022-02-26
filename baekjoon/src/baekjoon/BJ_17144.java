package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미세먼지 안녕!
public class BJ_17144 {
	static int R, C, T;
	static int Result;
	static int AirCleaner = -1;		// 공기청정기의 x 위치값 저장
	static int[] idelX = new int[] { -1, 0, 1,  0 };
	static int[] idelY = new int[] {  0, 1, 0, -1 };
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		int[][] iArray = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < C; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
				if (iArray[i][j] == -1 && AirCleaner == -1)		// 첫 공기청정기의 위치값을 저장
					AirCleaner = i;
			}
		}
		runAirCleaner(iArray, T);
		System.out.println(Result);
	}
	
	static void runAirCleaner(int[][] iArray, int iCount) {
		if (iCount == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0;j < C; j++) {
					if (iArray[i][j] > 0)
						Result += iArray[i][j];
				}
			}
			return;
		}
		
		Queue<int[]> que = new LinkedList<>();
		// 미세먼지 확산 파트
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if ((i == AirCleaner || i == AirCleaner + 1) && j == 0)	// 공기 청정기가 있는 Part
					continue;
				if (iArray[i][j] > 0 && iArray[i][j] / 5 >= 1) {	// 공기를 확산시킬 수 있는 공기일 시,
					int iAirCount = 0;	// 공기 확산 카운트
					for (int k = 0; k < 4; k++) {		// 델다 탐색 part
						int dx = i + idelX[k];
						int dy = j + idelY[k];
						if (dx >= 0 && dx < R && dy >= 0 && dy < C) {	// 배열 크기 제약조건
							if ( !((dx == AirCleaner || dx == AirCleaner + 1) && dy == 0) ) {
								que.add(new int[] { dx, dy, iArray[i][j] / 5 });		// 확산되어 더해져야되는 값 큐에 저장
								iAirCount++;	
							}
						}
					}	// for k part 종료
					if (iAirCount != 0) {	// 공기 확산 시
						que.add(new int[] { i, j, -(iArray[i][j] / 5 * iAirCount) });	// 확산되어 빠져야되는 본체 값 큐에 저장
					}
				}	// if 공기확산 체크 part 
			}	// for j part 종료
		}	// for i part 종료
		
		// 미세먼지 확산 관리 큐들을 배열에 적용
		while (!que.isEmpty()) {
			int[] iData = que.poll();
			iArray[iData[0]][iData[1]] += iData[2];
			if (iData[0] == AirCleaner + 1 && iData[1] == 0)
				System.out.println("여기");
		}
		int ACTop = AirCleaner;
		int ACBot = AirCleaner + 1;
		
		// 윗 먼지 회전 Part
		for (int i = ACTop - 1; i > 0; i--) {	// 아래로 당기기
			iArray[i][0] = iArray[i - 1][0];
		}
		for (int i = 0; i < C - 1; i++) {		// 왼쪽으로 당기기
			iArray[0][i] = iArray[0][i + 1];
		}
		for (int i = 0; i < ACTop; i++) {		// 위로 당기기
			iArray[i][C - 1] = iArray[i + 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {		// 오른쪽으로 당기기
			iArray[ACTop][i] = iArray[ACTop][i - 1];
		}
		iArray[ACTop][1] = 0;	// 공기청정기에서 나오는 바람
		
		// 아랫 먼지 회전 Part
		for (int i = ACBot + 1; i < R - 1; i++) {	// 위로 당기기
			iArray[i][0] = iArray[i + 1][0];
		}
		for (int i = 0; i < C - 1; i++) {		// 왼쪽으로 당기기
			iArray[R - 1][i] = iArray[R - 1][i + 1];
		}
		for (int i = R - 1; i > ACBot; i--) {	// 아래로 당기기
			iArray[i][C - 1] = iArray[i - 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {		// 오른쪽으로 당기기
			iArray[ACBot][i] = iArray[ACBot][i - 1];
		}
		iArray[ACBot][1] = 0;	// 공기청정기에서 나오는 바람
		
		runAirCleaner(iArray, iCount - 1);
	}
}
