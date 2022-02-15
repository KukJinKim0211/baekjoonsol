package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오븐 시계
public class BJ_2525 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int iHour = Integer.parseInt(st.nextToken());
		int iMinute = Integer.parseInt(st.nextToken());
		
		int iAddMin = Integer.parseInt(bf.readLine());
		
		iHour += iAddMin / 60;
		iMinute += iAddMin % 60;
		if (iMinute >= 60) {
			iMinute -= 60;
			iHour++;
		}
		
		if (iHour >= 24)
			iHour -=24;
		
		System.out.print(iHour + " " + iMinute);
	}
}
