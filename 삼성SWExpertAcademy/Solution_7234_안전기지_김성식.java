package algo0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7234_안전기지_김성식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine().trim());
		
		for(int t = 1; t <= tc; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(stk.nextToken());
			int B = Integer.parseInt(stk.nextToken());
			int map[][] = new int[N+4][N+4]; // start 2, end B+1
			
			for(int j = 0; j < B; j++) {
				stk = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(stk.nextToken()) + 1;
				int c = Integer.parseInt(stk.nextToken()) + 1;
				
				for(int i = 1; i <= 2; i++) {
					map[r+i][c]++;
					map[r-i][c]++;
				}
				for(int z = 1; z <= 2; z++) {
					map[r][c+z]++;
					map[r][c-z]++;
				}
			} // end of for
			
			int max = 0;
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(max < map[i][j]) max = map[i][j];
				}
			}
			
			sb.append('#').append(t).append(' ').append(max).append('\n');
		}
		System.out.println(sb);
	} // end of main
}
