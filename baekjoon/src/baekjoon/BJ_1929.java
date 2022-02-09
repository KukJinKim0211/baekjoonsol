package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//소수 구하기
public class BJ_1929 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = bf.readLine();
		
		int iStart = Integer.parseInt(str.split(" ")[0]);
		int iEnd = Integer.parseInt(str.split(" ")[1]);
		
		int iEnd = (int)Math.sqrt(iEnd);
	}
}
