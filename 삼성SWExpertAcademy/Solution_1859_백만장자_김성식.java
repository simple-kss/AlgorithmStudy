import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * 
 * 
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2
	
 *
 */

public class Solution_1859_백만장자_김성식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder("");
		String in = br.readLine();
		int T = Integer.parseInt(in);
		
		for(int t = 1; t <= T; t++) {
			in = br.readLine();
			int n = Integer.parseInt(in); // 길이
			int[] arr = new int[n]; // 숫자 저장
		
			in = br.readLine(); // 각 원소
			int arrCnt = 0;
			StringTokenizer stk = new StringTokenizer(in, " ");
			while(stk.hasMoreTokens()) {
				String s = stk.nextToken();
				arr[arrCnt++] = Integer.parseInt(s);
			}
			
			int max = arr[n-1];
			// 올라갈떄 물건산다
			long cache = 0L; // 현재 자금
			for (int i = n - 2; i >= 0; i--) {
				// max보다 낮으면 다 cache에 차이값 저장
				// 즉 산다
				if(max >= arr[i]) {
					cache += max - arr[i];
					//산다 
				}
				// max보다 큰게 나오면?
				// max를 갱신한다. 즉 안사도됨
				else {
					max = arr[i];
					//판다
				}
			}
			stb.append("#").append(t).append(" ").append(cache).append("\n");
		} // end of testcase
		System.out.println(stb);
	} // end of main
} // end of class
