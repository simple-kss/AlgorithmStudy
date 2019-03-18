import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1493_수의새로운연산_김성식 {
	public static void main(String[] args) throws IOException {
		System.out.println(" ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[301][301];
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		int a = 1;
		int sum = 0;
		for(int j = 1; j <= 300; j++) {
			// j열을 구하기!
			sum += j;
			arr[1][j] = sum;
		}
		// 첫째항 다구했다.
		
		for(int j = 1; j <= 300; j++) {
			int ac = 0;
			for (int i = 2; i <= 300; i++) {
				// j열에 해당하는만큼 더해진다.
				ac = arr[i-1][j] + i - 2 + j;
				
				
				arr[i][j] = ac;
				
				
				
				
			} // end of for
		} // end of for
		
		for(int t = 1 ; t <= tc ; t++) {
			
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			
			int n1R = 0;
			int n1C = 0;
			int n2R = 0;
			int n2C = 0;
			
			// n1과 n2를 찾는다.
			for(int i = 1; i <= 300; i++) {
				for (int j = 1; j <= 300; j++) {
					if(arr[i][j] == n1) {
						n1R = i;
						n1C = j;
					}
					
					if(arr[i][j] == n2){
						n2R = i;
						n2C = j;
					}
					
					
				} // end of for
			} // end of for
			
			sb.append('#').append(t).append(' ').append(arr[n1R+n2R][n1C+n2C]).append('\n');
		}
		System.out.println(sb);

	} // end of main
} // end of class