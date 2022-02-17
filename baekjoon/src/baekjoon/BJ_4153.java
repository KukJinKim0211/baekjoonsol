package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직각삼각형
public class BJ_4153 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(bf.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			int i3 = Integer.parseInt(st.nextToken());
			
			if (i1 + i2 + i3 == 0)
				break;
			
			if (i1 * i1 + i2 * i2 == i3 * i3)
				sb.append("right\n");
			else if (i2 * i2 + i3 * i3 == i1 * i1)
				sb.append("right\n");
			else if (i3 * i3 + i1 * i1 == i2 * i2)
				sb.append("right\n");
			else
				sb.append("wrong\n");
		}
		System.out.println(sb);
	}
}
