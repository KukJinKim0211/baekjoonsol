package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 쿼드 트리
public class BJ_1992 {
	static int[][] iArray;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iSize = Integer.parseInt(bf.readLine());
		iArray = new int[iSize][iSize];
		for (int i = 0; i < iSize; i++) {
			String str = bf.readLine();
			for (int j = 0; j < iSize; j++) {
				iArray[i][j] = str.charAt(j) - '0';
			}
		}
		 find(0, 0, iSize);
	     System.out.println(sb.toString());
	}
    
    public static void find(int irow, int icol, int isize) {
        if(check(irow, icol, isize)) 
            sb.append(iArray[irow][icol]);
        else {
            sb.append("(");
            int iNextSize = isize / 2;
            find(irow, icol, iNextSize);
            find(irow, icol + iNextSize, iNextSize);
            find(irow + iNextSize, icol, iNextSize);
            find(irow + iNextSize, icol + iNextSize, iNextSize);
            sb.append(")");
        }
    }
    
    public static boolean check(int irow, int icol, int isize) {
        int iNum = iArray[irow][icol];
        
        for(int i = irow; i < irow + isize; i++) {
            for(int j = icol; j < icol + isize; j++) {
                if(iNum != iArray[i][j]) return false;
            }
        }
        return true;
    }
}
