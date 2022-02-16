package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 방 배정
public class BJ_13300 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int iStuCount = Integer.parseInt(st.nextToken());
		int iLength = Integer.parseInt(st.nextToken());
		int[][] iStudent = new int[6][2];
		
		for (int i = 0; i < iStuCount; i++) {
			st = new StringTokenizer(bf.readLine());
			int iSex = Integer.parseInt(st.nextToken());
			int iGrade = Integer.parseInt(st.nextToken());
			if (iSex == 0)	// 여
				iStudent[iGrade - 1][0]++;
			else
				iStudent[iGrade - 1][1]++;
		}
		int iRoom = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				if (iStudent[i][j] == 0)
					continue;
				iRoom += (iStudent[i][j] / iLength);
				if (iStudent[i][j] % iLength != 0)
					iRoom++;
			}
		}
		System.out.println(iRoom);
	}
}
