package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N을 만드는데 최소 갯수는 dp[N]
// 3개 의 동전갯수
// 1, 4, 6원의 동전 갯수가 있다고 생각해보자
// 8원을 만든다고 생각해보자
// 그럼 dp[8]을 구하는 것이 목적
// dp[7] + 1, dp[4] + 1, dp[2] + 1, 3개 중에  최소를 선택하느 ㄴ것이다.

// 하지만 탑다운 방식으로 생각했지만
// 구현은 바텀업으로 생각한다.

// dp[i + c[j]] 최소 인걸 채택
public class DP_Main2000_동전교환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int coin[] = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int comN = Integer.parseInt(br.readLine()); //만들어야할 수(complete)

		
		// N은 coin의 갯수
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(stk.nextToken());
		}
		
		// 코인중 max값 찾기
		int maxN = 0;
		for (int i = 0; i < N; i++) {
			if(maxN < coin[i])
				maxN = coin[i];
		}
		
		int dp[] = new int[comN + 1 + maxN];
		
		for (int i = 0; i <= comN; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		// 초기화시키기
		for (int i = 0; i < N; i++) {
			dp[coin[i]] = 1;
		}
		

		// comN 내가 만들어야할 금액
		// N은 코인의 갯수
		for (int i = 1; i <= comN; i++) {
			if(dp[i] == Integer.MAX_VALUE) continue; // (주의★) 이거 안해서 오류났었음
			for (int j = 0; j < N; j++) {
				// 원래 있던거랑 코인하나더한거 중에 작은거 선택.
				dp[i + coin[j] ] = Math.min(dp[i] + 1, dp[i + coin[j] ]);
			}
		}
		
		if(dp[comN] == Integer.MAX_VALUE)
			System.out.println("impossible");
		else
			System.out.println(dp[comN]);
		
		
		

	}
}
