package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15729_방탈출 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		boolean arr[] = new boolean[N+2];
		int cnt = 0;
		while(stk.hasMoreTokens()) {
			int a = Integer.parseInt(stk.nextToken());
			
			if(a == 1)
				arr[cnt++] = true;
			else
				arr[cnt++] = false;
		}
		
		int cn = 0;
		// 1을 발견하면 자기것과 오른쪽 2개를 반전한다.
		for (int i = 0; i < N; i++) {
			if(arr[i]) {
				arr[i] = !arr[i];
				arr[i+1] = !arr[i+1];
				arr[i+2] = !arr[i+2];
				cn++;
				
			}
		}
		System.out.println(cn);

	} // end of main
} // end of class
