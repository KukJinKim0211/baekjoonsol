package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 저수지의 물의 총 깊이 구하기
public class SWEA_7236 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int itestcase = Integer.parseInt(bf.readLine());
		int[] idelx = new int[] { -1, -1, -1, 0, 1, 1,  1,  0 };
		int[] idely = new int[] { -1,  0,  1, 1, 1, 0, -1, -1  };
		for (int itest = 1; itest <= itestcase; itest++) {
			int N = Integer.parseInt(bf.readLine());
			char[][] cArray = new char[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					cArray[i][j] = st.nextToken().charAt(0);
				}
			}
			int iCount = 0;
			int iMaxValue = 0;
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					iCount = 0;
					for (int k = 0; k < 8; k++) {
						if (cArray[i + idelx[k]][j + idely[k]] == 'W')
							iCount++;
					}
					if (iCount == 0 && cArray[i][j] == 'W')
						iCount = 1;
					iMaxValue = Math.max(iMaxValue, iCount);
				}
			}
			sb.append("#" + itest + " " + iMaxValue + "\n");
		}
		System.out.println(sb);
	}
}
