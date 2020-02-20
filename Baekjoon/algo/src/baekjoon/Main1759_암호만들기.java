package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759_암호만들기 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int selectN = Integer.parseInt(stk.nextToken());
		int N = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine(), " ");
		
		char[] ch = new char[N];
		for(int i = 0; i < N; i++ ) { 
			ch[i] = stk.nextToken().charAt(0);
		}
		// ch를 정렬한다
		Arrays.sort(ch);
		
		// 현재스텝, 끝나는스텝, N, ch배열, print배열, visited
		makeCry(0, selectN, N, ch, new char[selectN], new boolean[N]);
		
		System.out.println(sb);
		
		

	} // end of main

	private static void makeCry(int step, int end, int N, char[] ch, char[] print, boolean[] bs) {
		if(step == end) {
			// 한개의 모음만 있는지 새면됌. a e i o u
			boolean check = false; // 모음이 하나만 있는지 체크
			for(int i = 0; i < print.length; i++) {
				if( print[i] == 'a' || print[i] == 'e' || print[i] == 'i' ||
						 print[i] == 'o' || print[i] == 'u') {
					check = true;
				}
			}
			if(!check) return;
			
			// 두개의 자음 이있는지 체크
			int cnt = 0;
			for(int i = 0; i < print.length; i++) {
				if( print[i] != 'a' && print[i] != 'e' && print[i] != 'i' &&
						 print[i] != 'o' && print[i] != 'u') {
					cnt ++;
				}
			}
			if(cnt < 2) return;
			
			for(int i = 0; i < print.length; i++) {
				sb.append(print[i]);
			}
			sb.append('\n');
		}
		else {
			
			for(int i = 0; i < N; i++) {
				if(bs[i]) continue;
				if(step >= 1) {
					if(print[step - 1] > ch[i])
						continue;
				}
				bs[i] = true;
				print[step] = ch[i];

				
				makeCry(step + 1, end , N, ch, print, bs);
				bs[i] = false;
			}
			
		}
		
	}
} // end of class