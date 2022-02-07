package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
// 괄호
public class SWEA_1218 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int itest = 1; itest <= 10; itest++) {
			String str = bf.readLine();
			int iCount = Integer.parseInt(str);
			
			str = bf.readLine();
			
			int itrue = 1;
			
			for (int i = 0; i < iCount; i++) {
				char cData = str.charAt(i);
				if (cData == '(' || cData == '[' || cData == '{' || cData == '<')
				{
					stack.push(cData);
				}
				else {
					if (!stack.isEmpty()) {
						if (cData == ')' && stack.peek() == '(')
							stack.pop();
						else if (cData == ']' && stack.peek() == '[')
							stack.pop();
						else if (cData == '}' && stack.peek() == '{')
							stack.pop();
						else if (cData == '>' && stack.peek() == '<')
							stack.pop();
						else {
							itrue = 0;
							break;
						}
					}
					else
					{
						itrue = 0;
						break;
					}
				}
			}
			
			sb.append("#" + itest + " " + itrue + "\n");
		}
		System.out.println(sb);
	}
}
