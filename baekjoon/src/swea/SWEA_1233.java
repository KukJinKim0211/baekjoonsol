package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 사칙연산 유효성 검사
public class SWEA_1233 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int itest = 1; itest <= 10; itest++) {
			int iNode = Integer.parseInt(bf.readLine());
			String[] sNode = new String[iNode + 1];
			for (int i = 0; i < iNode; i++) {
				sNode[i + 1] = bf.readLine().split(" ")[1];
			}
			int iFlag = 1;
			for (int i = 1; i < iNode / 2; i++) {
				if (!(sNode[i].equals("+") || sNode[i].equals("-") || sNode[i].equals("*") || sNode[i].equals("/")))
					iFlag = 0;
			}
			for (int i = iNode / 2 + 1; i <= iNode; i++) {
				if (sNode[i].equals("+") || sNode[i].equals("-") || sNode[i].equals("*") || sNode[i].equals("/"))
					iFlag = 0;
			}
			
			sb.append("#" + itest + " " + iFlag + "\n");
		}
		System.out.println(sb);
	}
}
