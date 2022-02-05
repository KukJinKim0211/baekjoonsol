package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 달팽이는 올라가고 싶다
public class BJ_2869 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int iUp = Integer.parseInt(st.nextToken());
		int iDown = Integer.parseInt(st.nextToken());
		int iHeight = Integer.parseInt(st.nextToken());
		
		int iSub = iUp - iDown;
		iHeight = (iHeight - iUp);
		
		if (iHeight % iSub == 0 )
			System.out.println((iHeight / iSub) + 1);
		else
			System.out.println((iHeight / iSub) + 2);
	}
}
