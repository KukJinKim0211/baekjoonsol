package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이1
public class BJ_10163 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 색종이의 갯수
		int iN = Integer.parseInt(st.nextToken());
		// 색종이의 갯수, 색종이의 시작점X, 시작점Y, 폭, 길이
		int[][] iArray = new int[iN][4];
		// 가로 세로 최대 1001칸의 격자평면
		int[][] iplace = new int[1001][1001];
		// 색종이 정보 저장
		for (int i = 0; i < iN; i++) {
			st = new StringTokenizer(bf.readLine());
			iArray[i][0] = Integer.parseInt(st.nextToken());
			iArray[i][1] = Integer.parseInt(st.nextToken());
			iArray[i][2] = Integer.parseInt(st.nextToken());
			iArray[i][3] = Integer.parseInt(st.nextToken());
		}
		
		// 색종이의 둘레를 담을 정수형 배열
		int[] iNum = new int[iN];
		int iSum = 0;
		
		
		for (int N = iN - 1; N >= 0; N--) {	// 맨 뒤에 입력된 색종이부터 검사. 겹침 방지
			
			for (int i = iArray[N][0]; i < iArray[N][0] + iArray[N][2]; i++) {
				for (int j = iArray[N][1]; j < iArray[N][1] + iArray[N][3]; j++) {
					// 현재 위치에 색종이가 놓여졌는지 체크 없을 시, 값추가
					if (iplace[i][j] == 0)
						iNum[N]++;
					// 현재 위치에 색종이가 놓였다고 저장
					iplace[i][j] = 1;
				}
			}
			// 색종이가 놓이지 않았을 경우에 대한 체크를 위함
			iSum += iNum[N];
		}
		// 색종이가 놓여진 평면이 없어서 값이 추가되지 않았을 경우, 0 리턴
		if (iSum == 0) {
			System.out.println(0);
			return;
		}
		
		for (int i : iNum) {
			System.out.println(i);
		}
	}
}
