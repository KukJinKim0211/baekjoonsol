package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14652 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int irow = Integer.parseInt(st.nextToken());
		int icol = Integer.parseInt(st.nextToken());
		int inum = Integer.parseInt(st.nextToken());
		System.out.println(inum / icol + " " + inum % icol);
	}
}
