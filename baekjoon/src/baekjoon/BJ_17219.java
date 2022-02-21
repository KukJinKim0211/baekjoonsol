package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 비밀번호 찾기
public class BJ_17219 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			String str = bf.readLine();
			sb.append(map.get(str) + "\n");
		}
		System.out.println(sb);
	}
}
