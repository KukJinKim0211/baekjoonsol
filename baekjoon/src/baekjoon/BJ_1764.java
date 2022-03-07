package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 듣보잡
public class BJ_1764 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = bf.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		Set<String> hs = new HashSet<>();
		for (int i = 0; i < N; i++) {
			hs.add(bf.readLine());
		}
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < M; i++) {
			String Str = bf.readLine();
			if (hs.contains(Str))
				list.add(Str);
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + "\n");
		}
		System.out.println(list.size());
		System.out.println(sb);
	}
}
