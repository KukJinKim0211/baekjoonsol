package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 무선 충전
public class SWEA_5644 {
	static int iResult;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int itestcase = Integer.parseInt(bf.readLine());
		for (int itest = 1; itest <= itestcase; itest++) {
			iResult = 0;
			st = new StringTokenizer(bf.readLine());
			int iMoveCnt = Integer.parseInt(st.nextToken());		// 총 이동 시간
			int iBCCnt = Integer.parseInt(st.nextToken());			// BC의 갯수
			int[] iA = new int[iMoveCnt];							// 사용자 A의 이동 방향
			int[] iAPos = new int[] { 0, 0 };						// 사용자 A의 X,Y 포지션
			int[] iB = new int[iMoveCnt];							// 사용자 B의 이동 방향
			int[] iBPos = new int[] { 9, 9 };						// 사용자 B의 X,Y 포지션
			String[][] sArray = new String[10][10];		// 10*10의 가로세로 지도
			int[][] iBCInfo = new int[iBCCnt][4];	// BC의 x,y 좌표, 범위, power
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < iMoveCnt; i++) {			// 사용자 A의 이동 정보를 읽어들임
				iA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < iMoveCnt; i++) {			// 사용자 B의 이동 정보를 읽어들임
				iB[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < iBCCnt; i++) {		// BC의 정보를 입력
				st = new StringTokenizer(bf.readLine());
				iBCInfo[i][0] = Integer.parseInt(st.nextToken()) - 1;
				iBCInfo[i][1] = Integer.parseInt(st.nextToken()) - 1;
				iBCInfo[i][2] = Integer.parseInt(st.nextToken());
				iBCInfo[i][3] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < 10; i++) {		// 10 * 10의 지도에 BC 정보 입력
				for (int j = 0; j < 10; j++) {
					for (int k = 0; k < iBCCnt; k++) {
						if (Math.abs(iBCInfo[k][0] - i) + Math.abs(iBCInfo[k][1] - j) <= iBCInfo[k][2]) {
							if (sArray[j][i] == null)
								sArray[j][i] = Integer.toString(k + 1);
							else
								sArray[j][i] += k + 1;
						}
					}
				}
			}
			boolean[] bAVisit = new boolean[iBCCnt];
			boolean[] bBVisit = new boolean[iBCCnt];
			for (int i = 0; i <= iMoveCnt; i++) {
				int iMax1 = 0;
				int iMax2 = 0;
				bAVisit = new boolean[iBCCnt];
				bBVisit = new boolean[iBCCnt];
				String str1 = sArray[iAPos[0]][iAPos[1]];
				String str2 = sArray[iBPos[0]][iBPos[1]];
				if (str1 != null) {
					for (int j = 0; j < str1.length(); j++) {
						bAVisit[(str1.charAt(j) - '0') - 1] = true;
					}
				}	
				if (str2 != null) {
					for (int j = 0; j < str2.length(); j++) {
						bBVisit[(str2.charAt(j) - '0') - 1] = true;
					}
				}
				
				for (int j = 0; j < iBCCnt; j++) {
					if (bAVisit[j] && bBVisit[j])
						continue;
					if (bAVisit[j]) 
						iMax1 = Math.max(iMax1, iBCInfo[j][3]);
					if (bBVisit[j]) 
						iMax2 = Math.max(iMax2, iBCInfo[j][3]);
				}
				for (int j = 0; j < iBCCnt; j++) {
					if (bAVisit[j] && bBVisit[j]) {
						if (iMax1 > iBCInfo[j][3] && iMax2 > iBCInfo[j][3])
							continue;
						if (iMax1 >= iMax2)
							iMax2 = iBCInfo[j][3];
						else
							iMax1 = iBCInfo[j][3];
					}
				}
				iResult += iMax1 + iMax2;
				if (i == iMoveCnt)
					break;
				if (iA[i] == 1)
					iAPos[0] -= 1;
				else if (iA[i] == 2)
					iAPos[1] += 1;
				else if (iA[i] == 3)
					iAPos[0] += 1;
				else if (iA[i] == 4)
					iAPos[1] -= 1;
				
				if (iB[i] == 1)
					iBPos[0] -= 1;
				else if (iB[i] == 2)
					iBPos[1] += 1;
				else if (iB[i] == 3)
					iBPos[0] += 1;
				else if (iB[i] == 4)
					iBPos[1] -= 1;
			} // 이동거기별 반복문 종료
			sb.append("#" + itest + " " + iResult + "\n");
		} //Test Case 종료 for
		System.out.println(sb);
	}
}
