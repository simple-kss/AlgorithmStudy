import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
5
6 9 5 7 4
 */
public class Solution_탑레이저_김성식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		// 자기보다 큰 왼쪽인애 찾은다음
		// 그 해당하는 번지를 저장하자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] num = new int[len];
		int[] search = new int[len];
		int cnt = 0;
		
		String st = br.readLine();
		StringTokenizer str = new StringTokenizer(st, " ");
		StringBuilder sb = new StringBuilder();
		
		while(str.hasMoreTokens()) {
			int i = Integer.parseInt(str.nextToken());
			num[cnt++] = i;			
		}
		
		// System.out.println(Arrays.toString(num));
		
//		System.out.println(Arrays.toString(num));

		// 출력확인 끝
		
		// 입력 끝
		
		// 왼쪽에서 자기보다 작은거 찾자.
		// 일단 max를 구해보자
		
		// 만약 max가 갱신되지 않았으면
		// 그 먼지로 하자!
		int max = -1;
		int maxI = 0;
		for (int i = 0; i < len; i++) {
			// 만약 순회하면서 제일 크면
			// 개는 0일것이다.
			if(max < num[i]) {
				max = num[i];
				maxI = i;
				search[i] = 0;
				continue;
			}
//			else {
//				//맥스가 갱신되지 않았다면
//				// 젤 큰 번지가 수신을 받는다.
//				search[i] = maxI+1;
//			}
				
			// 자기 왼편에서부터 계속 큰 거 찾자
			for (int j = i - 1; j >= 0; j--) {
				// 왼편에 큰게 있으면
				if(num[j] > num[i]) {
					search[i] = j+1;
					break;
				}				
			}	
		}
		
		for (int i = 0; i < len; i++) {
			sb.append(search[i]).append(' ');
		}
		System.out.println(sb);
	}
}

