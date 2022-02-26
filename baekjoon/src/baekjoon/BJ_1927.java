package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 최소 힙
public class BJ_1927 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int iNum = Integer.parseInt(bf.readLine());
			if (iNum == 0) {
				if (!que.isEmpty())
					sb.append(que.poll() + "\n");
				else
					sb.append("0\n");
			}
			else
				que.offer(iNum);
		}
		System.out.println(sb);
	}
}
