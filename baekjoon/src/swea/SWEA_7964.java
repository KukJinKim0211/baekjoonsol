package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부먹 왕국의 차원 관문
public class SWEA_7964 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int itestcase = Integer.parseInt(bf.readLine());
		for (int itest = 1; itest <= itestcase; itest++) {
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int iDestroyCity = 0;
			int iDoor = 0;
			int iCurValue = 0;
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				iCurValue = Integer.parseInt(st.nextToken());
				if (iCurValue == 0 && iDestroyCity == D - 1) {
					iDoor++;
					iDestroyCity = 0;
					continue;
				}
				if (iCurValue == 1)
					iDestroyCity = 0;
				else if (iCurValue == 0)
					iDestroyCity++;
			}
			sb.append("#" + itest + " " + iDoor + "\n");
		}
		System.out.println(sb);
	}

}
