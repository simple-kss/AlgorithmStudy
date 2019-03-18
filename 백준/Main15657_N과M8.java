package baekjoon;

import java.util.Arrays;
import java.util.Scanner;


// 사전 순으로 증가

/*
 * 
 * 
4 2
9 7 9 1
 */

public class Main15657_N과M8 {

	static int n;
	static int[] arr;
	static int[] print;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void per(int start, int end) {
		if(start >= end) {
			for (int i = 0 ; i < end; i++) {
				sb.append(print[i]).append(" ");
			}
			sb.append("\n");
		}
		else {
			for(int i = 0; i < n; i++) {
				
				if(visited[i]==true) continue;
//				
				
				//크기가 큰거 검사
//				for(int j = 0; j < i; j++) {
//					if(arr[i] > arr[j])
//					visited[j] = true;
//				}
				// 중복하는 거 검사
//				for(int j = i+1; j < n; j++) {
//					if(arr[i] == arr[j])
//					visited[i] = true;
//				}
//				if(visited[i]==true) continue;
//
//				visited[i] = true;
				
				print[start] = arr[i];
				// arr[i]값이 같은 애들 다 true
				// 마지막 per 들어갈 때  true
				if(start+1 == end)
					visited[i] = true;
				per(start+1, end);
//				
//				visited[i] = false;
//				for(int j = 0; j < n; j++)
//					if(arr[i] == arr[j])
//					visited[i] = false;
//				for(int j = 0; j < i; j++) {
//					if(arr[i] > arr[j])
//					visited[j] = false;
//				}
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int cnt = scan.nextInt();
		
		arr = new int[n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		print = new int[cnt];
		
		
		per(0, cnt);
		System.out.println(sb);
		

	}
}
