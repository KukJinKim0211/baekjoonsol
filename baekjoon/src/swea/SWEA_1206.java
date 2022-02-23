package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// View
public class SWEA_1206 {
	public static void main(String[] args) throws Exception {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			StringTokenizer st;
			for (int itest = 1; itest <= 10; itest++) {
				int N = Integer.parseInt(bf.readLine());
				int[] iArray = new int[N];
				int iResult = 0;
				int iTotal = 0;
				int iCount = 0;
				st = new StringTokenizer(bf.readLine());
				for (int i = 0; i < N; i++) {
					iArray[i] = Integer.parseInt(st.nextToken());
				}
				
				for (int i = 0; i < N; i++) {
					iTotal = 0;
					iCount = 0;
					int i1 = 0;
					int i2 = 0;
					int i3 = 0;
					int i4 = 0;
					if (i - 2 >= 0) {
						iTotal++;
						if (iArray[i] > iArray[i - 2])
							iCount++;
					}
					if (i - 1 >= 0) {
						iTotal++;
						if (iArray[i] > iArray[i - 1])
							iCount++;
					}
					if (i + 1 < N) {
						iTotal++;
						if (iArray[i] > iArray[i + 1])
							iCount++;
					}
					if (i + 2 < N) {
						iTotal++;
						if (iArray[i] > iArray[i + 2])
							iCount++;
					}
					if (iTotal == iCount) {
						if (i - 2 >= 0)
							i1 = iArray[i - 2];
						else
							i1 = 0;
						if (i - 1 >= 0)
							i2 = iArray[i - 1];
						else
							i2 = 0;
						if (i + 1 < N)
							i3 = iArray[i + 1];
						else
							i3 = 0;
						if (i + 2 < N)
							i4 = iArray[i + 2];
						else
							i4 = 0;
						int i5 = Math.max(i1, i2);
						int i6 = Math.max(i3, i4);
						iResult += iArray[i] - Math.max(i5, i6);
					}
				}
				sb.append("#" + itest + " " + iResult + "\n");
			}	// Test Case 반복문 종료
		System.out.println(sb);
	}
}
