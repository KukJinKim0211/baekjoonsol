package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 크로스워드 만들기
public class BJ_2804 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		String first = st.nextToken();
		String second = st.nextToken();
		int firstindex = 0;
		int secondindex = 0;
		for (int i = 0; i < first.length(); i++) {
			if (second.indexOf(first.charAt(i)) != -1) {
				firstindex = second.indexOf(first.charAt(i));
				secondindex = i;
				break;
			}
		}
		
		for (int i = 0; i < second.length(); i++) {
			for (int j = 0; j < first.length(); j++) {
				if (i == firstindex) {
					sb.append(first.charAt(j));
				}
				else {
					if (j == secondindex)
						sb.append(second.charAt(i));
					else
						sb.append(".");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
