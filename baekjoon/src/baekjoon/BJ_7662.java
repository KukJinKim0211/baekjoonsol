package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 이중 우선 순위 큐
public class BJ_7662 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();								// 낮은 숫자 순으로
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());	// 높은 숫자 순으로
		int itestcase = Integer.parseInt(bf.readLine());
		for (int test = 1; test <= itestcase; test++) {
			pq1.clear();
			pq2.clear();
			int I = 0;	// 추가 갯수
			int DMin = 0;	// 최소값 삭제 갯수
			int DMax = 0;	// 최대값 삭제 갯
			int K = Integer.parseInt(bf.readLine());
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(bf.readLine());
				if (st.nextToken().equals("I")) { // 추가
					int itemp = Integer.parseInt(st.nextToken());
					pq1.add(itemp);
					//pq2.add(itemp);
					I++;
				}
				else {	// 삭제
					if (st.nextToken().equals("-1"))
						DMin++;
					else
						DMax++;
				}
			}
			System.out.println(pq1.toString());
			System.out.println(DMin + " " + DMax + " " + I);
			if ((DMin + DMax) >= I)
				sb.append("EMPTY" + "\n");
			else {
				int Min = 0;
				int Max = 0;
				while (true) {
					if (DMin == 0) {
						Min = pq1.peek();
						break;
					}
					pq1.poll();
					DMin--;
				}
				
				while (!pq1.isEmpty()) {
					pq2.add(pq1.poll());
				}
				
				while (true) {
					if (DMax == 0) {
						Max = pq2.peek();
						break;
					}
					pq2.poll();
					DMax--;
				}
				sb.append(Max + " " + Min + "\n");
			}
		}
		System.out.println(sb);
	}
}
