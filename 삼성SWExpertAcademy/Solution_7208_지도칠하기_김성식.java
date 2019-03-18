package algo0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_7208_지도칠하기_김성식 {
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= tc; t++ ) {
			// 변수선언부!
			int N = Integer.parseInt(br.readLine()); //나라 수~
			int[] color = new int[N];
			int[][] map = new int[N][N];
			
			String s = br.readLine();
			
			// 초기 나라 컬러
			for(int i = 0; i < N * 2; i += 2) {
				color[i/2] = s.charAt(i)-'0'-1;
			}
			
			
			for(int i = 0; i < N; i++) {
				s = br.readLine();
				for(int j = 0; j < N * 2; j+=2) {
					map[i][j/2] = s.charAt(j)-'0';
				}
			}
			
			
			count = Integer.MAX_VALUE;
			
			// 첫번째 번지부터 할까
			dfs(0, N, color, map, 0);
			// 위험한지 안한지 검사
			// 모든거 위험하면 -1
			
			
			
			
			
//			System.out.println("123");
			
			sb.append('#').append(t).append(' ').append(count).append('\n');
		} // end of for
		System.out.println(sb);

	} // end of main

	// i: 번지, N:나라수, color: 컬러정보, map: 인접행렬정보
	private static void dfs(int index, int N, int[] color, int[][] map, int cnt) {
		int temp[] = color.clone();
		
		if(index >= 4) {
			if(count > cnt)
				count = cnt;
			return;
		}
		
		// 같은게 나왔으면
		if(!isDiffer(index, map, temp)) {
			// 색 바꾸고 
			// count 증가하고
			// 다음꺼
			
			for(int i = 1; i <= 3; i++) {
				
				// 자기자신 색깔 바꾼다.
				temp[index] = (color[index] + i) % 4;
				dfs(index+1, N, temp, map, cnt+1);

			}
		}
		else {
			dfs(index+1, N, temp, map, cnt);
		}

		
	} // end of func
	
	// 잘 칠해져있는지를 검사한다. i번째 행이
	public static boolean isDiffer(int index, int[][] map, int[] color) {
		int cLen = color.length;
		int N = map.length;
		for(int i = 0; i < N; i++) {
			// 이어져있고
			if(map[index][i] == 1) {
				// 같다면 true
				if(color[index] == color[i]) {
					return false;
				}
			}
		}
		return true;
		
	} // end of func
	
} // end of class