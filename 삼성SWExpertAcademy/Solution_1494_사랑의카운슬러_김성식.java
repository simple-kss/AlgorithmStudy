package algo0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 제약조건
 * 
 * @author student
 *
 */
public class Solution_1494_사랑의카운슬러_김성식 {
	
	// 변수 선언부
	static boolean visited[];
	static int data[][];
	static int print[]; // + 할 번지
	static boolean b[];
	static long min; // 최솟값 담을 변수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine().trim());
		
		for(int t = 1; t <= tc; t++) {
			
			// 변수 선언부
			int N = Integer.parseInt(br.readLine()); // 지렁이 갯수
			int P = N / 2;
			data = new int[N][2];
			print = new int[P];
			b = new boolean[N];
			min = Long.MAX_VALUE;
			
			visited = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
				data[i][0] = Integer.parseInt(stk.nextToken());
				data[i][1] = Integer.parseInt(stk.nextToken());
			}
			
			// N개중 P개 조합
			// step, end
			combi(0, 0, P, N);
			
			
			sb.append('#').append(t).append(' ').append(min).append('\n');
		}
		System.out.println(sb);

	} // end of main.

	private static void combi(int start, int step, int end, int N) {
		if(step == end) {
			//end는 지렁이의 반일 것이다.
			b = new boolean[N];
			for(int i = 0; i < end; i++) {
				b[print[i]] = true;
			}
			
			long sumX = 0;
			long sumY = 0;
			for(int i = 0; i < N; i++) {
				// 그 해당하는 번지가 true이면 다더한다.
				if(b[i]) {
					sumX += data[i][0];
					sumY += data[i][1];
				}
				else {
					sumX -= data[i][0];
					sumY -= data[i][1];
				}
			}
			
			long result = sumX * sumX + sumY * sumY;
			if(min > result) min = result;
			
			return;
		}
		else {
			for(int i = start; i < N; i++) {
				print[step] = i;
				combi(i+1 ,step+1, end, N);
			}
			
		}
		
	} // end of recur





} // end of class