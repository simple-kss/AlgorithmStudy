import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_3752_가능한시험점수_김성식 {
	
	static int[] arr;
	static int[] print;
	
	public static void main(String[] args) throws IOException {
		System.out.println(" ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc ; t++ ) {
			int N = Integer.parseInt(br.readLine()); // 길이
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int[] sum = new int[10001];
			print = new int[N]; 
			arr = new int[N];
			
			for(int i = 0; i < N; i ++) {
				arr[i] = Integer.parseInt(stk.nextToken());			
			}
			
			sum[0] = 1;
			int total = 1;
			// N은 arr의 길이
			for(int i = 0; i < N; i++) {

				for(int j = 10000; j >= 1; j--) {
					// 2개일떄
					// 만약 sum이 check 되어있다면
					// 그 번지와 arr[i]를 더한다!
					if(sum[j] != 0) {
						if(sum[j+arr[i]] == 0) {
							sum[j+arr[i]] = 1;
							total++;
							
						}

					}
				}
				if(sum[arr[i]] == 0) {
					sum[arr[i]] = 1;
					total++;
				}
				
			} // end of func
			
			
			// 1개만 더한거
			// 2개만 더한거
			// 3개만 더한거...
			// result와 check

			sb.append('#').append(t).append(' ').append(total).append('\n');
		}
		System.out.println(sb);

		

	} // end of main
	
	
} // end of class