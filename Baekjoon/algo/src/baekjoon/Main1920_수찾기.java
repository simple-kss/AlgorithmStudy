package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1920_수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		
		int[] find = new int[M];
		 stk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			find[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(arr);
		
		
		for(int i = 0; i < M; i++) {
			if (binarySearch(arr, find[i]))
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		System.out.println(sb);
		
	} // end of main

	private static boolean binarySearch(int[] find, int value) {
		
		int start = 0;
		int end = find.length-1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(find[mid] == value) {
				return true;
			}
			else if(find[mid] < value) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return false;
	}

}
