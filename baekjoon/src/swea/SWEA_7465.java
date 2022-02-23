package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 창용 마을 무리의 갯수
public class SWEA_7465 {
	static int N;
	static int[] parents;
	static boolean[] bparents;
	// 단위집합 생성
	public static void makeSet() {
		parents = new int[N];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 0; i < N; i++) {
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
			int iResult = 0;
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken()) + 1;
			int M = Integer.parseInt(st.nextToken());
			makeSet();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine());
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			bparents = new boolean[N];
			for (int i = 1; i < N; i++) {
				bparents[findSet(i)] = true;
			}
			for (int i = 1; i < N; i++) {
				if (bparents[i]) iResult++;
			}
			sb.append("#" + itest + " " + iResult + "\n");
		}
		System.out.println(sb);
	}
}

