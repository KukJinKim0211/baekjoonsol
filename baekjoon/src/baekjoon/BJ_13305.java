package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주유소
public class BJ_13305 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] a1 = new int[N - 1];		// 각 마을 사이의 거리
		int[] a2 = new int[N];			// 각 마을의 리터당 기름값
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N - 1; i++) {
			a1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			a2[i] = Integer.parseInt(st.nextToken());
		}
		
		int iLength = 0;	// 기름을 넣은 채로 가야할 거리
		int iPrice = a2[0];	// 첫 마을의 기름값
		long lTotalPrice = 0;
		for (int i = 1; i < N; i++) {	// 현재 저장한 기름값보다 적은 기름값의 마을이 발견되면 새로 기름값을 갱신
			iLength += a1[i - 1];
			if (iPrice > a2[i]) {	// 현재 알고있는 기름값보다 적은 기름값의 마을을 찾았을 경우
				lTotalPrice += (long)iPrice * iLength;
				iPrice = a2[i];	// 최소 기름값을 갱신
				iLength = 0;	// 새롭게 거리를 카운팅
			} 
		}
		// 도착 시 카운팅된 거리만큼 더하기
		lTotalPrice += (long)iPrice * iLength;
		System.out.println(lTotalPrice);
	}
}
