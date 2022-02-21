package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암호 만들기
public class BJ_1759 {
	static int L, C;
	static char[] cArray;	// 모든 비밀번호 담기
	static char[] cData;	// 비밀번호 L개 선별해서 담기
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cArray = new char[C];
		cData = new char[L];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < C; i++) {
			cArray[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(cArray);
		combination(0, 0);
		System.out.println(sb);
	}
	
	static void combination(int idx, int iCount) {
		if (idx == L) {
			int izaum = zaumCount(cData);
			if (izaum < 1)	return;						// 자음 갯수 체크
			if (cData.length - izaum < 2)	return;		// 모음 갯수 체크
			for (int i = 0; i < cData.length; i++) {
				sb.append(cData[i]);
			}
			sb.append("\n");
			return;
		}
		
		for (int i = iCount; i < C; i++) {
			cData[idx] = cArray[i];
			combination(idx + 1, i + 1);
		}
	}
	// L개로 선별된 데이터에서 자음의 개수를 추출
	static int zaumCount(char[] cData) {
		int iResult = 0;
		for (int i = 0; i < cData.length; i++) {
			if (cData[i] == 'a' || cData[i] == 'e' || cData[i] == 'i' || cData[i] == 'o' || cData[i] == 'u')
				iResult++;
		}
		return iResult;
	}
}
