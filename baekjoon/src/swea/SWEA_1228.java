package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 암호문1
public class SWEA_1228 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		LinkedList<Integer> list = new LinkedList<>();
		for (int itest = 1; itest <= 10; itest++) {
			list.clear();
			int iLength = Integer.parseInt(bf.readLine());
			
			st = new StringTokenizer(bf.readLine());
			
			for (int i = 0; i < iLength; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int iOrderCount = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < iOrderCount; i++) {
				String str = st.nextToken();
				if (str.equals("I")) {
					int iIndex = Integer.parseInt(st.nextToken());
					int iNumCnt = Integer.parseInt(st.nextToken());
					
					for (int j = 0; j < iNumCnt; j++) {
						list.add(iIndex++, Integer.parseInt(st.nextToken()));
					}
				}
			}
			sb.append("#" + itest + " ");
			for (int i = 0; i< 10; i++) {
				sb.append(list.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
