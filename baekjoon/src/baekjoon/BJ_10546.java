package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 배부른 마라토너
public class BJ_10546 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iCount = Integer.parseInt(bf.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<String> sArray = new ArrayList<>();
		int iIndex = 0;
		for (int i = 0; i < iCount + iCount - 1; i++) {
			String str = bf.readLine();
			if (map.get(str) == null) {
				map.put(str, 1);
				sArray.add(str);
			}
			else
				map.put(str, map.get(str) + 1);
		}
		
		for (int i = 0; i < sArray.size(); i++) {
			if (map.get(sArray.get(i)) % 2 == 1)
				System.out.println(sArray.get(i));
		}
	}
}
