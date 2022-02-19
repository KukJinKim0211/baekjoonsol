package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이2
public class BJ_2567 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int iCount = Integer.parseInt(bf.readLine());
		int[][] iArray = new int[101][101];
		for (int i = 0; i < iCount; i++) {
			st = new StringTokenizer(bf.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			for (int j = X; j < X + 10;j++) {
				for (int k = Y; k < Y + 10; k++) {
					iArray[j][k] = 1;
				}
			}
		}
		
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,1,-1};
		int nx = 0;
		int ny = 0;
		int iResult = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if(iArray[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						nx = i + dx[k];
						ny = j + dy[k];
						
						if(nx >= 1 && nx <= 100 && ny >= 1 && ny <= 100 && iArray[nx][ny] == 0)
							iResult++;
						else if(nx<1 || nx>100 || ny<1 || ny>100)
							iResult++;
					}
				}
			}
		}
		System.out.println(iResult);
	}
}
