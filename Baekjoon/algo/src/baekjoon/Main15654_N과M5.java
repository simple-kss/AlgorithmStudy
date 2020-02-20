package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main15654_N과M5 {
	
	static int n;
	static int[] arr;
	static int[] print;
	static boolean[] visited;
	
	public static void per(int start, int end) {
		if(start >= end) {
			for (int i : print) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		else {
			for(int i = 0; i < n; i++) {
				
				if(visited[i]==true) continue;
				// �� ���� �͵� true �ֳĸ�
				// ���� �� ������ �и��ϹǷ�
				for(int j = 0; j < i; j++) {
					if(arr[i] > arr[j])
					visited[j] = true;
				}
//				visited[i] = true;
				
				print[start] = arr[i];
				per(start+1, end);
				
//				visited[i] = false;
				for(int j = 0; j < i; j++)
					visited[j] = false;
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
		

	}

}
