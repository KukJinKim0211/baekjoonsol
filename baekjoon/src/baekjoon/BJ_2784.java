package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 가로 세로 퍼즐
public class BJ_2784 {
	static String[] sAllData;
	static boolean bComplete;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sAllData = new String[6];
		for (int i = 0; i < sAllData.length; i++) {
			sAllData[i] = bf.readLine();
		}
		boolean[] isSelected = new boolean[sAllData.length];
		permu(new String[3], isSelected, 0);
		if (!bComplete)
			System.out.println("0");
	}
	
	static void permu(String[] sData, boolean[] isSelected, int iCount) {
		if (bComplete)
			return;
		
		if (iCount == sData.length) {
			stringCheck(sData);
			return;
		}
		
		for (int i = 0 ; i < sAllData.length; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			sData[iCount] = sAllData[i];
			permu(sData, isSelected, iCount + 1);
			isSelected[i] = false;
		}
	}
	
	static void stringCheck(String[] sData) {
		String str1 = Character.toString(sData[0].charAt(0)) + Character.toString(sData[1].charAt(0)) + Character.toString(sData[2].charAt(0));
		String str2 = Character.toString(sData[0].charAt(1)) + Character.toString(sData[1].charAt(1)) + Character.toString(sData[2].charAt(1));
		String str3 = Character.toString(sData[0].charAt(2)) + Character.toString(sData[1].charAt(2)) + Character.toString(sData[2].charAt(2));
		String[] snewData = new String[6];
		snewData[0] = sData[0];
		snewData[1] = sData[1];
		snewData[2] = sData[2];
		snewData[3] = str1;
		snewData[4] = str2;
		snewData[5] = str3;
		int iCheck = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (sAllData[i].equals(snewData[j])) {
					snewData[j] = "X";
					iCheck++;
					break;
				}
			}
		}
		if (iCheck == 6) {
			for (String s1 : sData) {
				System.out.println(s1);
			}
			bComplete = true;
		}
	}
}
