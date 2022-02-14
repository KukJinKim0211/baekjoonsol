package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 규영이와 인영이의 카드게임
public class SWEA_6808 {
	static int iwin, ilose;
	static ArrayList<Integer> iArray1 = new ArrayList<>();
	static ArrayList<Integer> iArray2 = new ArrayList<>();
	static boolean[] bVisit;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int itestcase = Integer.parseInt(bf.readLine());
		
		for (int itest = 1; itest <= itestcase; itest++) {
			st = new StringTokenizer(bf.readLine());
			iwin = 0;
			ilose = 0;
			iArray1.clear();
			iArray2.clear();
			bVisit = new boolean[9];
			
			for (int i = 1; i <= 18; i++) {
				iArray2.add(i);
			}
			
			for (int i = 0; i < 9; i++) {
				iArray1.add(Integer.parseInt(st.nextToken()));
			}
			
			iArray2.removeAll(iArray1);
			
			permu(0, 0);
			sb.append("#" + itest + " " + iwin + " " + ilose + "\n");
		}
		System.out.println(sb);
	}
	
	static void permu(int iSum, int iIndex) {
		if (iIndex == 9) {
            if (iSum > 0)
                iwin++;
            else if (iSum < 0) 
                ilose++;
            return;
        }
        for (int i = 0; i < 9; i++){
            if (!bVisit[i]) {
                int sum = iSum;
                sum += (iArray1.get(iIndex) > iArray2.get(i)) ? iArray1.get(iIndex) + iArray2.get(i) : - (iArray1.get(iIndex) + iArray2.get(i));
                bVisit[i] = true;
                permu(sum, iIndex+1);
                bVisit[i] = false;
            }
        }
    }
}
