package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스도쿠 검증
public class SWEA_1974 {
	static int[][] iArray;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int itestcase = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int itest = 1; itest <= itestcase; itest++) {
			iArray = new int[9][9];
			// 스도쿠 정보 입력
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 9; j++) {
					iArray[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (sdokuCheck())
				sb.append("#" + itest + " 1\n");
			else
				sb.append("#" + itest + " 0\n");
		}	// Test Case For문 종료
		System.out.println(sb);
	}
	
	static boolean sdokuCheck() {
		// 스도쿠의 숫자 여부
		boolean[][] bCheck = new boolean[9][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				bCheck[i][iArray[i][j] - 1] = true;
			}
		}
		
		// 모든 칸에 1 ~ 9가 균등하게 들어갔는지 체크
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!bCheck[i][j])
					return false;
			}
		}
		int iSum = 0;
		// 가로 1~9행 체크
		for (int i = 0; i < 9; i++) {
			iSum = 0;
			for (int j = 0; j < 9; j++) {
				iSum += iArray[i][j];
			}
			if (iSum != 45)
				return false;
		}
	
		// 세로 1~9행 체크
		for (int i = 0; i < 9; i++) {
			iSum = 0;
			for (int j = 0; j < 9; j++) {
				iSum += iArray[j][i];
			}
			if (iSum != 45)
				return false;
		}
		
		// 중간의 정사각형 합 체크
		if (!squareCheck(0, 0))
			return false;
		if (!squareCheck(0, 3))
			return false;
		if (!squareCheck(0, 6))
			return false;
		if (!squareCheck(3, 0))
			return false;
		if (!squareCheck(3, 3))
			return false;
		if (!squareCheck(3, 6))
			return false;
		if (!squareCheck(6, 0))
			return false;
		if (!squareCheck(6, 3))
			return false;
		if (!squareCheck(6, 6))
			return false;
		
		return true;
	}
	
	static boolean squareCheck(int startX, int startY) {
		int iSum = 0;
		for (int i = startX; i < startX + 3; i++) {
			for (int j = startY; j < startY + 3; j++) {
				iSum += iArray[i][j];
			}
		}
		
		if (iSum != 45)
			return false;
		
		return true;
	}
}
