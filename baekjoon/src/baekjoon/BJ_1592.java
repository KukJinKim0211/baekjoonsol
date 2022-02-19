package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 영식이와 친구들
public class BJ_1592 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());	// 인원수
		int M = Integer.parseInt(st.nextToken());	// 공 몇번받으면 우승?
		int L = Integer.parseInt(st.nextToken());	// 몇계단?
		int iIndex = 0;		// 현재 공을받은 위치의 인덱스
		int iResult = 0;
		int[] iArray = new int[N];
		
		if (M == 1) {
			System.out.println("0");
			return;
		}
		
		while (true) {
			iArray[iIndex]++;
	        if (iArray[iIndex] == M)
	            break;
	            
	        if (iArray[iIndex] % 2 == 0) {
	            if (iIndex + L >= N) 
	            	iIndex = L - N + iIndex;
	            else 
	            	iIndex += L;
	        }else if (iArray[iIndex] % 2 == 1){
	            if (iIndex - L < 0) 
	            	iIndex = N - L + iIndex;
	            else
	            	iIndex-=L;
	        }
	        iResult++;
		}
		System.out.println(iResult);
	}
}
