package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2003 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] iArray = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			iArray[i] = Integer.parseInt(st.nextToken());
		}
		int cal = 0;
		int count = 0;
		int sttpoint = 0;
		int endpoint = 0;
		while (true) {
			if (cal >= M) {	// 합이 조건보다 클 시, 시작점을 이동
				cal -= iArray[sttpoint++];	// 시작점을 한칸 오른쪽으로 이동하고, 그 값을 빼기
			} else if (endpoint == N) {
				break;
			} else {
				cal += iArray[endpoint++];
			}
			
			if(cal == M) 
				count++;
		}
		System.out.println(count);
	}
}
