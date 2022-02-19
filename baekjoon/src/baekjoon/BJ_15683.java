package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 감시
public class BJ_15683 {
	static int N, M; // 1 <= N, M <= 8
	static int iMin;
	static int wef;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] iArray = new int[N][M];
		iMin = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) { // 1: 1개 1방향  2: 2개 수평방향  3: 2개 수직방향  4: 3개 연속3방향  5: 4개 4방향
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cctvOn(iArray);
		System.out.println(iMin);
	}	
	static void cctvOn(int[][] iArray) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int[][] iclone = new int[N][M];
				iclone = arrayClone(iArray);
				if (iArray[i][j] == 0 || iArray[i][j] == 6 || iArray[i][j] == 7)
					continue;
				switch(iArray[i][j]) {
				case 1: 
					iclone = arrayClone(iArray);
					cctvOn(visionSet(iclone, 1, i, j)); 
					iclone = arrayClone(iArray);
					cctvOn(visionSet(iclone, 2, i, j)); 
					iclone = arrayClone(iArray);
					cctvOn(visionSet(iclone, 3, i, j));
					iclone = arrayClone(iArray);
					cctvOn(visionSet(iclone, 4, i, j)); 
					break;
				case 2: 
					iclone = arrayClone(iArray);
					cctvOn(visionSet(visionSet(iclone, 1, i, j), 3, i, j));
					iclone = arrayClone(iArray);
					cctvOn(visionSet(visionSet(iclone, 2, i, j), 4, i, j)); break;
				case 3: 
					iclone = arrayClone(iArray);
					cctvOn(visionSet(visionSet(iclone, 1, i, j), 2, i, j));
					iclone = arrayClone(iArray);
					cctvOn(visionSet(visionSet(iclone, 2, i, j), 3, i, j));
					iclone = arrayClone(iArray);
					cctvOn(visionSet(visionSet(iclone, 3, i, j), 4, i, j));
					iclone = arrayClone(iArray);
					cctvOn(visionSet(visionSet(iclone, 4, i, j), 1, i, j)); break;
				case 4: 
					iclone = arrayClone(iArray);
					cctvOn(visionSet(visionSet(visionSet(iclone, 1, i, j), 2, i, j), 3, i, j));
					iclone = arrayClone(iArray);
					cctvOn(visionSet(visionSet(visionSet(iclone, 2, i, j), 3, i, j), 4, i, j));
					iclone = arrayClone(iArray);
					cctvOn(visionSet(visionSet(visionSet(iclone, 3, i, j), 4, i, j), 1, i, j));
					iclone = arrayClone(iArray);
					cctvOn(visionSet(visionSet(visionSet(iclone, 4, i, j), 3, i, j), 1, i, j)); break;
				case 5: 
					iclone = arrayClone(iArray);
					cctvOn(visionSet(visionSet(visionSet(visionSet(iclone, 1, i, j), 2, i, j), 3, i, j), 4, i, j));break;
				}
				return;
			}
		}
		int iCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(iArray[i][j] + " ");
				if (iArray[i][j] == 0)
					iCount++;
			}
			System.out.println();
		}
		System.out.println();
		iMin = Math.min(iCount, iMin);
	}
	static int[][] visionSet(int[][] iArray, int iIndex, int X, int Y) {
		// 우측방향 싹다지우기
		if (iIndex == 1) {
			for (int i = Y; i < M; i++) {
				System.out.println("dlrjxka");
				if (iArray[X][i] == 6)
					break;
					
				iArray[X][i] = 7;
			}
		}
		// 아래방향 싹다지우기
		else if (iIndex == 2) {
			for (int i = X; i < N; i++) {
				if (iArray[i][Y] == 6)
					break;
					
				iArray[i][Y] = 7;
			}
		}
		// 왼쪽방향 싹다지우기
		else if (iIndex == 3) {
			for (int i = Y; i < M; i++) {
				if (iArray[X][i] == 6)
					break;
					
				iArray[X][i] = 7;
			}
		}
		// 위쪽방향 싹다지우기
		else if (iIndex == 4) {
			for (int i = X; i < N; i++) {
				if (iArray[i][Y] == 6)
					break;
					
				iArray[i][Y] = 7;
			}
		}
		cctvOn(iArray);
		return iArray;
	}
	static int[][] arrayClone(int[][] iArray){
		int[][] iclone = new int[N][M];
		for (int i = 0; i < N; i++) {
			iclone[i] = iArray[i].clone();
		}
		return iclone;
	}
}
