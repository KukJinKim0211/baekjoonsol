package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서로소 집합
public class SWEA_3289 {
	static int N;
	static int[] parents;
	// 단위집합 생성
	public static void makeSet() {
		parents = new int[N + 1];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 1; i < N; i++) {
			parents[i] = i;
		}
	}
	// a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if (a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	// a, b 두 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int itestcase = Integer.parseInt(bf.readLine());
		for (int itest = 1; itest <= itestcase; itest++) {
			sb.append("#" + itest + " ");
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			makeSet();
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(bf.readLine());
				int icase = Integer.parseInt(st.nextToken());
				int i1 = Integer.parseInt(st.nextToken());
				int i2 = Integer.parseInt(st.nextToken());
				if (icase == 0) {
					union(i1, i2);
				} else {
					if (findSet(i1) == findSet(i2))
						sb.append("1");
					else
						sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
