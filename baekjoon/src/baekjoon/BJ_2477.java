package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참외밭
public class BJ_2477 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int iCount = Integer.parseInt(bf.readLine());
		int[] iArray = new int[6];
		for (int i = 0; i < 6; i++) {
			iArray[i] = Integer.parseInt(bf.readLine().split(" ")[1]);
		}
		
		int iSum = 0;
		for (int i = 0; i < 6; i++) {
			iSum += iArray[i];
		}
		int inubi = 0;
		int iMinus = 0;
		int[] iArray2 = new int[12];
		int k= 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				iArray2[k++] = iArray[j];
			}
		}

		for (int i = 0; i < iArray2.length - 1; i++) {
			if (iArray2[i] + iArray2[i + 1] == iSum / 2) {
				inubi = iArray2[i] * iArray2[i + 1];
				iMinus = iArray2[i + 3] * iArray2[i + 4];
				break;
			}
		}
		
		System.out.println((inubi - iMinus) * iCount);
	}
}
