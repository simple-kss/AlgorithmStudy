package baekjoon;

import java.util.Arrays;
import java.util.Scanner;


// 사전 순으로 증가

public class Main15656_N과M7 {

	static int n;
	static int[] arr;
	static int[] print;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void per(int start, int end) {
		if(start >= end) {
			for (int i : print) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		else {
			for(int i = 0; i < n; i++) {
				
//				if(visited[i]==true) continue;
//				
//				for(int j = 0; j < i; j++) {
//					if(arr[i] > arr[j])
//					visited[j] = true;
//				}
//				visited[i] = true;
				
				print[start] = arr[i];
				per(start+1, end);
				
//				visited[i] = false;
//				for(int j = 0; j < i; j++)
//					visited[j] = false;
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
