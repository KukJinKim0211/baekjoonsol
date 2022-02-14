package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
// 나는야 포켓몬 마스터 이다솜
public class BJ_1620 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int iPokCount = Integer.parseInt(st.nextToken());
		int iSolCount = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> mapSValue = new HashMap<>();
		HashMap<String, Integer> mapIValue = new HashMap<>();
		for (int i = 1 ; i <= iPokCount; i++) {
			String str = bf.readLine();
			mapSValue.put(i, str);
			mapIValue.put(str, i);
		}
		
		for (int i = 0; i < iSolCount; i++) {
			String str = bf.readLine();
			if (str.charAt(0) >= '0' && str.charAt(0) <= '9') 
				sb.append(mapSValue.get(Integer.parseInt(str)) + "\n");
			else 
				sb.append(mapIValue.get(str) + "\n");
			
		}
		System.out.println(sb);
	}
}
