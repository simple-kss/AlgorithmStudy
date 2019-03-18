package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main7576토마토 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int c = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		int[][] map = new int[r][c];
		ArrayList<int[]> one = new ArrayList<int[]>();
		
//		for(int i = 0; i < r+2; i++) {
//			map[i][0] = 9;
//			map[i][c+1] = 9;
//			
//		}
//		
//		for(int j = 0; j < c+2; c++) {
//			map[0][j] = 9;
//			map[r+1][j] = 9;
//		}
		
		for(int i = 0; i < r; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				one.add(new int[]{i, j});
			}
		}
		int oneSize = one.size();
		
		for(int i = 0; i < r; i++) {
		for(int j = 0; j < c; j++) {
			System.out.print(map[i][j]);
	
		}
		System.out.println();
	}
		
		

		int rear = -1;
		int front = -1;
//		
//		int[][] que = new int[1000000][3];
//		
//		int dir[][] = {
//				{-1, 0},//상
//				{ 0, 1},//우
//				{ 1, 0},//하
//				{ 0, -1}//좌
//		};
//		
//		// 큐에 원소 넣기 level 1
//		for(int i = 0; i < oneSize; i++) {
//			int[] point = one.get(i);
//			
//			for(int j = 0; j < 4; j++) {
//				int dr = point[0] + dir[j][0];
//				int dc = point[1] + dir[j][1];
//				
//			}
//			
//			
//		}
		
		
		// level 1돌리고
		// 다 1인지 체크
		// level 반환
		
//		for(int i = 0; i < r; i++) {
//			for(int j = 0; j < c; j++) {
//				System.out.print(map[i][j]);
		
//			}
//			System.out.println();
//		}
		
		
		
		
		

	} // end of main
} // end of class
