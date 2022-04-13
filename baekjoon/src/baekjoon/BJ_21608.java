package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 상어 초등학교
public class BJ_21608 {
	static int N;
	static int[][] iArray;
	static int[][] iClass;
	static int[] delx = { -1, 0, 1, 0 };	// 상, 우, 하, 좌
	static int[] dely = { 0, 1, 0, -1 };	// 상, 우, 하, 좌
	static Queue<Student> que = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		int N2 = N * N;
		iArray = new int[N * N + 1][4];
		iClass = new int[N + 1][N + 1];
		for (int i = 0; i < N2; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int student = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				iArray[student][j] = Integer.parseInt(st.nextToken());
			}
			que.offer(new Student(student, iArray[student]));
		}
		setSeat();
		System.out.println(favoriteCheck());
	}
	
	static void setSeat() {
		// 첫번째 학생은 좌측 상단에 고정 배치
		Student stu = que.poll();
		iClass[2][2] = stu.mynum;
		
		while (!que.isEmpty()) {
			stu = que.poll();
			checkCondition(stu);
		}
	}
	
	// 1번 조건 (비어있는 칸 중 좋아하는 학생들이 가장 많이 인접한 곳을 찾기)
	static int[] checkCondition(Student stu) {
		int favocnt = 0;	// 좋아하는 학생의 수 최대값 저장
		int emptycnt = 0;	// 사방에 비어있는 자리수 최대값 저장
		int[] ipoint = new int[2];	// 1번
		for (int i = 1; i <= N; i++) {			// 행 반복
			for (int j = 1; j <= N; j++) {		// 열 반복
				if (iClass[i][j] != 0) continue;	// 학생이 앉은 자리는 넘어가기
				
				int favocount = 0;	// 사방에 좋아하는 학생의 수
				int emptycount = 0;	// 비어있는 칸의 갯수
				
				// 비어있는 칸을 사방탐색하여 좋아하는 학생의 인원수를 구하기
				for (int k = 0; k < 4; k++) {
					int dx = i + delx[k];
					int dy = j + dely[k];
					
					if (dx <= 0 || dx > N || dy <= 0 || dy > N) continue;	// 배열의 범위 바깥 체크
					if (iClass[dx][dy] == 0) {	// 빈 칸 체크
						emptycount++;				
						continue;
					}
					
					// 비어있지 않은 곳에 좋아하는 학생이 앉아있는지 체크
					for (int d = 0; d < stu.favorite.length; d++) {
						if (iClass[dx][dy] == stu.favorite[d]) {
							favocount++;
							break;
						}
					}
				}
				//////// 체크종료 ///////
				
				if (favocnt < favocount) {	// 사방에 좋아하는 학생의 수의 최대값이 갱신되어야 할 때
					// 현재 위치를 리턴해주기 위한 준비
					ipoint[0] = i;
					ipoint[1] = j;
					
					// 최대값 갱신
					favocnt = favocount;
					
					// 비어있는 좌석 저장
					emptycnt = emptycount;
					
				} 
				else if (favocnt == favocount) {	// 좋아하는 학생의 수가 중복되었을 시
					if (emptycnt < emptycount) {	// 현재 체크하고 있는 자리의 사방에 비어있는 자리가 더 많을 경우. (2번조건)
						// 현재 위치를 리턴해주기 위한 준비
						ipoint[0] = i;
						ipoint[1] = j;
						emptycnt = emptycount;
					}
				}
				
			}
		}
		// 조건에 해당하지 않는 예외에 관해선 행/열 기준 가장 작은 빈 칸에 학생을 앉힘
		boolean out = false;
		if (ipoint[0] == 0 && ipoint[1] == 0) {
			for (int i = 1; i <= N; i++) {
				if (out) break;
				for (int j = 1; j <= N; j++) {
					if (iClass[i][j] == 0) {
						iClass[i][j] = stu.mynum;
						out = true;
						break;
					}
				}
			}
		} else
			iClass[ipoint[0]][ipoint[1]] = stu.mynum;
		return ipoint;
	}
	
	// 만족도 체크
	static int favoriteCheck() {
		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int cal = 0;
				for (int d = 0; d < 4; d++) {
					int dx = i + delx[d];
					int dy = j + dely[d];
					
					if (dx <= 0 || dx > N || dy <= 0 || dy > N) continue;
					
					for (int k = 0; k < 4; k++) {
						if (iArray[iClass[i][j]][k] == iClass[dx][dy])
							cal++;
					}
				}
				if (cal == 1) result += 1;
				else if (cal == 2) result += 10;
				else if (cal == 3) result += 100;
				else if (cal == 4) result += 1000;
			}
		}
		
		return result;
	}
	
	static class Student {
		int mynum;
		int[] favorite;
		public Student(int mynum, int[] favorite) {
			this.mynum = mynum;
			this.favorite = favorite;
		}
	}
}
