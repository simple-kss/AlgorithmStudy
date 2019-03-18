package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1629_곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int op1 = Integer.parseInt(stk.nextToken());
		int op2 = Integer.parseInt(stk.nextToken());
		int mod = Integer.parseInt(stk.nextToken());
		int result = ((op1 % mod) * (op2 % mod)) % mod;
		
		System.out.println(op1 + " " + op2 + " " + mod);
		System.out.println(result);

	} // end of main

}
