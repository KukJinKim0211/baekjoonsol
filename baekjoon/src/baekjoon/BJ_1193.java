package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1193 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int iNum = Integer.parseInt(bf.readLine());
		int in = 0;
		int iCount = 0;
		
		if (iNum == 1)
		{
			System.out.println("1/1");
			return;
		}
		// 입력받은 값이 몇번째 줄에 있는지 확인
		while (true) {
			in = in + (iCount + 1);
			
			if (in >= iNum) 
				break;
			
			iCount++;
		}
		
		int iboonmo = iCount + 2;
		int i1 = in - iNum + 1;
		
		if (iboonmo % 2 == 0)
			System.out.println(i1 + "/" + (iboonmo - i1));
		else
			System.out.println((iboonmo - i1) + "/" + i1);
	}
}
