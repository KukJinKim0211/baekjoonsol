package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//햄버거 다이어트
public class SWEA_5215 {
	public static int iMaxPoint = 0;
	public static int[][] iMenu;
	static int aaaa;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int itestcase = Integer.parseInt(bf.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 바깥 TestCase
		for (int itest = 1; itest <= itestcase; itest++) {
			iMaxPoint = 0;
			st = new StringTokenizer(bf.readLine());
			
			int iEleCount = Integer.parseInt(st.nextToken());		// 재료 갯수
			int iKcal = Integer.parseInt(st.nextToken());		// 제한 칼로리
			iMenu = new int[iEleCount][2];		// 0:점수 1:칼로리를 저장하는 정수형 2차원배열
			for (int i = 0; i < iEleCount; i++) {
				st = new StringTokenizer(bf.readLine());
				iMenu[i][0] = Integer.parseInt(st.nextToken());
				iMenu[i][1] = Integer.parseInt(st.nextToken());
			}
			hamburger(iKcal, 0, 0, 0);
			sb.append("#" + itest + " " + iMaxPoint + "\n");
			System.out.println(aaaa);
			
		}// 바깥 TestCase 종료
		System.out.println(sb);
	}
	
	// 입력값: iKcalCut : 제한 칼로리  iKcal : 현재 칼로리  iPoint : 현재 점수  iCount : 인덱스
	public static void hamburger(int iKcalCut, int iKcal, int iPoint, int iCount) {
		if (iKcalCut < iKcal)
			return;
		if (iCount == iMenu.length) {
			iMaxPoint = Math.max(iMaxPoint, iPoint);
			return;
		}
		
		hamburger(iKcalCut, iKcal + iMenu[iCount][1], iPoint + iMenu[iCount][0], iCount + 1);
		hamburger(iKcalCut, iKcal, iPoint, iCount + 1);
	}
}
