package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 구간 합
public class SWEA_5604 {
	static long[] num;
	static long result, mul;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(bf.readLine());
		for (int test = 1; test <= testcase; test++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			
			num = new long[10];
			result = 0;
			mul = 1;
			if (start == 0) start = 1;
			while (start <= end) {
				while(start % 10 != 0 && start <= end) {
					cal(start);
					start++;
				}
				if(start > end) break;
				while(end % 10 != 9 && start <= end) {
					cal(end);
					end--;
				}
				long diff = end / 10 - start / 10 + 1;
				for(int i = 0; i < 10; i++) {
					num[i] += diff * mul;
				}
				mul *= 10;
				start /= 10;
				end /= 10;
			}
			for (int i = 1; i < 10; i++) {
				result += (i * num[i]);
			}
			
			sb.append("#" + test + " " + result + "\n");
		}
		System.out.println(sb);
	}
	
	static void cal(long a) {
		for (long i = a; i > 0; i /= 10) {
			String s = Long.toString(i);
			int t = s.charAt(s.length() - 1) - '0';
			num[t] += mul;				
		}
	}
}
