package baekjoon;

import java.awt.geom.IllegalPathStateException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_설탕배달2839_saumsung {
	private static int N;
	private static int[] dp;
	private static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int numA = Integer.parseInt(stk.nextToken());
			int numB = Integer.parseInt(stk.nextToken());
			int N = Integer.parseInt(stk.nextToken());
			
			dp = new int[N+1];
			for (int i = 1; i <= N; i++) {
				dp[i] = Integer.MAX_VALUE;
			}
			if(N >= numA) dp[numA] = 1;
			if(N >= numB) dp[numB] = 1;
			
			for (int i = 1; i <= N; i++) {
				if(dp[i] != Integer.MAX_VALUE) {
					if(i+numA <= N) dp[i+numA] = Math.min(dp[i+numA], dp[i] + 1);
					if(i+numB <= N) dp[i+numB] = Math.min(dp[i+numB], dp[i] + 1);
				}
			}
			if(dp[N] == Integer.MAX_VALUE) System.out.println("#" + t + " -1");
			else System.out.println("#" + t + " " + dp[N]);
		}
		


	}

}
