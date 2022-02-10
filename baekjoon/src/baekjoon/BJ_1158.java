package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1158 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>(); 
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int iNum = Integer.parseInt(st.nextToken());
		int iCount = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= iNum; i++) {
			q.offer(i);
		}
		sb.append("<");
		int icnt = 1;
		while (!q.isEmpty()) {
			int itemp = q.poll();
			if (icnt++ % iCount == 0) {
				sb.append(itemp + ", ");
				continue;
			}
			q.offer(itemp);
			
		}
		sb.setLength(sb.length() - 2);
	
		sb.append(">");
		
		System.out.println(sb);
	}
}
