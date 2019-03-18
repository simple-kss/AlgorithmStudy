package algo0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Scat {
	int r;
	int c;
	int val;
	int time;
	public Scat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Scat(int r, int c, int val, int time) {
		super();
		this.r = r;
		this.c = c;
		this.val = val;
		this.time = time;
	}
}

class Point {
	int r;
	int c;
	int val;
	int time;
	public Point(int r, int c, int val, int time) {
		super();
		this.r = r;
		this.c = c;
		this.val = val;
		this.time = time;
	}
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

public class Solution_7250_탈출_김성식 {
	private static int N;
	private static int M;
	private static int K;
	private static char[][] map;
	
	static int[][] dir = {
			{-1, 0},
			{ 0, 1},
			{ 1, 0},
			{ 0 ,-1}
	};
	private static ArrayDeque<Point> fq = new ArrayDeque<Point>(); // fire queue
	private static ArrayDeque<Scat> sq = new ArrayDeque<Scat>(); // scat queue
	private static boolean[][] visited;
	private static boolean[][] visitedV;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= tc; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine().trim(), " ");
			
			// 변수 선언부
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			K = Integer.parseInt(stk.nextToken());
			map = new char[N+2][M+2];
			visited = new boolean[N+2][M+2];
			visitedV = new boolean[N+2][M+2];
			Point v = new Point();
			Point scat = new Point();
			
			// 초기화
			fq.clear();
			sq.clear();
			
			
			for(int z = 0; z < N+2; z++) {
				map[z][0] = 'X';
				map[z][M+1] = 'X';
			}
			for(int z = 0; z < M+2; z++) {
				map[0][z] = 'X';
				map[N+1][z] = 'X';
			}
			
			for(int i = 1; i <= N; i++) {
				String s = br.readLine().trim();
				int len = s.length();
				for(int j = 0; j < len; j++) {
					map[i][j+1] = s.charAt(j);
					if(map[i][j+1] == 'V') {
						v.r = i;
						v.c = j+1;
						v.val = 0;
					}
					else if(map[i][j+1] == 'S') {
						sq.add(new Scat(i, j+1, 0, K));
						visited[i][j+1] = true;
					}
					else if(map[i][j+1] == 'F') {
						fq.add(new Point(i, j+1, 0));
					}
				}
			} // end of for
			// 맵 셋팅
			
			
			//V가 갈 수 있는 최단경로부터 구하자!
			int vLen = findV(v);
			
			// 그리고 while돌려서 
			// burn 후
			// 스캇가기
			int sLen = 0;
			while(true) {
				// q사이즈만큼 돌면 그게 depth값
				sLen = goScat();
				if(sq.isEmpty() || sLen > 0) {
					break;
				}
				
				burn();
			}
			
			// 아.. 악당
			if(vLen <= sLen)
				sLen = -1;
			
			sb.append('#').append(t).append(' ').append(sLen).append('\n');
		} // end of test case
		System.out.println(sb);
		

	} // end of main

	private static int goScat() {
		int qLen = sq.size();
		
		for(int z = 0; z < qLen; z++) {
			Scat p = sq.poll();
			if(map[p.r][p.c] == 'A') {
				// 크기 축소 리셋
				p.time = K;
			}
			
			for(int i = 0; i < 4; i++) {
				int tr = p.r + dir[i][0];
				int tc = p.c + dir[i][1];
				
				// A이면 담기
				if(map[tr][tc] == 'A' && !visited[tr][tc]) {
					sq.add(new Scat(tr, tc, p.val+1, p.time));
					visited[tr][tc] = true;
				}
				
				// W이면 담긴하는데 
				// time이 0보다 클경우만 담는다.
				if(map[tr][tc] == 'W' && p.time > 0) {
					sq.add(new Scat(tr, tc, p.val+1, p.time - 1));
				}
				
				if(map[tr][tc] == 'E') {
					// 크기 축소 리셋
					return p.val+1;
				}
			}
		}
		return -1;
	} // end of goScat()

	private static void burn() {
		int qLen = fq.size();
		 
		for(int z = 0; z < qLen; z++) {
			Point p = fq.poll();
			
			for(int i = 0; i < 4; i++) {
				int tr = p.r + dir[i][0];
				int tc = p.c + dir[i][1];
				
				// W, X는 못감
				// W도 아니고 x도 아니면 담기
				if(map[tr][tc] == 'A' ) {
					map[tr][tc] = 'F';
					fq.add(new Point(tr, tc, p.val+1));
				}
			}
		}
	} // end of burn();

	private static int findV(Point v) {
		ArrayDeque<Point> q = new ArrayDeque<Point>();
		if(v.r == 0) return Integer.MAX_VALUE;
		q.add(v);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int tr = p.r + dir[i][0];
				int tc = p.c + dir[i][1];
				
				// W, X는 못감
				// W도 아니고 x도 아니면 담기
				if(map[tr][tc] != 'W' && map[tr][tc] != 'X' && !visitedV[tr][tc]) {
					q.add(new Point(tr, tc, p.val+1));
					visitedV[tr][tc] = true;
				}
				
				// 도착지에 도달했으면 p를 반환
				if(map[tr][tc]== 'E' ) {
					return p.val + 1;
				}
			}
		} // end of while;
		
		return Integer.MAX_VALUE;
	}
} // end of class
