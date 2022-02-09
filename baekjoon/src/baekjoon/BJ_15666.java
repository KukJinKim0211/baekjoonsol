package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_15666 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int iLength = Integer.parseInt(st.nextToken());
		int iCnt = Integer.parseInt(st.nextToken());
		
		int[] iArray = new int[iLength];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < iLength; i++) {
			iArray[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(iArray);

		Map<Integer, Integer> map = new HashMap<>();
		int iIndex = 0;
		for (int i = 0; i < iLength; i++) {
			if (!map.containsKey(iArray[i])) {
				map.put(iArray[i], iIndex++);
				System.out.println(iArray[i]);
			}
		}
		
		for (int i = 0; i < map.size(); i++) {
			System.out.println(map.get(i));
		}
	}
}
