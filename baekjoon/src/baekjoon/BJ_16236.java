package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 아기상어 (미완)
public class BJ_16236 {
	static int N;							// 배열의 길이
	static int targetX, targetY; 			// 다음 타겟 물고기 좌표
	static int SharkX, SharkY, SharkSize, SharkEat;	// 아기 상어의 현재 좌표, 아기상어의 현재 사이즈, 아기상어 먹은횟
	static int SharkMoveCount;				// 상어 움직이는 카운트
	static int bfsMoveMin, bfsMove;			// bfs에서 돌아가는 move 최소값
	static int[][] iArray;	// 배열
	static boolean[][] bVisit;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		iArray = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
				if (iArray[i][j] == 9) {
					SharkX = i;
					SharkY = j;
				}
			}
		}
		SharkSize = 2;
		babySharkDururuDuru();
		System.out.println(SharkMoveCount);
	}
	
	static void babySharkDururuDuru() {
		if (!findFish(SharkX, SharkY))
			return;
		
		bfsMoveMin = Integer.MAX_VALUE;
		bVisit = new boolean[N][N];
		bfs(SharkX, SharkY, targetX, targetY, 0);
		for (int[] i2 : iArray) {
			for (int i1 : i2) {
				System.out.print(i1 + " ");
			}
			System.out.println();
		}
		System.out.println("tarX=" + targetX + " tarY=" + targetY + " SharkSize=" + SharkSize);
		System.out.println(SharkMoveCount + " " + bfsMoveMin);
		System.out.println();
			
		SharkMoveCount += bfsMoveMin;
		iArray[SharkX][SharkY] = 0;
		SharkX = targetX;
		SharkY = targetY;
		iArray[SharkX][SharkY] = 0;
		if (targetX == SharkX && targetY == SharkY) {	// 상어가 타겟물고기의 좌표에 도달 시
			SharkEat++;
			if (SharkEat == SharkSize) {
				SharkSize++;
				SharkEat = 0;
			}
		}
		babySharkDururuDuru();
	}
	
	static void bfs(int X, int Y, int tarX, int tarY, int iCount) {
		if (X == tarX && Y == tarY) {
			bfsMoveMin = Math.min(bfsMoveMin, iCount);
			return;
		}
		if (X - 1 >= 0 && iArray[X - 1][Y] <= SharkSize && !bVisit[X - 1][Y]) { // 위쪽 이동 
			bVisit[X - 1][Y] = true;
			bfs(X - 1, Y, tarX, tarY, iCount + 1);
			bVisit[X - 1][Y] = false;
		}
		if (Y - 1 >= 0 && iArray[X][Y - 1] <= SharkSize && !bVisit[X][Y - 1]) { // 왼쪽 이동
			bVisit[X][Y - 1] = true;
			bfs(X, Y - 1, tarX, tarY, iCount + 1);
			bVisit[X][Y - 1] = false;
		}
		if (X + 1 < N && iArray[X + 1][Y] <= SharkSize && !bVisit[X + 1][Y]) { // 아래쪽 이동
			bVisit[X + 1][Y] = true;
			bfs(X + 1, Y, tarX, tarY, iCount + 1);
			bVisit[X + 1][Y] = false;
		}
		if (Y + 1 < N && iArray[X][Y + 1] <= SharkSize && !bVisit[X][Y + 1]) { // 오른쪽 이동
			bVisit[X][Y + 1] = true;
			bfs(X, Y + 1, tarX, tarY, iCount + 1);
			bVisit[X][Y + 1] = false;
		}
	}
	
	static boolean findFish(int X, int Y) {
		boolean foundFish = false;
		int iMaxLength = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (iArray[i][j] != 0 && iArray[i][j] != 9 && iArray[i][j] < SharkSize) {
					int iLength = Math.abs(X - i) + Math.abs(Y - j);
					if (iMaxLength > iLength) {
						iMaxLength = iLength;
						targetX = i;
						targetY = j;
						foundFish = true;
					}
				}
			}
		}
		if (!foundFish) 
			return false;
		return true;
	}
}
