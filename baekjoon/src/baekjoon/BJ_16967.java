package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열 복원하기
public class BJ_16967 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int addX = Integer.parseInt(st.nextToken());
		int addY = Integer.parseInt(st.nextToken());
		int[][] ifirst = new int[N][M];
		int[][] iArray = new int[N + addX][M + addY];
		for (int i = 0; i < iArray.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < iArray[i].length; j++) {
				iArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i - addX >= 0 && j - addY >= 0)
					ifirst[i][j] = iArray[i][j] - ifirst[i - addX][j - addY];
				else
					ifirst[i][j] = iArray[i][j];
			}
		}
		
		for(int[] i2 : ifirst) {
			for (int i1:i2) {
				System.out.print(i1 + " ");
			}
			System.out.println();
		}
	}
}
