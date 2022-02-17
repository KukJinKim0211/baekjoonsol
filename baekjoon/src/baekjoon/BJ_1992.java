package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 쿼드 트리
public class BJ_1992 {
	static int[][] iArray;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iSize = Integer.parseInt(bf.readLine());
		iArray = new int[iSize][iSize];
		for (int i = 0; i < iSize; i++) {
			String str = bf.readLine();
			for (int j = 0; j < iSize; j++) {
				iArray[i][j] = str.charAt(j) - '0';
			}
		}
		sb.append("(");
		find(0, 0, iSize, iSize);
		sb.append(")");
		System.out.println(sb);
	}
	
	static void find(int firstX, int firstY, int lastX, int lastY) {
		if (firstX == lastX && firstY == lastY)
			return;
		int iSum = 0;
		// 좌상 사분면 검사
		for (int i = firstX; i < (firstX + lastX) / 2; i++) {
			for (int j = firstY; j < (firstY + lastY) / 2; j++) {
				iSum += iArray[i][j];
			}
		}
		if (iSum == 0)
			sb.append("0");
		else if (iSum == (lastX - firstX) * (lastY - firstY))
			sb.append("1");
		else {
			find(firstX, firstY, (firstX + lastX) / 2, (firstY + lastY) / 2);
		}

		iSum = 0;
		// 우상 사분면 검사
		for (int i = firstX; i < lastX / 2; i++) {
			for (int j = (firstY + lastY) / 2; j < lastY; j++) {
				iSum += iArray[i][j];
			}
		}
		if (iSum == 0)
			sb.append("0");
		else if (iSum == (lastX - firstX) * (lastY - firstY))
			sb.append("1");
		else {
			find(firstX, (firstY + lastY) / 2, lastX / 2, lastY);
		}

		iSum = 0;
		// 좌하 사분면 검사
		for (int i = (firstX + lastX) / 2; i < lastX; i++) {
			for (int j = firstY; j < lastY / 2; j++) {
				iSum += iArray[i][j];
			}
		}
		if (iSum == 0)
			sb.append("0");
		else if (iSum == (lastX - firstX) * (lastY - firstY))
			sb.append("1");
		else {
			find((firstX + lastX) / 2, firstY, lastX, lastY / 2);
		}
		
		iSum = 0;
		// 우하 사분면 검사
		for (int i = (firstX + lastX) / 2; i < lastX; i++) {
			for (int j = (firstY + lastY) / 2; j < lastY; j++) {
				iSum += iArray[i][j];
			}
		}
		if (iSum == 0)
			sb.append("0");
		else if (iSum == (lastX - firstX) * (lastY - firstY))
			sb.append("1");
		else {
			find((firstX + lastX) / 2, (firstY + lastY) / 2, lastX, lastY);
		}
	}
}
