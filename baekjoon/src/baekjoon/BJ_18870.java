package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_18870 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iCount = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> map = new HashMap<>();
		
		int[] iArray = new int[iCount];
		int[] iClone = new int[iCount];

		for (int i = 0; i < iCount; i++) {
			iArray[i] = Integer.parseInt(st.nextToken());
		}
		
		iClone = iArray.clone();
		Arrays.sort(iClone);
		int iIndex = 0;
		for (int i = 0; i < iClone.length; i++) {
			if(!map.containsKey(iClone[i])) {
				map.put(iClone[i], iIndex);
				iIndex++;		// map에 넣고나면 다음 순위를 가리킬 수 있도록 1을 더해준다.
			}
		}
		
		for (int i = 0; i < iArray.length; i++) {
			sb.append(map.get(iArray[i]) + " ");
		}
		System.out.println(sb);
	}
}
