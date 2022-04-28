package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 점화식
public class BJ_13699 {

	// int 범위 벗어나기에 long 형으로 선언 
	public static long[] dp = new long[36]; 
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int n = Integer.parseInt(br.readLine()); 
		dp[0]=1; // 1부터 n까지 순서대로 점화식을 곱해가면 된다. 
		for (int x = 1; x <= n; x++) { 
			int index=x/2; 
			for(int y=0;y<index;y++){ 
				dp[x]+=2*(dp[y]*dp[x-1-y]); 
			} 
			if(x%2==1){ dp[x]+=dp[x/2]*dp[x/2]; 
		} 
		} 
		bw.write(String.valueOf(dp[n])); 
		bw.flush(); 
		
	}
}
