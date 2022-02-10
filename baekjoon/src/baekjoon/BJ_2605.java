package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 줄 세우기
public class BJ_2605 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int iCount = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] iArray = new int[iCount];
		for (int i = 0; i < iCount; i++) {
			iArray[i] = i + 1;
		}
		
		for (int i = 0; i < iCount; i++) {
			int iNum = Integer.parseInt(st.nextToken());
			
			if (iNum == 0) {
				continue;
			}
			for (int j = i - iNum; j < i; j++) {
				int itemp = iArray[j];
				iArray[j] = iArray[i];
				iArray[i] = itemp;
			}
		}
		
		for (int i : iArray) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
}
