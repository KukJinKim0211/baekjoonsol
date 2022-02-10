package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_12927 {
	static boolean bLight[];
	static int iTurnOffCnt;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		bLight = new boolean[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'Y')
				bLight[i] = true;
		}
		
		for (int i = 0; i < str.length(); i++) {
			if (bLight[i] == true)
				turnOff(i + 1);
		}
		
		if (isAllTurnOff())
			System.out.println(iTurnOffCnt);
		else
			System.out.println(-1);
	}
	
	public static void turnOff(int iIndex) {
		for (int i = 1; i <= bLight.length / iIndex; i++) {
			bLight[i * iIndex - 1] = bLight[i * iIndex - 1] == true ? false : true;
		}
		
		iTurnOffCnt++;
	}
	
	public static boolean isAllTurnOff() {
		for (int i = 0; i < bLight.length; i++) {
			if (bLight[i] == true)
				return false;
		}
		
		return true;
	}
}
