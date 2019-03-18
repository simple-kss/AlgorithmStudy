package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int arr[][] = new int[100][100];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int z = 0; z < n; z++ ) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			for(int i = r; i < r + 10; i++) {
				for(int j = c; j < c + 10; j++) { 
					if(arr[i][j] == 0) {
						arr[i][j] = 1;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
		

	} // end of main
}
