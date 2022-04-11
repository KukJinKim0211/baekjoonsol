package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 통계학
public class BJ_2108 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] iArray = new int[N];
		int isum = 0;
		for (int i = 0; i < N; i++) {
			iArray[i] = Integer.parseInt(bf.readLine());
			isum += iArray[i];
		}
		Arrays.sort(iArray);
		
		// 최빈값 구하기
		int itemp = iArray[0];
		int inum = 0;			// 같은 수 저장
		int isamecnt = 1;		// 같은 수의 갯수
		int imaxsame = 0;		// 같은 수의 갯수의 최대값
		boolean bdup = false;	// 같은 수 갯수의 최대값의 중복 여부
		
		for (int i = 1; i <= N; i++) {
			if (i != N && itemp == iArray[i]) {		// 같은 값이 나올 시
				isamecnt++;
			}  else {
			
				if (imaxsame == isamecnt) {		// 같은수 개수의 최대값이 중복되었을 때, 두번째의 값을 저장
					if (!bdup) {	// 같은 수의 갯수 최대값이 중복되지 않았을 경우. 두번째 값을 저장하고 플래그를 잠근다
						inum = itemp;
						bdup = true;
					}
				}
			
				if (imaxsame < isamecnt) {		// 최대 빈도가 갱신될 때
					bdup = false;
					inum = itemp;
					imaxsame = isamecnt;
				}
				isamecnt = 1;
			}
			if (i != N) itemp = iArray[i];
		}
		
		System.out.println(Math.round((double)isum / (double)N));	// 평균값
		System.out.println(iArray[N / 2]);			// 중앙값
		if (N == 1) System.out.println(iArray[0]);
		else System.out.println(inum);					// 최빈값
		System.out.println(Math.abs(iArray[0] - iArray[N - 1]));	// 범위값
	}
}
