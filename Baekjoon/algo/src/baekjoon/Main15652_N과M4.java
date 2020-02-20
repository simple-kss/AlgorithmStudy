package baekjoon;

import java.util.Arrays;
import java.util.Scanner;


public class Main15652_N과M4 {
	
	static int[] print; // 저장할 애
	
	static int[] arr; // 어떤 숫자로 순열을 만들고 싶니?
	static boolean[] visited; // 이미 그 숫자 썻냐?

	public static void exe( int step, int cnt) {
		// len 만큼 돌자
		int len = arr.length;
		// step 0 ~ num-1 번지
		if(step >= cnt) {
			for (int i = 0; i < print.length; i++) {
				System.out.print(print[i]+ " ");
			}
			System.out.println();
		}	
		else {
			for(int i = 0; i < len; i++) {
				
				if(step == 0) {
					print[step] = arr[i];
					exe(step+1, cnt);
				}
				else if(print[step - 1] <= arr[i]) {
					print[step] = arr[i];
					exe(step+1, cnt);
				}
				// 그 이전에 숫자 썻으면 pass
//				if(visited[i] == true) continue;
//				
//				print[step] = arr[i];
//				
//				// 방문할 조건을 넣어야 한다.
//				// 현재것이 이전거보다 크지만 않으면 된다.
//				if(step >= 1 && (print[step] < print[step-1])) {
//					visited[i] = true;
////					return; // 해당 번지 썻으므로 true
//					//continue;
//				}
//				exe(step+1, cnt);
//				visited[i] = false; // 현재 스텝에서 안쓴 버전으로 다시 
				// 재가동할 것이므로 false
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt(); // 숫자의 갯수
		int cnt = sc.nextInt(); // 조합할 갯수
		
		arr = new int[num];
		print = new int[cnt];
		visited = new boolean[num];
		arr = new int[] {6,1,4,2};
		
		Arrays.sort(arr);
		
		for (int i = 0; i < num; i++) {
			arr[i] = i + 1;			
		}
		
		
		
		exe( 0, cnt);
//		exe

	}
}