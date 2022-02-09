package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 암호생성기
public class SWEA_1225 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		String str = null;
		
		for (int itest = 1; itest <= 10; itest++){
			str = bf.readLine();
			q.clear();
			st = new StringTokenizer(bf.readLine());
			
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			int iData = 0;
			int iCount = 1;
			boolean bzero = false;
			while (!bzero) {
				if (iCount == 6)
					iCount = 1;
				iData = q.poll();
				iData -= iCount++;
				if (iData <= 0) {
					bzero = true;
					iData = 0;
				}
				q.add(iData);
			}
			
			sb.append("#" + str + " ");
			for (int i = 0; i < 8; i++) {
				sb.append(q.poll() + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
