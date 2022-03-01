package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 랜선 자르기
public class BJ_1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int K = Integer.parseInt(st.nextToken());	// 총 랜선의 개수
		int N = Integer.parseInt(st.nextToken());	// 필요한 랜선의 개수
		int[] iArray = new int[K];
		for (int i = 0; i < K; i++) {
			iArray[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(iArray);
		long Min = 1;
		long Max = iArray[K - 1];
		long temp = 0;
		while (true) {
			if (Min > Max)
				break;
			temp = (Min + Max) / 2;
			int iCount = 0;
			for (int i = 0; i < K; i++) {
				iCount += iArray[i] / temp;
			}
			if (iCount >= N) 
				Min = temp + 1;
			else
				Max = temp - 1;
		}
		System.out.println(Max);
	}
}
