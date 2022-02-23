package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 영준이의 카드게임
public class BJ_4047 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int itestcase = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for (int itest = 1; itest <= itestcase; itest++) {
			int[][] SDHC = new int[4][13];
			int[] iResult = new int[4];
			String str = bf.readLine();
			for (int i = 0; i < str.length() / 3; i++) {
				char cData1 = str.charAt(i * 3);
				char cData2 = str.charAt(i * 3 + 1);
				char cData3 = str.charAt(i * 3 + 2);
				if (cData1 == 'S') {
					if (cData2 == '0')
						SDHC[0][(cData3 - '0') - 1]++;
					else
						SDHC[0][(cData3  - '0') + 9]++;
				} else if (cData1 == 'D') {
					if (cData2 == '0')
						SDHC[1][(cData3 - '0') - 1]++;
					else
						SDHC[1][(cData3  - '0') + 9]++;
				} else if (cData1 == 'H') {
					if (cData2 == '0')
						SDHC[2][(cData3 - '0') - 1]++;
					else
						SDHC[2][(cData3  - '0') + 9]++;
				} else if (cData1 == 'C') {
					if (cData2 == '0')
						SDHC[3][(cData3 - '0') - 1]++;
					else
						SDHC[3][(cData3  - '0') + 9]++;
				}
			}
			boolean bBreak = false;
			for (int i = 0; i < 4; i++) {
				if (bBreak)
					break;
				for (int j = 0; j < 13; j++) {
					if (SDHC[i][j] == 2) {
						bBreak = true;
						break;
					}
					if (SDHC[i][j] == 1)
						iResult[i]++;
				}
			}
			sb.append("#" + itest + " ");
			if (bBreak)
				sb.append("ERROR\n");
			else
				sb.append((13 - iResult[0]) + " " + (13 - iResult[1]) + " " + 
						  (13 - iResult[2]) + " " + (13 - iResult[3]) + "\n");
		}
		System.out.println(sb);
	}
}
