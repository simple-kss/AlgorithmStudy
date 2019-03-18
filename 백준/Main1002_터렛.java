package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 
 * 
 * 
5
0 0 13 40 0 37
0 0 3 0 7 4
1 1 1 1 1 5
0 0 5 0 0 5
0 0 5 1 1 5




 *
 */


public class Main1002_터렛 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int testCase = Integer.parseInt(s);
		
		for(int t = 1; t <= testCase; t++) {
			s = bf.readLine();
			int x1 = 0, y1 = 0, r1 = 0;
			int x2 = 0, y2 = 0, r2 = 0;
			StringTokenizer stk = new StringTokenizer(s, " ");
			while(stk.hasMoreTokens()) {
				String temp = stk.nextToken();
				x1 = Integer.parseInt(temp);
				temp = stk.nextToken();
				y1 = Integer.parseInt(temp);
				temp = stk.nextToken();
				r1 = Integer.parseInt(temp);
				temp = stk.nextToken();
				x2 = Integer.parseInt(temp);
				temp = stk.nextToken();
				y2 = Integer.parseInt(temp);
				temp = stk.nextToken();
				r2 = Integer.parseInt(temp);
			}
			
			int dx = 0, dy = 0;
			
			dx = x2 - x1;
			dy = y2 - y1;
			double val = dx*dx + dy*dy;
			double distance = Math.sqrt(val);
			
			int rDistance = r1 + r2;
			
			int bigR = 0, smallR = 0; 
			if( r1 > r2) {
				bigR = r1;
				smallR = r2;
			}
			else {
				bigR = r2;
				smallR = r1;				
			}
			
//			System.out.println(" ");
//			System.out.println(distance);
//			System.out.println(rDistance);
			
			// 둘이 일치하는 경우
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				System.out.println(-1);
				continue;
			}
			// 둘이 원 안에 있따면 (큰 원의 반지름보다 둘 사이의 거리가 작다면)
			// 작은 원의 중심이 큰 원에 있따는 얘기
			if(distance <= (double)bigR){
				// 큰 원 경로에 작은 원의 중심이 잇는 경우!
				if(distance == (double)bigR) {
					System.out.println(2);					
				}
				// 작은원이 큰원 안에 있는데 2점이 접한 경우
				else if(distance + (double)smallR > (double)bigR) {
					System.out.println(2);
				}
				
				// 큰 원에 작은 원이 있는 경우인데 한 점에만 접하는 경우!
				else if(distance + (double)smallR == (double)bigR) {
					System.out.println(1);
				}

				// 큰 원 안에 작은원이 있는데 떠있는 경우
				else {
					System.out.println(0);
				}
			}
			else {
				// 둘이 원 밖에 있다면
				if(distance > (double)rDistance) {
					System.out.println(0);
				}
				else if(distance == (double)rDistance) {
					System.out.println(1);
				}
				else
					System.out.println(2);
			} // end of if&else
			
			
		} // end of testcase
	} // end of main
}
