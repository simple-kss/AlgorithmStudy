package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Point {
	int r;
	int c;
}

public class Main3190_뱀 {
	static final int APPLE = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int appCnt = Integer.parseInt(br.readLine());
		int map[][] = new int[size+1][size+1];
		
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		ArrayDeque<Point> que = new ArrayDeque<Point>();
		
		for(int i = 0; i < appCnt; i++) {
			int appX = Integer.parseInt(stk.nextToken());
			int appY = Integer.parseInt(stk.nextToken());
			map[appX][appY] = APPLE;
		}
		
		int rootCnt = Integer.parseInt(br.readLine());
		for(int i = 0; i < rootCnt; i++) {
			int sec = Integer.parseInt(stk.nextToken());
			char dir = stk.nextToken().charAt(0);
			
			exec(sec, dir);
		}
	} // end of main
	
	private static void exec(int sec, char dir) {
		// TODO Auto-generated method stub
		
	}
} // end of class
