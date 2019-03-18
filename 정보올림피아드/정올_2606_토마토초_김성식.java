package algo0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;


class Point {
	int r;
	int c;
	int z;
	int val;
	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Point(int r, int c, int z, int val) {
		super();
		this.r = r;
		this.c = c;
		this.z = z;
		this.val = val;
	}
	
	
}

public class 정올_2606_토마토초_김성식 {
	static int dir[][] = {
			// 6방향
			{-1, 0, 0}, // 상
			{ 0, 1, 0}, // 우
			{ 1, 0, 0}, // 하
			{ 0,-1, 0}, // 좌
			
			{0, 0, 1},  // up
			{0, 0,-1}   // down
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		Scanner sc = new Scanner(System.in);
		
//		int C = Integer.parseInt(stk.nextToken());
//		int R = Integer.parseInt(stk.nextToken());
//		int H = Integer.parseInt(stk.nextToken());
		int date = 0;
		
		int C = sc.nextInt();
		int R = sc.nextInt();
		int H = sc.nextInt();
		
		ArrayDeque<Point> aq = new ArrayDeque<Point>();
		
		
		// 행 렬 높이
		int[][][] map = new int[R+2][C+2][H+2];
		
		for(int i = 0; i < R + 2; i++) {
			for(int j = 0; j < C + 2; j++) {
				Arrays.fill(map[i][j], 9); // 9로 채우기!
			}
		}
		
		
		for(int h = 1; h <= H; h++) {
			for(int i = 1; i <= R; i++) {
				for(int j = 1; j <= C; j++) {
					map[i][j][h] = sc.nextInt();
				}
			}
		}
		
		
		
//		for(int h = 1; h <= H; h++) {
//			for(int i = 1; i <= R; i++) {
//				stk = new StringTokenizer(br.readLine(), " ");
//				for(int j = 1; j <= C; j++) {
//					map[i][j][h] = Integer.parseInt(stk.nextToken());
//				}
//			}
//		}
		
		
		// 사방에 0인거 검사 후 큐에 넣기
		for(int h = 1; h <= H; h++) {
			for(int i = 1; i <= R; i++) {
				for(int j = 1; j <= C; j++) {
					if(map[i][j][h] == 1)
						aq.add(new Point(i,j,h,0));
				}
			}
		}
		
		while(!aq.isEmpty()) {
			Point p = aq.poll();
			date = p.val;
			
			// 하나를 꺼내서 주위에 0이 있으면
			// 그걸 담기전 1로 만들고 
			// 담는다.
			for(int i = 0; i < 6; i++ ) {
				int r = p.r + dir[i][0];
				int c = p.c + dir[i][1];
				int z = p.z + dir[i][2];
				int val = p.val + 1;
				
				if(map[r][c][z] == 0) {
					map[r][c][z] = 1;
					aq.add(new Point(r,c,z,val));
				}
			} // end of for
		}
		
		boolean isNOT = false;
loop:	for (int h = 1; h <= H; h++) {
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if(map[i][j][h] == 0) {
						isNOT = true;
						break loop;
					}
				}
			}
		}
		
		if(isNOT) System.out.println("-1");
		else System.out.println(date);
		
		

	} // end of main
} // end of class





