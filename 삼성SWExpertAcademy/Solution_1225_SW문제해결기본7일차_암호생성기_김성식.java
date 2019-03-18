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

public class Solution_1225_SW문제해결기본7일차_암호생성기_김성식 {
	
	// 큐를 안쓰고 
	// 배열로만 이용한 풀이법
	// 김성식

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		int in;
		
		for (int t = 1; t <= 10; t++) {
			int[] arr = new int[8];
			int tCnt = 0; // 토큰으로 저장할 그 다음 번지를 기억하는 변수
			in = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str, " ");
			while(stk.hasMoreTokens()) {
				arr[tCnt++] = Integer.parseInt(stk.nextToken());
			}
			
			// 출력 확인
			// System.out.println(Arrays.toString(arr));
			
			int circle = 0;
			int subCnt = 1;
			while(true) {
				// 하나씩 빼준다
				arr[circle] -= subCnt;
				// 0보다 작은게 있으면 배열을 빠져 나온다
				if(arr[circle] <= 0) {
					arr[circle] = 0;
					break;
				}
				
				subCnt++;
				circle++;
				if(subCnt == 6)
					subCnt = 1;
				// circle이 끝까지 도달했다면 0으로 초기화
				if(circle == 8) {
					circle = 0;
				}
			}
			
			//System.out.println(Arrays.toString(arr));
			
			// 0을 찾아서 shift해주자.
			// 우선 0을 찾을 때 까지
			
			// 1. 현재 값을 temp에 저장
			// 2. 앞으로 다 떙긴다음 
			// 3. 그 temp를 맨뒤에
			// 4. 맨뒤로 옮긴 temp가 0이라면
			// 5. 종료
			while(true) {
				int temp = arr[0];
				int len = arr.length-1;
				// 앞으로 다 땡긴다음
				for (int j = 0; j < len; j++) {
					arr[j] = arr[j+1];					
				}
				arr[len] = temp;
				if(temp == 0)
					break;
			}
			
			// 출력 파트
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < 8; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append('\n');
		}// end of testcase
		System.out.println(sb);
		
	} // end of main
} // end of class
