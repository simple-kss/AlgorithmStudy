package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시험장의 갯수
// 각 시험장의 응시자 수
// 감독, 부감독

public class Main13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int classCnt = Integer.parseInt(br.readLine());
		int[] appCnt = new int[classCnt];
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < classCnt; i++) {
			appCnt[i] = Integer.parseInt(stk.nextToken());
		}
		
		stk = new StringTokenizer(br.readLine(), " ");
		int boss = Integer.parseInt(stk.nextToken());
		int preBoss = Integer.parseInt(stk.nextToken());

		long cnt = 0;
		for(int i = 0; i < classCnt; i++) {
			// 감독관이 감독한다.
			appCnt[i] -= boss;
			
			cnt++;
			if(appCnt[i] <= 0 ) continue;
			
			cnt += appCnt[i] / preBoss;
			// 나머지가 있다면
			if(appCnt[i] % preBoss != 0)
				cnt++;
			
		} // end of for

		System.out.print(cnt);

	} // end of main
} // end of class
