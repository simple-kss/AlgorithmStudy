package algo0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_1238_SW문제해결기본10일차_Contact_김성식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		

		
		for(int t = 1; t <= 10; t++) {
			
			StringTokenizer stk = new StringTokenizer(br.readLine().trim(), " ");
			ArrayDeque<Integer> q = new ArrayDeque<Integer>();
			boolean[] visited = new boolean[101];
			int[][] G = new int[101][101];
			int len = Integer.parseInt(stk.nextToken());
			int start = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < len/2; i++) {
				int s = Integer.parseInt(stk.nextToken());
				int e = Integer.parseInt(stk.nextToken());
				G[s][e] = 1;
			}
			
			visited[start] = true;
			
			for(int i = 1; i <= 100; i++) {
				if(G[start][i] == 1) {
					visited[i] = true;
					q.add(i);
				}
			}
			
			
			int max = 0;
			while(!q.isEmpty()) {
				// 스탭마다 max 초기화
				max = 0;
				int length = q.size();
				for(int z = 0; z < length; z++) {
					// 하나 꺼낸다
					int dest = q.poll();
					
					
					// 최댓값 초기화
					if(max < dest)
						max = dest;
					// 그 dest로 갈 수 있는거 넣기 방문 안한것 중에서.
					for(int i = 1; i <= 100; i++) {
						if(G[dest][i] == 1 && !visited[i]) {
							visited[i] = true;
							q.add(i);
						}
					}
					// 최댓값구하기
				} // end of for
				
			} // end of while
			
			
			sb.append('#').append(t).append(' ').append(max).append('\n');
		}
		System.out.println(sb);
		
		

	} // end of main
} // end of class
