package baekjoon;

import java.awt.geom.IllegalPathStateException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_설탕배달2839 {
	private static int N;
	private static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		if(N >= 3) dp[3] = 1;
		if(N >= 5) dp[5] = 1;
		
		for (int i = 1; i <= N; i++) {
			if(dp[i] != Integer.MAX_VALUE) {
				if(i+5 <= N) dp[i+5] = Math.min(dp[i+5], dp[i] + 1);
				if(i+3 <= N) dp[i+3] = Math.min(dp[i+3], dp[i] + 1);
				
			}
		}
		if(dp[N] == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(dp[N]);

	}

}
