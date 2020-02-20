package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.net.ssl.SSLContext;

public class Main14939_불끄기 {
	static int[][] dir = {
		{ 0, 1},
		{ 1, 0},
		{-1, 0},
		{ 0,-1}
	};
	
	
	public static void main(String[] args) throws IOException {
		

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[12][12];
		
		for(int i = 0; i < 12; i++) {
			map[0][i] = 9;
			map[11][i] = 9;
			map[i][0] = 9;
			map[i][11
			       ] = 9;
		}
		
		for(int i = 1; i <= 10; i++) {
			String s = br.readLine();
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '#') {
					map[i][j+1] = 0;
				}
				else {
					map[i][j+1] = 1;
				}
			}
		}
		
		int maxCnt = 0;
		
		// 조합으로 첫재쭐을 만든다.
		
		
		
		int cnt = 0;
		// 내 자신이 켜져있으면
		// 그 아래의 행의 스위치를 킨다.
		for(int i = 2; i <= 9; i++) {
			for(int j = 1; j<= 10; j++) {
				if(map[i-1][j] == 1) {
					cnt++;
					turnOn(map, i+1, j);
				}
			}
		}
		
		if(maxCnt < cnt) maxCnt = cnt;
		
		System.out.println("123");
		
		

	} // end of main

	private static void turnOn(int[][] map, int r, int c) {
		for(int i = 0; i < 4; i++ ) {
			int tr = r + dir[i][0];
			int tc = c + dir[i][1];
			map[tr][tc] = map[tr][tc] ^ 1; // 1이면 0, 0이면 1
		}
		
	} // end of func
	
} // end of class