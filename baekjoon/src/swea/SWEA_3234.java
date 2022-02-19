package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 준환이의 양팔저울
public class SWEA_3234 {
	static int N;				// 입력받는 배열의 사이즈
	static int[] iArray;		// 입력받은 배열 저장
	static int[] inumber;		// 수열 배열 저장
	static boolean[] bVisit;
	static int frontCount;		// 앞의 수가 더 큰 경우의 수
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int itestcase = Integer.parseInt(bf.readLine());
		for (int itest = 1; itest <= itestcase; itest++) {
			frontCount = 0;
			N = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			iArray = new int[N];
			inumber = new int[N];
			bVisit = new boolean[N];
			for (int i = 0; i < N; i++) {
				iArray[i] = Integer.parseInt(st.nextToken());
			}
			permu(0);
			sb.append("#" + itest + " " + frontCount + "\n");
		}
		System.out.println(sb);
	}
	static void permu(int icount) {
		if (icount == N) {
			cal(inumber[0], 0, 1); // 수열 맨 첫자리는 무조건 저울 왼쪽에 올려야해서 더해놓고시작
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!bVisit[i]) {
				bVisit[i] = true;
				inumber[icount] = iArray[i];
				permu(icount + 1);
				bVisit[i] = false;
			}
		}
	}
	// ifront:지금시점까지 왼쪽저울무게  iback:지금시점까지 오른쪽저울무게  icount:수열의 인덱스
	static void cal(int ifront, int iback, int icount) {
		if (icount == N) {
			if (ifront >= iback)
				frontCount++;
			return;
		}
		
		if (ifront >= iback + inumber[icount])	// 오른쪽 저울에 다음 추를 놓아도 왼쪽의 무게가 더 큰경우 오른쪽에 추 놓고 다음추 
			cal(ifront, iback + inumber[icount], icount + 1);
		cal(ifront + inumber[icount], iback, icount + 1);	// 왼쪽 저울에 추 1개 넣고 다음추
	}
}
