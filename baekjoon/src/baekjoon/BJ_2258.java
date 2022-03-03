package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정육점
public class BJ_2258 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] iArray = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			iArray[i][0] = Integer.parseInt(st.nextToken());
			iArray[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(iArray, (o1, o2) ->{
			if (o1[1] == o2[1]) 
				return Integer.compare(o2[0], o1[0]);
			else
				return Integer.compare(o1[1], o2[1]);
		});
		int iPrice = -1;
		int iWeight = 0;
		int iBefore = iArray[0][1];
		int iWeightBuff = iArray[0][0];
		for (int i = 1; i < N; i++) {
			if (iBefore == iArray[i][1]) {
				iWeightBuff += iArray[i][0];
				continue;
			}
			iWeight += iArray[i][0] + iWeightBuff;
			if (iWeight >= M) {
				iPrice = iArray[i][1];
				break;
			}
			iBefore = iArray[i][1];
			iWeightBuff = 0;
		}
		System.out.println(iPrice);
	}
}
