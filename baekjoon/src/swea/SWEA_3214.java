package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 최소 스패닝 트리
public class SWEA_3214 {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(bf.readLine());
		for (int test = 1; test <= testcase; test++) {
			st = new StringTokenizer(bf.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int[][] iArray = new int[E][3];
			parent = new int[V + 1];
			Arrays.fill(parent, -1);
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(bf.readLine());
				iArray[i][0] = Integer.parseInt(st.nextToken());
				iArray[i][1] = Integer.parseInt(st.nextToken());
				iArray[i][2] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(iArray, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					int i = a[2] - b[2];
					return i;
				}
			});
			
			int count = 0;
			long result = 0;
			for (int i = 0; i < E; i++) {
				boolean union = union(iArray[i][0], iArray[i][1]);
				if (union) {
					result += iArray[i][2];
					count++;
				}
				if (count == V - 1)
					break;
			}
			sb.append("#" + test + " " + result + "\n");
		}
		System.out.println(sb);
	}
	
	private static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		if (aroot != broot) {
			parent[broot] = aroot;
			return true;
		}
		return false;
	}
	
	private static int find(int a) {
		if (parent[a] < 0)
			return a;
		else 
			return parent[a] = find(parent[a]);
	}
}
