package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 퍼펙트 셔플
public class SWEA_3499 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int itestcount = Integer.parseInt(bf.readLine());
		Queue<String> q = new LinkedList<>();
		for (int itest = 1; itest <= itestcount; itest++) {
			q.clear();
			int iLength = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			int iNextLeng = iLength % 2 == 1 ? iLength + 1 : iLength;
			String[] sArray1 = new String[iLength % 2 == 1 ? iLength + 1 : iLength];
			
			for (int i = 0; i < iLength; i++) {
				sArray1[i] = st.nextToken();
			}
			
			for (int i = 0; i < iNextLeng / 2; i++) {
				q.offer(sArray1[i]);
				q.offer(sArray1[iNextLeng / 2 + i]);
			}
			
			sb.append("#" + itest + " ");
			while (!q.isEmpty()) {
				if (q.peek() == null)
					break;
				sb.append(q.poll() + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
