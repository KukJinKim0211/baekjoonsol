package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 한빈이와 spot mart
public class SWEA_9229 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int itestcase = Integer.parseInt(bf.readLine());
		
		for (int itest = 1; itest <= itestcase; itest++) {
			st = new StringTokenizer(bf.readLine());
			int iCount = Integer.parseInt(st.nextToken());
			int iWeight = Integer.parseInt(st.nextToken());
			
			int[] iArray = new int[iCount];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < iCount; i++) {
				iArray[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(iArray);
			int iMaxWeight = -1;
			int iCurrent = 0;
			
			if (iArray[0] + iArray[1] > iWeight)
				iMaxWeight = -1;
			else {
			for (int i = 0; i < iCount - 1; i++) {
				if (iArray[i] >= iWeight) 
					break;
				
				for (int j = i + 1; j < iCount; j++) {
					iCurrent = iArray[i] + iArray[j];
					if (iCurrent > iWeight)
						break;
					iMaxWeight = Math.max(iMaxWeight, iCurrent);
				}
			}
			}
			
			sb.append("#" + itest + " " + iMaxWeight);
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
