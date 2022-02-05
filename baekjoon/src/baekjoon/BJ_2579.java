package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2579 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iCount = Integer.parseInt(bf.readLine());
		int[] iArray = new int[iCount];
		
		StringTokenizer st;
		
		for (int i = 0; i < iCount; i++) {
			iArray[i] = Integer.parseInt(bf.readLine());
		}
		// 누적 연속이동층수
		int ifcount = 0;
		
		// 현재 층의 인덱스
		int ifIndex = 0;
		
		int iResult = 0;
		// 끝에서부터 처음으로 시작
		ifcount = 1;
		ifIndex = iCount - 1;
		iResult += iArray[ifIndex];
		while (true) {
			// 다음 칸이 시작점일경우, 프로그램 종료
			if (ifIndex == 0)
				break;
			
			// 다다음 칸이 시작점일 경우.
			if (ifIndex == 1) {
				if (ifcount)
			}
			// 무조건 한칸 건너 뛰어야 할 때
			if (ifcount == 2) {
				ifcount = 1;
				ifIndex -= 2;
				continue;
			}
		}
	}
}
