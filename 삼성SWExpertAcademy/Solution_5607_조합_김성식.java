import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합_김성식 {
	static final int P = 1234567891;
	static long[] factArr;
	
	public static int fact(int start, int end) {
		if(end == 1)
			return 1;
		else {
			// fact 구한다.
			long sum = 1;
			for (int i = start; i <= end; i++) {
				sum *= i;
				sum %= 1234567891;
			}
			return (int)sum;
		}
	}
	
	public static long pow(int num, int pow) {
		if(pow == 0)
			return 1;
		else if(pow == 1)
			return num;
		else if( pow % 2 == 0) {
			// 짝수일 때
			long temp = pow(num, pow / 2);
			return (temp * temp) % P;
		}
		else {
			//홀 수 일때
			long temp = pow(num, pow / 2);
			return (((temp * temp) % P) * num) % P;
//			return (pow(num, pow - 1) * num) % P;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder stb = new StringBuilder();
		
		
		for(int t = 1; t <= T ; t++ ) {
			StringTokenizer stk = new StringTokenizer(br.readLine()," ");
			int N = 0;
			int R = 0;
			while(stk.hasMoreTokens()) {
				N = Integer.parseInt(stk.nextToken());
				R = Integer.parseInt(stk.nextToken());
			}
			
			factArr = new long[N+1];
			for(int i = 1; i <= N; i++ ) {
				factArr[i] = factArr[i-1] * i % P;
			}
			
			// 분자구하기 !
			long sum = fact(N-R+1, N);
//			
			// r구하기 !
			int r = fact(1,R) % P;
			
			// r P-2승한거 구하기
			long tem = pow(r, P - 2) % P;
			
			sum = (sum * tem) % P;
			
			stb.append("#").append(t).append(" ").append(sum).append('\n');
			
		} // end of testCase
		
		System.out.println(stb);
	} // end of main
	
} // end of class
