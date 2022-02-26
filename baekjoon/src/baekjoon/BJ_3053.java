package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 택시 기하학
public class BJ_3053 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		double R = Double.parseDouble(bf.readLine());
		System.out.println(R * R * Math.PI);
		System.out.println(2 * R * R);
	}
}
