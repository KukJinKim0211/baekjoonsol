package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// Flatten
public class SWEA_1208 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] iArray = new int[100];
		for (int icase = 1; icase <= 10; icase++) {
			int iCount = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < 100; i++) {
				iArray[i] = Integer.parseInt(st.nextToken());
			}
			// 입력받은 횟수만큼
			while (iCount > 0) {
				Arrays.sort(iArray);
				if (iArray[0] == iArray[99])
					break;
				
				iArray[0]++;
				iArray[99]--;
				iCount--;
			} // 입력받은 횟수만큼 while문 종료
			Arrays.sort(iArray);
			System.out.println("#" + icase + " " + (iArray[99] - iArray[0]));
		} // case for문 종료
	}
}
