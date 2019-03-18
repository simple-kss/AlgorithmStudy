import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1266_SW문제해결응용9일차_소수완제품확률_김성식 {
	
	static int[] sosu = {2, 3, 5, 7, 11, 13, 17};
	
	// combi를 구하는 간단한 방법!
	public static int combi(int n, int r) {
		if((n+1) / 2 <= r) {
			r = n - r;
		}
		int child = 1;
		int par = 1;
		
		for(int i = 1; i <= r ; i++) {
			
			child *= (n+1-i);
			par *= i;
		}
		return child / par;
	} // end of function
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int t = 1; t <= tc; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(stk.nextToken());
			int B = Integer.parseInt(stk.nextToken());
			double pA = (double)A / 100;
			double pB = (double)B / 100;
			
			// A가 소수일 확률, B가 소수일 확률
			double probA = 0;
			double probB = 0;
			
			double prob = 0;
			
			// 7개 경우의 수
			// 2 3 5 7 11 13 17을 구하자
			// 확률 모조리 구하기
			for(int i = 0; i < 7; i++) {
				probA += combi(18, sosu[i]) * Math.pow(pA, sosu[i]) * Math.pow((1-pA), 18 - sosu[i]);
				probB += combi(18, sosu[i]) * Math.pow(pB, sosu[i]) * Math.pow((1-pB), 18 - sosu[i]);
			}
			prob = probA + probB - probA * probB;
			// String.format 새로배운것
			sb.append('#').append(t).append(' ').append(String.format("%.6f", prob)).append('\n');
			
		} // end of for
		System.out.println(sb);

	} // end of main
	
} // end of class
