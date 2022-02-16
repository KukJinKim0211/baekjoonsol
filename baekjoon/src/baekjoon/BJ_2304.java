package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 창고 다각형
public class BJ_2304 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iSize = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		int[][] iArray = new int[2][iSize];
		for (int i = 0; i < iSize; i++) {
			st = new StringTokenizer(bf.readLine());
			iArray[i][0] = Integer.parseInt(st.nextToken());
			iArray[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(i);
		int[] itemp = new int[iSize];
		itemp = ilast.clone();
		Arrays.sort(itemp);
		int iMaxValue = itemp[iSize - 1];
		int iMaxCount = 1;
		for (int i = iSize - 1; i >= 1; i--) {
			if (itemp[i] == itemp[i - 1])
				iMaxCount++;
		}
		
		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		boolean bUpDown = false;
		for (int i = 0; i < iSize; i++) {
			if (st1.empty()) {
				st1.push(ifirst[i]);
				st2.push(ilast[i]);
			}
			if (!bUpDown) {	// 올라가는시점
				if (ilast[i] == iMaxValue) {
					bUpDown = true;
				}
				else {
					
				}
			}
			else { // 내려가는시점
				
			}
		}
	}
}
