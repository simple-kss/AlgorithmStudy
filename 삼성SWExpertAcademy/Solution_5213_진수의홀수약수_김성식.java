import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 약수는 항상 누군가의 배수다!
// 홀수가 약수면 개는 홀수의 배수이다!

public class Solution_5213_진수의홀수약수_김성식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		long[] arr = new long[1000001];
		
		// R의 범위 1000000
		// 홀수의 배수로 각 숫자의 약수홀수 합을 구하자.
		for(int i = 1; i <= 1000000; i += 2) {
			// i는 홀수만
			// i*j가 1000000를 안넘는 
			// 배수들에다가 i를 더한다. 그래야 홀수약수의 합이 누적되므로
			for(int j = 1; i*j <= 1000000 ; j++) {
				arr[i*j] = arr[i*j] + i;
			}
		}	
		
		for(int i = 1; i <= 1000000; i++) {
			arr[i] += arr[i-1];
		}
		
		for(int t = 1; t <= tc; t++ ) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stk.nextToken())-1;
			int n2 = Integer.parseInt(stk.nextToken());
			
			long cnt = arr[n2] - arr[n1];

			
			sb.append('#').append(t).append(' ').append(cnt).append('\n');
			
		} // end of testCase
		
		System.out.println(sb);

	} // end of main

} // end of class