package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15655_N과M6 {
	static int[] print;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(stk.nextToken());
		int sN = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine(), " ");
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(arr);
		print = new int[sN];
		
		// start, step, end, len
		combi(0, 0, sN, n);
		
		System.out.println(sb);
	} // end of main
	
	private static void combi(int start, int step, int sN, int n) {
		if(step == sN) {
			for(int i = 0; i < sN; i++) {
				sb.append(print[i]).append(' ');
			}
			sb.append('\n');
		}
		else {
			for(int i = start; i < n; i++) {
				print[step] = arr[i];
				combi(i+1, step+1, sN, n);
			}
		}
		
		
	}
} // end of class