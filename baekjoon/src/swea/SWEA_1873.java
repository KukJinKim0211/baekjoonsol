package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int itestcase = Integer.parseInt(bf.readLine());
		
		for (int test1 = 1; test1 <= itestcase; test1++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int iRow = Integer.parseInt(st.nextToken());
			int iCol = Integer.parseInt(st.nextToken());
			
			// 지형지물 배치
			char[][] cArray = new char[iRow][iCol];

			String str;
			
			// 탱크의 인덱스 관리용 변수
			int iTankX = 0;
			int iTankY = 0;
			
			// 탱크가 보고있는 방향 좌(0, -1) 상(-1, 0) 우(0, 1) 하(1, 0)
			int[][] iDirection = { {0, -1}, {-1, 0}, {0, 1}, {1, 0} };
			
			// iDirection 2차원배열의 인덱스 관리. 탱크가 보고있는 방향에 따라 바뀜 0=좌 1=상 2=우 3=하
			int iDirecIndex = 0;
			
			for (int i = 0; i < iRow; i++) {
				str = bf.readLine();
				for (int j = 0; j < iCol; j++) {
					cArray[i][j] = str.charAt(j);
					
					// 미리 탱크의 위치를 알아놓고 인덱스로 관리
					if (cArray[i][j] == '<' || cArray[i][j] == '^' || cArray[i][j] == '>' || cArray[i][j] == 'v') {
						iTankX = i;
						iTankY = j;
						
						// 탱크가 보고있는 위치를 관리
						if (cArray[i][j] == '<')
							iDirecIndex = 0;
						else if (cArray[i][j] == '^')
							iDirecIndex = 1;
						else if (cArray[i][j] == '>')
							iDirecIndex = 2;
						else
							iDirecIndex = 3;
					}
				}
			}
			
			int inputcnt = Integer.parseInt(bf.readLine());
			str = bf.readLine();
			char[] cinput = new char[inputcnt];
			
			for (int i = 0; i < inputcnt; i++) {
				cinput[i] = str.charAt(i);
			}

			int i = 0;
			while (true) {
				// 입력 처리 완료 후 while문 이탈
				if (i >= inputcnt)
					break;
				// S키 입력 시, 현재 보고있는 방향으로 포탄 발사
				if (cinput[i] == 'S') 
				{
					int iArrayCnt = 1;
					// 배열의 끝까지 탐색
					while (true) {
						int iNextX = iTankX + iDirection[iDirecIndex][0] * iArrayCnt;
						int iNextY = iTankY + iDirection[iDirecIndex][1] * iArrayCnt;
						// 배열의 끝에 도달 시, 반복문이탈
						if ((iNextX < 0 || iNextX >= iRow) || (iNextY < 0 || iNextY >= iCol) )
							break;
						
						// 미사일이 (*)벽돌을 만났을 시, (.) 평지로 만들고 반복문 종료
						if (cArray[iNextX][iNextY] == '*') {
							cArray[iNextX][iNextY] = '.';
							break;
						}
						// 미사일이 (#)강철벽을 만났을 시, 미사일이 소멸되고 반복문 종료
						else if (cArray[iNextX][iNextY] == '#')
						{
							break;
						}
						
						iArrayCnt++;
					}
					i++;
					continue;
				}
				// U키 입력 시 전차 방향 위쪽 설정. 위 한칸이 평지일 시 탱크 한칸 이동
				else if (cinput[i] == 'U'){
					iDirecIndex = 1;
					cArray[iTankX][iTankY] = '^';
				}
				// D키 입력 시 전차 방향 아래쪽 설정. 아래 한칸이 평지일 시 탱크 한칸 이동
				else if (cinput[i] == 'D'){
					iDirecIndex = 3;
					cArray[iTankX][iTankY] = 'v';
				}
				// L키 입력 시 전차 방향 왼쪽 설정. 왼쪽 한칸이 평지일 시 탱크 한칸 이동
				else if (cinput[i] == 'L'){
					iDirecIndex = 0;
					cArray[iTankX][iTankY] = '<';
				}
				// R키 입력 시 전차 방향 오른쪽 설정. 오른쪽 한칸이 평지일 시 탱크 한칸 이동
				else if (cinput[i] == 'R'){
					iDirecIndex = 2;
					cArray[iTankX][iTankY] = '>';
				}
				
				i++;
				
				if ( (iTankX + iDirection[iDirecIndex][0] < 0 || iTankX + iDirection[iDirecIndex][0] >= iRow) || 
					 (iTankY + iDirection[iDirecIndex][1] < 0 || iTankY + iDirection[iDirecIndex][1] >= iCol) )
					continue;
				
				// 탱크가 바라보고있는 방향에 평지가 있는지 체크. 평지일 시, 위치 변경
				if (cArray[iTankX + iDirection[iDirecIndex][0]][iTankY + iDirection[iDirecIndex][1]] == '.')
				{
					char ctemp = cArray[iTankX][iTankY];
					cArray[iTankX][iTankY] = cArray[iTankX + iDirection[iDirecIndex][0]][iTankY + iDirection[iDirecIndex][1]];
					cArray[iTankX + iDirection[iDirecIndex][0]][iTankY + iDirection[iDirecIndex][1]] = ctemp;
					
					iTankX += iDirection[iDirecIndex][0];
					iTankY += iDirection[iDirecIndex][1];
				}
			} // 입력키 처리 while문 종료 Part
			System.out.printf("#%d ", test1);
			for (char c1[] : cArray) {
				for (char c: c1) {
					System.out.printf("%s", c);
				}
				System.out.println();
			}
		} // Test Case For문 종료 Part
	}
}
