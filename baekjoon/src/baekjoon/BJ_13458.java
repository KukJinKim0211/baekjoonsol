package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시험 감독
public class BJ_13458 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());	// 시험장의 갯수
		st = new StringTokenizer(bf.readLine());
		int[] A = new int[N];						// 각 시험장의 인원수
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long maxcount = 0;
		for (int i = 0; i < N; i++) {
			A[i] -= B;
			long count = 1;
			if (A[i] > 0){
				count += A[i] % C == 0 ? A[i] / C : A[i] / C + 1;
			}
			maxcount += count;
		}
		System.out.println(maxcount);
	}
}
