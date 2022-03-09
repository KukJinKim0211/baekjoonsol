package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// IOIOI
public class BJ_5525 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		String str = bf.readLine();
		char[] cArray = new char[M];
		cArray = str.toCharArray();
		
		int result = 0;
		int count = 0;
		char beforechar = cArray[0];
		if (beforechar == 'I')
			count = 1;
		else
			count = 0;
		for (int i = 1; i < M; i++) {
			if (cArray[i] == 'I') {
				if (cArray[i] != beforechar) 
					count++;
				else {
					if (count >= 2 * N + 1)
						result += (count - (2 * N + 1)) == 0 ? 1 : (count - (2 * N + 1)) / 2 + 1;
					count = 1;
				}
				beforechar = cArray[i];
			}
			else {
				if (cArray[i] != beforechar)
					count++;
				else {
					if (count >= 2 * N + 1)
						result += (count - (2 * N + 1)) == 0 ? 1 : (count - (2 * N + 1)) / 2 + 1;
					count = 0;
				}
				beforechar = cArray[i];
			}
		}
		if (count >= 2 * N + 1)
			result += (count - (2 * N + 1)) == 0 ? 1 : (count - (2 * N + 1)) / 2 + 1;
		System.out.println(result);
	}
}
