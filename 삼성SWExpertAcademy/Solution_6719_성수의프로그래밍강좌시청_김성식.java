import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_6719_성수의프로그래밍강좌시청_김성식 {
	static int[] B = new int[201];
	public static int calc(int num, int pow) {
		if(pow == 0)
			return 1;
		else if(pow == 1)
			return num;
		else if( B[pow] != 0)
			return B[pow];
		else if( pow % 2 == 0){ // 짝수라면
			if(B[pow/2] != 0) return B[pow/2] * B[pow/2];
			int temp = calc(num, pow / 2);
			return temp * temp;
		}
		else {
			pow--;
			int temp = calc(num, pow / 2);
			return temp * temp * 2;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			int N = 0;
			int K = 0;
			StringTokenizer stk = new StringTokenizer(br.readLine()," ");
			while(stk.hasMoreTokens()) {
				N = Integer.parseInt(stk.nextToken());
				K = Integer.parseInt(stk.nextToken());
			}
			
			int[] numArr = new int[N];
			int[] nArr = new int[N];
			
			stk = new StringTokenizer(br.readLine()," ");
			int cnt = 0;
			while(stk.hasMoreTokens()) {
				numArr[cnt++] = Integer.parseInt(stk.nextToken());
			}
			
			// 입력부 끝
			
			// -----------------------------------------
			Arrays.sort(numArr);
			for (int i = 0; i < N; i++) {
				nArr[N-1-i] = numArr[i]; // 내림차순으로 바꿈
			}
//			
//			// 이제 k개 선택해서 
//			
//			// 2^(몇번째 선택인지)로 나눌꺼임
//			// K개 선택이므로 2^K승까진 구해야함
//			// 2^K승을 구하자.
//			
//			// 구했다 치고 이제 합을 구하자
//			
//			double sum = 0;
//			
//			for (int i = 0; i < K; i++) {
//				sum += (double)nArr[i] / (double)calc(2, i+1);
//			}
			double sum = 0;
			for(int i = 0; i < K; i++) {
//				System.out.print(numArr[N-K+i] + " ");
				sum = (sum + (double)numArr[N-K+i]) / 2;
				
			}
//			System.out.println();
			// -----------------------------------------
			
			sb.append("#").append(t).append(" ").append(sum).append('\n');
		} // end of test case
		System.out.println(sb);
		

	} // end of main
} // end of class
