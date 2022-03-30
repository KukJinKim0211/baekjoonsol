package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 팩토리얼 0의 개수
public class BJ_1676 {	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int count = 0;
		while (true) {
			if (N < 5)
				break;
			count += N / 5;
			N /= 5;
		}
		System.out.println(count);
	}
}
