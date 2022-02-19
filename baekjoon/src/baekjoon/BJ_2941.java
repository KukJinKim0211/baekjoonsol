package baekjoon;
// 크로아티아 알파벳
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2941 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String str = bf.readLine();
		
		if (str.indexOf("c=") != -1)
			str = str.replace("c=", "A");
		
		if (str.indexOf("c-") != -1)
			str = str.replace("c-", "A");
		
		if (str.indexOf("dz=") != -1)
			str = str.replace("dz=", "A");
		
		if (str.indexOf("d-") != -1)
			str = str.replace("d-", "A");
		
		if (str.indexOf("lj") != -1)
			str = str.replace("lj", "A");
		
		if (str.indexOf("nj") != -1)
			str = str.replace("nj", "A");
		
		if (str.indexOf("s=") != -1)
			str = str.replace("s=", "A");
		
		if (str.indexOf("z=") != -1)
			str = str.replace("z=", "A");
		
		System.out.println(str.length());
	}
}

