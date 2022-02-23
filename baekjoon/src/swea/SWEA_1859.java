package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백만 장자 프로젝트
public class SWEA_1859 {
	static int MaxValue;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int itestcase = Integer.parseInt(bf.readLine());
		for (int itest = 1; itest <= itestcase; itest++) {
			int N = Integer.parseInt(bf.readLine());
			int[] iArray = new int[N];
			int iMax = 0;
			long Result = 0;
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				iArray[i] = Integer.parseInt(st.nextToken());
			}
			
			iMax = iArray[N - 1];
			for (int i = N - 1; i > -1; i--) {
				if (iMax == iArray[i])
					continue;
				else if (iMax > iArray[i])
					Result += (long)iMax - (long)iArray[i];
				else
					iMax = iArray[i];
				
			}
			sb.append("#" + itest + " " + Result + "\n");
		}
		System.out.println(sb);
	}
}
