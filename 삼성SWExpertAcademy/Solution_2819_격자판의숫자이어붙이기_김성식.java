import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_2819_격자판의숫자이어붙이기_김성식 {
	static int[][] dir = {
			{ 0,  1}, 	// 동
			{ 0, -1}, 	// 서
			{ 1,  0}, 	// 남
			{-1,  0}	// 북
	};
	static HashSet<String> hStr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		char[][] arr;
		
		
		for(int t = 1; t <= tc; t++) {
			hStr = new HashSet<String>();
			arr = new char[6][6];
			int r = 0;
			int c = 0;
			for(int j = 0; j < 6; j++) {
				arr[j][5] = 'P';
				arr[5][j] = 'P';
				arr[j][0] = 'P';
				arr[0][j] = 'P';
			}
			for(int i = 1; i <= 4; i++) {
				r = i;
				String str = br.readLine();
				StringTokenizer stk = new StringTokenizer(str," ");
				c = 1;
				while(stk.hasMoreTokens()) {
					arr[r][c++] = stk.nextToken().charAt(0);
				}
			}
			char[] cArr = new char[7];
			
			for(int i = 1; i <= 4; i++) {
				for(int j = 1; j <= 4; j++) {
					cArr[0] = arr[i][j];
					recur(i, j ,arr, 1 , 7, cArr);
				}
			}
			
			sb.append('#').append(t).append(' ').append(hStr.size()).append('\n');
		} // end of for
		System.out.println(sb.toString());
		
	} // end of main

	private static void recur(int r, int c, char[][] arr, int step, int end, char[] cArr) {
		if(step == end) {
			String str = new String(cArr);
			//System.out.println(str);
			hStr.add(str);
			return;
		}
		else {
			for(int i = 0; i < 4; i++) {
				int tr = r + dir[i][0];
				int tc = c + dir[i][1];
				if(arr[tr][tc] == 'P') continue;
				cArr[step] = arr[tr][tc];
				recur(tr, tc, arr, step+1, end, cArr);
			}
		}
		
	}

	
	

} // end of class
