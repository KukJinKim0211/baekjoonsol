package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 탑
public class BJ_2493 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iCount = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < iCount; i++) {
			int iData = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= iData) {
					sb.append(stack.peek()[0] + " ");
					break;
				}
				else 
					stack.pop();
			}
			if (stack.isEmpty())
				sb.append("0 ");
			
			stack.push(new int[]{i + 1, iData});
		}
		
		System.out.println(sb);
	}
}
