package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 치킨 배달
public class BJ_15686 {
	static int N, M;
	static int MinValue;
	static int[][] iArray;					// 집의 좌표를 저장
	static ArrayList<Integer[]> list;		// 치킨집의 좌표를 저장할 arraylist
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		iArray = new int[N][N];
		list = new ArrayList<Integer[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				int iNum = Integer.parseInt(st.nextToken());
				if (iNum == 2) {						// 나중에 일괄 계산을 위해 치킨집의 좌표는 배열에 저장하지 않음
					list.add(new Integer[] { i, j });	// 리스트에 치킨집의 좌표를 저장
					continue;
				}
				iArray[i][j] = iNum;
			}
		}
		MinValue = Integer.MAX_VALUE;
		combi(0, 0, new int[M], new int[M]);
		System.out.println(MinValue);
	}
	// 조합을 이용하여 치킨집의 좌표들을 담는 1차원 배열 2개를 관리
	static void combi(int iIndex, int iCount, int[] X, int[] Y) {
		if (iCount == M) {
			MinValue = Math.min(MinValue, ChickenRoad(X, Y));
			return;
		}
		if (iIndex + 1 > list.size()) 
			return;
		
		combi(iIndex + 1, iCount, X, Y);
		X[iCount] = list.get(iIndex)[0];
		Y[iCount] = list.get(iIndex)[1];
		combi(iIndex + 1, iCount + 1, X, Y);
	}
	// 인자로 받은 치킨집의 좌표로 각 집에 대한 최소 거리를 찾기
	static int ChickenRoad(int[] X, int[] Y) {
		int iNum = 0;
		int iResult = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				iNum = Integer.MAX_VALUE;
				if (iArray[i][j] == 1) {
					for (int k = 0; k < X.length; k++) {
						iNum = Math.min(iNum, Math.abs(i - X[k]) + Math.abs(j - Y[k]));
					}
					iResult += iNum;
				}
			}
		}
		return iResult;
	}
}
