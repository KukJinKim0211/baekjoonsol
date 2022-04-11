package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 탈주범 검거
public class SWEA_1953 {
	static int[][] iArray;
	static int[][] iRun;
	static int N, M;
	static int iCount;	// 도주로 갯수 체크
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int itestcase = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		// 7가지 파이프의 케이스에 대한 delta값
		int[][] pipe1 = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };	// 상, 우, 하, 
		int[][] pipe2 = { {-1, 0}, {1, 0} };	// 상, 하
		int[][] pipe3 = { {0, 1}, {0, -1} };	// 우, 좌
		int[][] pipe4 = { {-1, 0}, {0, 1} };	// 상, 우
		int[][] pipe5 = { {0, 1}, {1, 0} };		// 우, 하
		int[][] pipe6 = { {1, 0}, {0, -1} };	// 하, 좌
		int[][] pipe7 = { {-1, 0}, {0, -1} };	// 상, 좌
		for (int test = 1; test <= itestcase; test++) {
			iCount = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());	// 터널 세로 크기
			M = Integer.parseInt(st.nextToken());	// 터널 가로 크기
			int R = Integer.parseInt(st.nextToken());	// 맨홀의 세로위치
			int C = Integer.parseInt(st.nextToken());	// 맨홀의 가로위치
			int L = Integer.parseInt(st.nextToken());	// 탈출 소요 시간
			iArray = new int[N][M];				// 터널 상태
			iRun = new int[N][M];				// 도주 상태
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < M; j++) {
					iArray[i][j] = Integer.parseInt(st.nextToken());
					
					// 첫번째 시간의 케이스는 미리 지정
					if (i == R && j == C) {
						iRun[i][j] = 1; 
						iCount++;
					}
				}
			}
			
			// 소요시간만큼 Loop
			for (int count = 2; count <= L; count++) {
				
				// 도주로 위치 찾기
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						
						// 현재까지 도망친 위치일 시
						if (iRun[i][j] == count - 1) {
							if (iArray[i][j] == 1) {			// 상 하 좌 우 적용
								mapSet(i, j, count, pipe1);
							} else if (iArray[i][j] == 2) {		// 상 하 적용
								mapSet(i, j, count, pipe2);
							} else if (iArray[i][j] == 3) {		// 좌 우 적용
								mapSet(i, j, count, pipe3);
							} else if (iArray[i][j] == 4) {		// 상 우 적용
								mapSet(i, j, count, pipe4);
							} else if (iArray[i][j] == 5) {		// 하 우 적용
								mapSet(i, j, count, pipe5);
							} else if (iArray[i][j] == 6) {		// 하 좌 적용
								mapSet(i, j, count, pipe6);
							} else {							// 상 좌 적용
								mapSet(i, j, count, pipe7);
							}
						}
						
					}
				} // 도주로 위치 찾기 for문 종료
			} // 소요시간만큼 loop for문 종료
			sb.append("#" + test + " " + iCount + "\n");
		}
		System.out.println(sb);
	}
	
	// 도주경로 최신화
	static void mapSet(int i, int j, int cnt, int[][] idelta) {
		for (int k = 0; k < idelta.length; k++) {
			int dx = i + idelta[k][0];
			int dy = j + idelta[k][1];
			if (dx < 0 || dx >= N || dy <0 || dy >= M) continue;	// 배열 범위 이탈 체크
			if (iRun[dx][dy] != 0) continue;						// 이미 등록된 도주경로이면 적용하지않음
			if (iArray[dx][dy] == 0) continue;
			if (iArray[i][j] == 1) {	// 상하좌우
				if (k == 0) {			// 상
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 2 && iArray[dx][dy] != 5 && iArray[dx][dy] != 6)
						continue;
				} else if (k == 1) {	// 우
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 3 && iArray[dx][dy] != 6 && iArray[dx][dy] != 7)
						continue;
				} else if (k == 2) {	// 하
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 2 && iArray[dx][dy] != 4 && iArray[dx][dy] != 7)
						continue;
				} else {				// 좌
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 3 && iArray[dx][dy] != 4 && iArray[dx][dy] != 5)
						continue;
				}
			} else if (iArray[i][j] == 2) {	// 상, 하
				if (k == 0) {		// 상
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 2 && iArray[dx][dy] != 5 && iArray[dx][dy] != 6)
						continue;
				} else {			// 하
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 2 && iArray[dx][dy] != 4 && iArray[dx][dy] != 7)
						continue;
				}
			} else if (iArray[i][j] == 3) {	// 좌, 우
				if (k == 0) {		// 우
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 3 && iArray[dx][dy] != 6 && iArray[dx][dy] != 7)
						continue;
				} else {			// 좌
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 3 && iArray[dx][dy] != 4 && iArray[dx][dy] != 5)
						continue;
				}
			} else if (iArray[i][j] == 4) { // 상, 우
				if (k == 0 ) {		// 상
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 2 && iArray[dx][dy] != 5 && iArray[dx][dy] != 6)
						continue;
				} else {			// 우
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 3 && iArray[dx][dy] != 6 && iArray[dx][dy] != 7)
						continue;
				}
			} else if (iArray[i][j] == 5) {	// 하, 우
				if (k == 0 ) {		// 우
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 3 && iArray[dx][dy] != 6 && iArray[dx][dy] != 7)
						continue;
				} else {			// 하
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 2 && iArray[dx][dy] != 4 && iArray[dx][dy] != 7)
						continue;
				}
			} else if (iArray[i][j] == 6) { // 하, 좌
				if (k == 0 ) {		// 하
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 2 && iArray[dx][dy] != 4 && iArray[dx][dy] != 7)
						continue;
				} else {			// 좌
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 3 && iArray[dx][dy] != 4 && iArray[dx][dy] != 5)
						continue;
				}
			} else {						// 상, 좌
				if (k == 0 ) {		// 상
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 2 && iArray[dx][dy] != 5 && iArray[dx][dy] != 6)
						continue;
				} else {			// 좌
					if (iArray[dx][dy] != 1 && iArray[dx][dy] != 3 && iArray[dx][dy] != 4 && iArray[dx][dy] != 5)
						continue;
				}
			}
			iRun[dx][dy] = cnt;
			iCount++;
		}
	}
}
