package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 단어 정렬
public class BJ_1181 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = bf.readLine();
		}
		Arrays.sort(str, (o1, o2) -> {
			if (o1.toString().length() == o2.toString().length())
				return o1.compareTo(o2);
			else
				return o1.toString().length() - o2.toString().length();
		});
		sb.append(str[0] + "\n");
		for (int i = 1; i < N; i++) {
			if (!str[i].equals(str[i - 1]))
				sb.append(str[i] + "\n");
		}
		System.out.println(sb);
	}
}
