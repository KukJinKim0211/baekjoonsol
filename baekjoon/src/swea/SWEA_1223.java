package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 계산기2
public class SWEA_1223 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		StringBuilder sStack = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		Stack<Integer> numberstack = new Stack<>();
		for (int itest = 1; itest <= 10; itest++) {
			int iLength = Integer.parseInt(bf.readLine());
			stack.clear();
			sStack.setLength(0);
			String str = bf.readLine();
			for (int i = 0; i < iLength; i++) {
				char cData = str.charAt(i);
				
				if (cData == '*' || cData == '+')
				{
					if (stack.isEmpty()) {
						stack.push(cData);
					}
					else {
					if (cData == '*') {
						while (!stack.isEmpty()) {
							if (stack.peek() == '*')
								sStack.append(stack.pop());
							else
								break;
						}
						stack.push(cData);
					}
					else {
						while (!stack.isEmpty()) {
							sStack.append(stack.pop());
						}
						stack.push(cData);
					}
					}
				}
				else
					sStack.append(cData);
			}
			while (!stack.isEmpty()) {
				sStack.append(stack.pop());
			}
			
			for (int i = 0; i < iLength; i++) {
				char cData = sStack.charAt(i);
				if (cData == '*' || cData == '+') {
					int i1 = numberstack.pop();
					int i2 = numberstack.pop();
					if (cData == '*')
						numberstack.push(i1 * i2);
					else
						numberstack.push(i1 + i2);
				}
				else {
					numberstack.push(cData - '0');
				}
			}
			
			sb.append("#" + itest + " " + numberstack.pop() + "\n");
		}
		System.out.println(sb);
	}
}
