package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15651_N과M3 {
	static StringBuilder sb = new StringBuilder();
	
	public static void makePer(int N ,int[] num, int[] per, int sN, int step, boolean[] visited) {
		
		if(step == sN) {
			for(int i = 0; i < sN; i++) {
				sb.append(per[i]).append(' ');
			}
			sb.append('\n');
			
		}
		else {
			for(int i = 0; i < N; i++) {
				per[step] = num[i];
				makePer(N, num, per, sN, step + 1, visited);

				
			}
		}
		
	} // end of func
	
	public static void main(String[] args) throws IOException {
		// 재귀로 짜자.
		// DFS로!
		// visited도 만들고
		
		// String 만들어서
		// 그걸 오름차순으로 정렬
		
//		4 2
		
//		1 2
//		1 3
//		1 4
//		2 3
//		2 4
//		3 4
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(stk.nextToken());
		int sN = Integer.parseInt(stk.nextToken());
		
		int[] num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = i + 1;
		}
		
		int[] per = new int[sN];
		
		makePer(N, num, per, sN, 0, new boolean[N]);
		
		System.out.println(sb);

	} // end of main
	
	
} // end of class
