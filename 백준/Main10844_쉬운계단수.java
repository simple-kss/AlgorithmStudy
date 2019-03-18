package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main10844_쉬운계단수 {
	static int mod = 1000000000;
	public static void main(String[] args) {
		// 0일때
		// 1~8일때
		// 9일때 각각의 DP가 다르다.
		
		Scanner scan = new Scanner(System.in);
		
		int[][] dp = new int[101][10];
		
		for(int i = 1; i < 10; i++ ) {
			dp[1][i] = 1;
		}
		
		for(int j = 2; j <= 100; j++) {
			for(int i = 0; i < 10; i++) {
				if(i == 0) {
					dp[j][0] = dp[j-1][1] % mod;
				}
				else if(i == 9) {
					dp[j][9] = dp[j-1][8] % mod;
				}				
				else {
					dp[j][i] = (dp[j-1][i-1] + dp[j-1][i+1]) % mod;			
				}
			}
		} // end of for
		
		long sum = 0;
		int input = 0;
		input = scan.nextInt();
		for(int i = 0; i <= 9; i++) {
			sum = (sum + dp[input][i] ) % mod;
		}
		System.out.println(sum);
		
		

	} // end of main
} // end of class