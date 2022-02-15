package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 냉장고
public class JO_1828 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iN = Integer.parseInt(bf.readLine());
		StringTokenizer st;

		int[][] iArray = new int[iN][2];

		for (int i = 0; i < iN; i++) {
			st = new StringTokenizer(bf.readLine());
			iArray[i][0] = Integer.parseInt(st.nextToken());
			iArray[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(iArray, (o1, o2) -> {
			if (o1[1] == o2[1])
				return o1[0] - o2[0];
			else
				return o1[1] - o2[1];
		});
		int itemper = -271; // 첫 온도는 정렬한 첫번째 냉장고의 최고기온으로설정
		int irefCnt = 0; // 냉장고개수 1개부터시작

		for (int i = 0; i < iN; i++) {
			if (iArray[i][0] <= itemper && iArray[i][1] >= itemper)
				continue;
			else {
				if (i + 1 < iN) {
					if (iArray[i][1] > iArray[i + 1][0])
						itemper = iArray[i + 1][1] < iArray[i][1] ? iArray[i + 1][1] : iArray[i][1];
					else
						itemper = iArray[i][1];
					irefCnt++;
				} else
					irefCnt++;
			}
		}
		System.out.println(irefCnt);
	}
}
