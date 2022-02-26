package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 팩토리얼
public class BJ_10872 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		if (N == 0)
			System.out.println("1");
		else
			System.out.println(factorial(N));
	}
	
	static int factorial(int n) {
		if (n <= 1)
			return 1;
		
		return n * factorial(n - 1);
	}
}
