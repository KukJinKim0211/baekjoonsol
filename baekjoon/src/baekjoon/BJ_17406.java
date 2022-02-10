package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 // 배열 돌리기4
public class BJ_17406 {
    
    static int[][] iArray;
    static int[][] rotation;
    static int min = Integer.MAX_VALUE;
    static int iN, iM;
    static boolean[] bvisited;
    static int[] result;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(bf.readLine());
        iN = Integer.parseInt(st.nextToken());
        iM = Integer.parseInt(st.nextToken());
        int iCount = Integer.parseInt(st.nextToken());
        
        iArray = new int[iN][iM];
        for(int i = 0; i < iN; i++) {
        	st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < iM; j++) {
                iArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        rotation = new int[iCount][3];
        for(int i = 0; i < iCount; i++) {
        	st = new StringTokenizer(bf.readLine());
            rotation[i][0] = Integer.parseInt(st.nextToken());
            rotation[i][1] = Integer.parseInt(st.nextToken());
            rotation[i][2] = Integer.parseInt(st.nextToken());
        }
        
        bvisited = new boolean[iCount];
        result = new int[iCount];
        permu(0, iCount);
        
        System.out.println(min);
    }    
    
    public static void permu(int idx, int k) {
        if(idx == k) {
            int[][] copy = new int[iN][iM];
            for(int i = 0; i < iN; i++) {
                for(int j = 0; j < iM; j++) {
                    copy[i][j] = iArray[i][j];
                }
            }
            
            findMin(copy);
            return;
        }
        
        for(int i = 0; i < k; i++) {
            if(bvisited[i] == false) {
                bvisited[i] = true;
                result[idx] = i;
                permu(idx + 1, k);
                bvisited[i] = false;
            }
        }
    }
    
    public static void findMin(int[][] copy) {
        for(int i = 0; i < result.length; i++) {
            int lx = rotation[result[i]][0] - rotation[result[i]][2] - 1;
            int ly = rotation[result[i]][1] - rotation[result[i]][2] - 1;
            int rx = rotation[result[i]][0] + rotation[result[i]][2] - 1;
            int ry = rotation[result[i]][1] + rotation[result[i]][2] - 1;
            rotate(lx, ly, rx, ry, copy); 
        }
        
        for(int i = 0; i < copy.length; i++) {
            int sum = 0;
            for(int j = 0; j < copy[i].length; j++) {
                sum += copy[i][j];
            }
            min = Math.min(min, sum);
        }
    }
    
    public static void rotate(int lx, int ly, int rx, int ry, int[][] copy) {
        if(lx == rx && ly == ry) 
            return;
        
        int[] temp = new int[3];
        temp[0] = copy[lx][ry];
        temp[1] = copy[rx][ry];
        temp[2] = copy[rx][ly];
        
        for(int i = ry; i > ly; i--) {
            copy[lx][i] = copy[lx][i - 1];
        }
        for(int i = rx; i > lx; i--) {
            if(i == lx + 1) copy[i][ry] = temp[0];
            else copy[i][ry] = copy[i - 1][ry];
        }
        for(int i = ly; i < ry; i++) {
            if(i == ry - 1) copy[rx][i] = temp[1];
            else copy[rx][i] = copy[rx][i + 1];
        }
        for(int i = lx; i < rx; i++) {
            if(i == rx - 1) copy[i][ly] = temp[2];
            else copy[i][ly] = copy[i + 1][ly];
        }    
        rotate(lx + 1, ly + 1, rx - 1, ry - 1, copy);
    }
}
