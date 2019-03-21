package algo0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1865_동철이의일분배_김성식{
	private static int N;
	private static double[][] data;
	private static double result;
	private static boolean[] visited;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			data = new double[N][N];
			visited = new boolean[N];
			result = Double.MIN_VALUE;
			
			//N만큼 돌면서 br.read
			for(int i = 0; i < N; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j < N; j++) {
					data[i][j] = Integer.parseInt(stk.nextToken()) / 100.0;
				}
			}
			
			// step, result 
			go(0, 1);
			
			result *= 100;
			
			sb.append('#').append(t).append(' ').append(String.format("%.6f", result)).append('\n');
		}
		System.out.println(sb);
		

	} // end of main

	private static void go(int step, double value) {
		if(value <= result) return;
		if(value == 0 ) return;
		
		if(step == N) {
			if(result < value)
				result = value;
			return;
		}
		else {
			for(int i = 0; i < N; i++) {
				if(visited[i])
					continue;
				visited[i] = true;
				go(step+1, value * (data[step][i] ));
				visited[i] = false;
				
				
			}
			
		}
		
	}

	
	
} // end of class
