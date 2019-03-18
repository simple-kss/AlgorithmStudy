import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_SW문제해결응용3일차_최적경로_김성식 {
	static int min;
	static int company[] = new int[2];
	static int house[] = new int[2];
	static int custom[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		// 일단 순열문제
		// 모든 경우의수 찾기
		
		for(int t = 1; t <= tc; t++) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine()," ");
			
			// 회사와 집 좌표 설정
			company[0] = Integer.parseInt(stk.nextToken());
			company[1] = Integer.parseInt(stk.nextToken());
			
			house[0] = Integer.parseInt(stk.nextToken());
			house[1] = Integer.parseInt(stk.nextToken());
			
			// 고객 선언
			custom = new int[num][2];
			for(int i = 0; i < num; i++) {
				custom[i][0] = Integer.parseInt(stk.nextToken());
				custom[i][1] = Integer.parseInt(stk.nextToken());
			}
			// 순열
			// 그럼 재귀
			min = Integer.MAX_VALUE;
			recur( num, 0, 0, new boolean[num], company);
			sb.append('#').append(t).append(" ").append(min).append('\n');
		}
		System.out.println(sb.toString());

	} // end of main
	
	public static int getDis(int[] p1, int[] p2) {
		return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
	}
	
	/**
	 * 
	 * @param num   고객 갯수
	 * @param step 	현재 스템
	 * @param dis	누적 거리
	 * @param visited	방문 현황
	 * @param now 현재 위치
	 */
	private static void recur( int num, int step, int dis, boolean[] visited, int[] now) {
		// 마지막 방문자라면
		if(num == step) {
			// 마지막 집 더하낟.
			dis += getDis(now, house);
			if(dis < min)
				min = dis;
			// 길이 값이 큰 지 비교
			return;
			
		} // end of if
		else {
			for(int i = 0; i < num; i++) {
				if(visited[i]) continue;
				visited[i] = true;
				recur( num, step+1, dis + getDis(now, custom[i]), visited, custom[i]);
				visited[i] = false;
				
			} // end of for
			
		} // end of else 
	} // end of function
	
	
} // end of class