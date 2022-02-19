package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 롤 케이크
public class BJ_3985 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L = Integer.parseInt(bf.readLine());
		int N = Integer.parseInt(bf.readLine());
		int[] iArray = new int[L + 1];
		int[] iPeople = new int[N + 1];
		int[] iGridArray = new int[N + 1];
		for (int itest = 1; itest <= N; itest++) {
			st = new StringTokenizer(bf.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			for (int i = first; i <= last; i++) {
				if (iArray[i] == 0) {
					iArray[i] = itest;
					iPeople[itest]++;
				}
				iGridArray[itest]++;
			}
		}
		int iFood = 0;
		int iMaxFood = 0;
		int iGrid = 0;
		int iMaxGrid = 0;
		for (int i = 1; i <= N; i++) {
			if (iMaxGrid < iGridArray[i]) {
				iMaxGrid = iGridArray[i];
				iGrid = i;
			}
			if (iMaxFood < iPeople[i]){
				iMaxFood = iPeople[i];
				iFood = i;
			}
		}
		System.out.println(iGrid);
		System.out.println(iFood);
	}
}
