import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
*
1
9550 9556 9550 9553 9558 9551 9551 9551 
2
2419 2418 2423 2415 2422 2419 2420 2415 
3
7834 7840 7840 7835 7841 7835 7835 7838 
4
4088 4087 4090 4089 4093 4085 4090 4084 
5
2945 2946 2950 2948 2942 2943 2948 2947 
6
670 667 669 671 670 670 668 671 
7
8869 8869 8873 8875 8870 8872 8871 8873 
8
1709 1707 1712 1712 1714 1710 1706 1712 
9
10239 10248 10242 10240 10242 10242 10245 10235 
10
6580 6579 6574 6580 6583 6580 6577 6581 

*/



public class Solution_1225_SW문제해결기본7일차_암호생성기_김성식_큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		int in;
		
		for (int t = 1; t <= 10; t++) {
			// 변수선언부 ---------------------------
			int[] que = new int[1000000];
			int front = -1;
			int rear = -1;
			
			int subCnt = 1;
			// ----------------------------------
			
			in = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str, " ");
			while(stk.hasMoreTokens()) {
				que[++rear] = Integer.parseInt(stk.nextToken());
			}
		
			// 음
			// 
			// 일단 무한반복
			while(true) {
				// 꼬리가 0일 때까지 무한반복
				// front에서 subCnt만큼 빼준다.
				que[++front] -= subCnt;
				subCnt++;
				// 그리고 그걸 rear에 붙인다.
				que[++rear] = que[front];
				
				if(subCnt == 6) {
					subCnt = 1;					
				}			
				
				if( que[rear] <= 0) {
					que[rear] = 0;
					break;					
				}
			}
			
			
			
			int len = que.length;
			sb.append("#").append(t).append(" ");
			for (int i = front + 1; i <= rear; i++) {
				sb.append(que[i]).append(" ");				
			}
			sb.append('\n');
			
		}// end of testcase
		System.out.println(sb);
		
	} // end of main
} // end of class

