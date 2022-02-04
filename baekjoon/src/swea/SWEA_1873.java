package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1873 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int itestcase = Integer.parseInt(bf.readLine());
		
		for (int test = 1; test <= itestcase; test++) {
			String str = bf.readLine();
			
			int iRow = Integer.parseInt(str.split(" ")[0]);
			int iCol = Integer.parseInt(str.split(" ")[1]);
		}
	}
}
