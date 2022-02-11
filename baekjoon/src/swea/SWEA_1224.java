package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 계산기3
public class SWEA_1224 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> charstack = new Stack<>();
		Stack<Integer> numstack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		StringBuilder out = new StringBuilder();
		for (int itest = 1; itest <= 10; itest++) {
			sb.setLength(0);
			int iLength = Integer.parseInt(bf.readLine());
			String str = bf.readLine();
			int iOpenCloseCnt = 0;		// 괄호를 제거한 만큼 연산 길이가 짧아지니까 그 카운트 저장
			for (int i = 0; i < iLength; i++) {
				char cData = str.charAt(i);
				
				if (cData == '(' || cData == ')' || cData == '+' || cData == '*') {
					// 연산자 스택이 비어있거나 괄호 일 시, push
					if (cData == '(' || charstack.isEmpty()) {
						charstack.push(cData);
		            } else if (cData == ')') {
		            	iOpenCloseCnt++;
		                while (charstack.peek() != '(') {
		                    sb.append(charstack.pop());
		                }
		                charstack.pop();
		            } else if (cData == '*') {
		            	charstack.push(cData);
		            } else if (cData == '+') {
		            	while (!charstack.isEmpty()) {
							if (charstack.peek() == '(')
								break;
							else
								sb.append(charstack.pop());
						}
						charstack.push(cData);
		            }
				}
				else
					sb.append(cData);
			} // 연산자의 수만큼 반복하는 for문 종료
			while (!charstack.isEmpty()) {
				sb.append(charstack.pop());
			}
			
			for (int i = 0; i < iLength - iOpenCloseCnt * 2; i++) {
				char cData = sb.charAt(i);
				
				if (cData == '+' || cData == '*') {
					int i1 = numstack.pop();
					int i2 = numstack.pop();
					if (cData == '+')
						numstack.push(i1 + i2);
					else
						numstack.push(i1 * i2);
				}
				else {
					numstack.push(cData - '0');
				}
			}
			
			out.append("#" + itest + " " + numstack.pop() + "\n");
		} // test case for문 종료
		System.out.println(out);
	}
}
