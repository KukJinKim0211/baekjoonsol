package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Magnetic
public class SWEA_1220 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int itest = 1; itest <= 10; itest++) {
			int N = Integer.parseInt(bf.readLine());
			int[][] iArray = new int[N][N];
			int[] ifirstNS = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					iArray[i][j] = Integer.parseInt(st.nextToken());
					if (iArray[i][j] != 0 && ifirstNS[j] == 0)
						ifirstNS[j] = iArray[i][j];
				}
			}
			int iCount = 0;
			for (int i = 0; i < N; i++) {
				int iN = 0;
				for (int j = 0; j < N; j++) {
					if (iArray[j][i] == 1 && iN == 0)
						iN = 1;
					else if (iArray[j][i] == 2 && iN == 1) {
						iCount++;
						iN = 0;
					}
					else if (iArray[j][i] == 2 && iN == 0)
						continue;
					//else if (iArray[j][i] == 1 && iN == 1)
				}
			}
			sb.append("#" + itest + " " + iCount + "\n");
		}
		System.out.println(sb);
	}
}
