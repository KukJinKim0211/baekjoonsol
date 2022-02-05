package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 스위치 켜고끄기
public class BJ_1244 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int[] iArray = new int[Integer.parseInt(bf.readLine())];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int iStudent = Integer.parseInt(bf.readLine());
		for (int i = 0; i < iArray.length; i++) {
			iArray[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < iStudent; i++) {
			st = new StringTokenizer(bf.readLine());
			int iSex = Integer.parseInt(st.nextToken());		// 1: 남자  2: 여자
			int iValue = Integer.parseInt(st.nextToken());
			if (iSex == 2)
				iValue--;
			if (iSex == 1) {
				for (int j = 0; j < iArray.length; j++) { 
					if ((j + 1) % iValue == 0)
						iArray[j] = iArray[j] == 0 ? 1 : 0;
				}
			}
			else {
				int iCnt = 1;
				while (true) {
					// 배열의 범위를 벗어 날 경우 || 대칭에 실패할 경우. 이전 값 까지는 다 대칭이기 때문에 값을 변경
					if ( (iValue - iCnt < 0 || iValue + iCnt >= iArray.length) || 
						 (iArray[iValue - iCnt] != iArray[iValue + iCnt]) ) {
						for (int j = iValue - iCnt + 1; j <= iValue + iCnt - 1; j++) {
							iArray[j] = iArray[j] == 0 ? 1 : 0;
						}
						break;
					}
					iCnt++;
				}
			}
		}
		for (int i = 0; i < iArray.length; i++) {
			System.out.printf(iArray[i] + " ");
			if ((i + 1) % 20 == 0)
				System.out.println();
		}
	}
}
