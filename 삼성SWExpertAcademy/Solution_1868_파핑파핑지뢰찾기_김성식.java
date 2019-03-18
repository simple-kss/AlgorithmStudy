package algo0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1868_파핑파핑지뢰찾기_김성식 {
	static int dir[][] = { // 8방향
			{-1, -1},
			{-1,  0},
			{-1,  1},
			{ 0, -1},
			
			{ 0,  1},
			
			{ 1, -1},
			{ 1,  0},
			{ 1,  1}
	};
	
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		// 변수 선언부---------------------
		int N = 0;
		char[][] map = null;
		int[][] value = null;
		visited = null;
		

		for(int t = 1; t <= tc; t++) {
			// 변수 초기화부---------------------
			N = Integer.parseInt(br.readLine()); // N바이 N행렬
			map = new char[N+2][N+2];		// 맵 정보 저장
			value = new int[N+2][N+2];		// 각 지점들 주위에 지뢰가 몇개있는지 저장
			visited = new boolean[N+2][N+2]; // 0으로 퍼졌는지 안퍼졌는지 check
			int count = 0;					// 몇번 클릭할지 셈
			
			
			for (int i = 0; i < N+2; i++) {
				map[0][i] = 'X';
				map[i][0] = 'X';
				map[N+1][i] = 'X';
				map[i][N+1] = 'X';
				
				value[0][i] = -2;
				value[i][0] = -2;
				value[N+1][i] = -2;
				value[i][N+1] = -2;
			}
			
			for(int i = 1; i <= N; i++) {
				String s = 'X' + br.readLine() + 'X';
				map[i] = s.toCharArray();
			} // end of for
			
			// *인 것에 대해서 가중치를 증가하자.
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					if(map[i][j] == '*') {
						value[i][j] = -1;
						// 8방향 가중치 증가.
						for(int z = 0; z < 8; z++) {
							int r = i + dir[z][0];
							int c = j + dir[z][1];
							if(map[r][c] == '.')
								value[r][c]++;
						}
					}
				} // end of for
			} // end of for2
			
			
			
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					// 0이고 방문안한경우에만 탐색
					if(value[i][j] == 0 && !visited[i][j]) {
						bfs(i,j, value);
						count++;
					}
				}
			}
			
			// 그런다음 visited가 false이고
			// 숫자인 거를 센다.!!
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					if(value[i][j] >= 1 && !visited[i][j]) {
						count++;
					}
				}
			}
			
			
			sb.append('#').append(t).append(' ').append(count).append('\n');
		}
		System.out.println(sb);
		
	} // end of main

	private static void bfs(int i, int j, int[][] value) {
		ArrayDeque<Point> q = new ArrayDeque<Point>();
		
		q.add(new Point(i, j, 0));
		
		while(!q.isEmpty()) {
			Point start = q.poll();
			
			// 큐에서 꺼낸 값이 0이라면 진행
			if(value[start.r][start.c] == 0 ) {
				visited[start.r][start.c] = true;
				for(int z = 0; z < 8; z++) {
					int r = start.r + dir[z][0];
					int c = start.c + dir[z][1];
					
					// 큐담기!
					if(value[r][c] == 0 && !visited[r][c])
						q.add(new Point(r, c, 0));
					
					// 0인 지점에서의 8방향들은
					// 다 방문했음으로 만든다.
					visited[r][c] = true;
				}
				
			} // end of for
			
			
		} // end of Queueueeeeee
	} // end of func
}

class Point {
	int r;
	int c;
	int val;
	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Point(int r, int c, int val) {
		super();
		this.r = r;
		this.c = c;
		this.val = val;
	}
	
	
}
