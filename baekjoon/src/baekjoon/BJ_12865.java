package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 평범한 배낭
public class BJ_12865 {
	static int N, K;
	//static int[][] iArray;
	static int[] iValue;
	static int[] iWeight;
	static int iMax;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		//iArray = new int[N][2];
		iValue = new int[N];
		iWeight = new int[N];
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			//iArray[i][0] = Integer.parseInt(st.nextToken());
			//iArray[i][1] = Integer.parseInt(st.nextToken());
			iWeight[i] = Integer.parseInt(st.nextToken());
			iValue[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(iValue);
		Arrays.sort(iWeight);
		
		/*Arrays.sort(iArray, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}
			else {
				return Integer.compare(o1[0], o2[0]);
			}
		});*/
		
		find(0, 0, 0);
		System.out.println(iMax);
	}
	static void find(int idx, int weight, int iSum) {
		if (idx == N) {
			iMax = Math.max(iMax, iSum);
			return;
		}
		
		find(idx + 1, weight, iSum);
		if (idx + 1 < N && K >= weight + iWeight[idx]) 
			find(idx + 1, weight + iWeight[idx], iSum + iValue[idx]);
		else {
			iMax = Math.max(iMax, iSum);
			return;
		}
	}
}
