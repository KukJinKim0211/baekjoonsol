package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 세 수
public class BJ_10817 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int i1 = Integer.parseInt(st.nextToken());
		int i2 = Integer.parseInt(st.nextToken());
		int i3 = Integer.parseInt(st.nextToken());
		
		if (i1 >= i2) {
			if (i3 >= i1)
				System.out.println(i1);
			else {
				if (i3 >= i2)
					System.out.println(i3);
				else
					System.out.println(i2);
			}
		}
		else {
			if (i3 >= i2)
				System.out.println(i2);
			else{
				if (i3 >= i1)
					System.out.println(i3);
				else
					System.out.println(i1);
			}
		}
	}
}
