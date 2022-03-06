package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 온라인 판매
public class BJ_1246 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] iEgg = new int[N];
		int[] iCustomer = new int[M];
		
		for (int i = 0; i < M; i++) {
			iCustomer[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(iCustomer);
		
		int iMaxPrice = 0;
		int iMaxSum = 0;
		
		if (N < M) {	// 계란 수가 사려는 사람보다 적을 시
			for (int i = M - N; i < M; i++) {
				int iPrice = iCustomer[i];
				int iCount = 0;
				for (int j = i; j < M; j++) {
					if (iCustomer[j] >= iPrice)
						iCount++;
				}
				if (iMaxSum < iPrice * iCount) {
					iMaxPrice = iPrice;
					iMaxSum = iPrice * iCount;
				}
			}
		} else {
			for (int i = 0; i < M; i++) {
				int iPrice = iCustomer[i];
				int iCount = 0;
				for (int j = i; j < M; j++) {
					if (iCustomer[j] >= iPrice)
						iCount++;
				}
				if (iMaxSum < iPrice * iCount) {
					iMaxPrice = iPrice;
					iMaxSum = iPrice * iCount;
				}
			}
		}
		System.out.println(iMaxPrice + " " + iMaxSum);
	}
}
