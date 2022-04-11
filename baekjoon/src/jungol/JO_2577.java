package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 회전 초밥(고)
public class JO_2577 {
	static int N, d, k, c, MAX;
	static int[] iArray, eat;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	// 회전초밥 접시 수
		d = Integer.parseInt(st.nextToken());	// 초밥의 가짓수
		k = Integer.parseInt(st.nextToken());	// 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken());	// 쿠폰 번호
		iArray = new int[N];
		eat = new int[d + 1];
		for (int i = 0; i < N; i++) {
			iArray[i] = Integer.parseInt(bf.readLine());
		}
		
		System.out.println(find());
	}
	
	static int find() {
		int count = 0;
		int max = 0;
		
		for (int i = 0; i < k; i++) {
			if (eat[iArray[i]] == 0) count++;	// 안먹었던 음식이면 count++
			eat[iArray[i]]++;
		}
		
		max = count;
		for (int i = 1; i < N; i++) {
			if (max <= count) {
				if (eat[c] == 0) max = count + 1;
				else max = count;
			}
			
			eat[iArray[i - 1]]--;
			if (eat[iArray[i - 1]] == 0) count--;
			
			if (eat[iArray[(i + k - 1) % N]] == 0) count++;
			eat[iArray[(i + k - 1) % N]]++;
		}
		return max;
	}
}
