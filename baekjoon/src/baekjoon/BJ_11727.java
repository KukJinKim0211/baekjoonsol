package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 2xn 타일링 2
public class BJ_11727 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int iMaxLength = Integer.parseInt(bf.readLine());
		iMaxLength--;
		BigInteger iCount = new BigInteger("0");
		BigInteger itwo = new BigInteger("2");
		// 규칙 테스트
		while (true) {
			if (iMaxLength <= 0)
				break;
			
			iCount = iCount.add(itwo.pow(iMaxLength));
			iMaxLength -= 2;
		}
		iCount.add(new BigInteger("1"));
		System.out.println(iCount.divide(new BigInteger("10007")));
	}
	
}
