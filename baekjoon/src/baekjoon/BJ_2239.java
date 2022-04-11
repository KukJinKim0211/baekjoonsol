package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 스도쿠
public class BJ_2239 {
	static int[][] iArray;
	static boolean bEnd;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		iArray = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			String str = bf.readLine();
			for (int j = 0; j < 9; j++) {
				iArray[i][j] = str.charAt(j) - '0';
			}
		}
		dfs(0);
		
		for (int[] i2 : iArray) {
			for (int i1 : i2) {
				System.out.print(i1);
			}
			System.out.println();
		}
	}
	
	static void dfs(int depth) {
		if (depth == 81) {
			bEnd = true;
			return;
		}
		
		int r = depth / 9;
		int c = depth % 9;
		
		if (iArray[r][c] != 0)
			dfs(depth + 1);
		else {
			for (int i = 1; i < 10; i++) {
				if (!check(r, c, i)) continue;
				iArray[r][c] = i;
				dfs(depth + 1);
				
				if (bEnd) return;
				iArray[r][c] = 0;
			}
		}
			
	}
	
	static boolean check(int r, int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (iArray[i][c] == n || iArray[r][i] == n)
				return false;
		}
		
		int rr = (r / 3) * 3;
		int cc = c - c % 3;
		
		for (int i = rr; i < rr + 3; i++) {
			for (int j = cc; j < cc + 3; j++) {
				if (iArray[i][j] == n)
					return false;
			}
		}
		
		return true;
	}
}
