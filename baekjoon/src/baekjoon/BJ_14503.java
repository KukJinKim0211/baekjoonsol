package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로봇 청소기
public class BJ_14503 {
	static int N, M;
	static int[][] iArray;
	static int count = 0;
	static int[] ideltax = { -1, 0, 1,  0 };	// 로봇 가는 거리 계산용
	static int[] ideltay = {  0, 1, 0, -1 };	// 로봇 가는 거리 계산용
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	// 가로 길이
		M = Integer.parseInt(st.nextToken());	// 세로 길이
		iArray = new int[N][M];	// 전체 방의 상
		int[] iRobot = new int[2];		// 로봇의 가로, 세로 좌표
		int ibang = 0;					// 로봇이 바라보는 방향  0:북  1:동  2:남  3:
		st = new StringTokenizer(bf.readLine());
		iRobot[0] = Integer.parseInt(st.nextToken());	// 로봇의 가로 좌표
		iRobot[1] = Integer.parseInt(st.nextToken());	// 로봇의 세로 좌표
		ibang = Integer.parseInt(st.nextToken());		// 로봇이 바라보는 방향
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//------------ Data 입력 Part END -----------//
		clean(iRobot[0], iRobot[1], ibang);
		System.out.println(count);
	}
	static void clean(int x, int y, int direc) {
		if (iArray[x][y] == 0) {
			iArray[x][y] = 2;
			count++;
		}
		
		for(int i = 0; i < 4; i++) {
			direc = direc == 0 ? direc = 3 : direc - 1;		// 90도 왼쪽으로 방향을 회전
            int nx = x + ideltax[direc];
            int ny = y + ideltay[direc];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(iArray[nx][ny] == 0) { //벽도 아니고 이미 청소한 곳도 아니라면 청소하러 이동한다\
                    clean(nx, ny, direc);
                    return;
                }
            }
        }
        
        //반목문을 빠져 나왔단는 것은 주변에 더 이상 청소할 공간이 없다는 의미이다.
        int d = direc <= 1 ? (direc == 0 ? 2: 3) : direc - 2;	
        int nx = x + ideltax[d];//후진
        int ny = y + ideltay[d];//후진
        if(nx >= 0 && ny >= 0 && nx < N && ny < M && iArray[nx][ny] != 1) {
            clean(nx, ny, direc); //후진할 때 방향을 유지해야 한다.
        }
	}
}
