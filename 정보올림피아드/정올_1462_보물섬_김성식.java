import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int r;
	int c;
	int value = 0;
	public Point(int r, int c, int value) {
		this.r = r;
		this.c = c;
		this.value = value;
	}
	
	
}

public class 정올_1462_보물섬_김성식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Point> lArr = new ArrayList<Point>();
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		
		char[][] map = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		} // end of for
		
		// L find
		for(int i = 0; i < r; i++ ) {
			for(int j = 0; j < c; j++ ) {
				if(map[i][j] == 'L') lArr.add(new Point(i,j, 0));
			}
		}
		
		// L시작점 하나 꺼내서 bfs로 보낸다
		int len = lArr.size();
		int max = 0;
		for(int i = 0; i < len; i++) {
			int temp = bfs(lArr.get(i), r, c, map, new boolean[r][c]);
			if(max < temp)
				max = temp;
		} // end of for
		
		System.out.println(max);
		
		

	} // end of main 

	private static int bfs(Point p, int r, int c, char[][] map, boolean[][] visited) {
		ArrayDeque<Point> dq = new ArrayDeque<Point>();
		
		// 포인트 기준으로 4방향 다 큐에 넣는다.
		// 북
		if(p.r + 1 < r && map[p.r + 1][p.c] == 'L') {
			visited[p.r+1][p.c] = true; 
			dq.add(new Point(p.r + 1, p.c, 1));
		}
		
		// 동
		if(p.c + 1 < c && map[p.r][p.c + 1] == 'L') {
			visited[p.r][p.c+1] = true; 
			dq.add(new Point(p.r, p.c + 1, 1));
		}
			
		// 남
		if(p.r - 1 >= 0 && map[p.r - 1][p.c] == 'L') {
			visited[p.r-1][p.c] = true; 
			dq.add(new Point(p.r - 1, p.c, 1));
		}
		
		// 서
		if(p.c - 1 >= 0 && map[p.r][p.c - 1] == 'L') {
			visited[p.r][p.c-1] = true; 
			dq.add(new Point(p.r, p.c - 1, 1));
		}
		
		int maxVal = 0;
		// 비어있지 않을떄 까지
		while(!dq.isEmpty()) {
			// 큐 하나 꺼낸다
			p = dq.poll();
			maxVal = p.value;
			
			// 거기서 갈 수 있는애 담는다.
			if(p.r + 1 < r && !visited[p.r+1][p.c] && map[p.r + 1][p.c] == 'L') {
				visited[p.r+1][p.c] = true; 
				dq.add(new Point(p.r + 1, p.c, p.value + 1));
			}
			
			// 동
			if(p.c + 1 < c && !visited[p.r][p.c+1] && map[p.r][p.c + 1] == 'L') {
				visited[p.r][p.c+1] = true; 
				dq.add(new Point(p.r, p.c + 1, p.value + 1));
			}
				
			// 남
			if(p.r - 1 >= 0 && !visited[p.r-1][p.c] && map[p.r - 1][p.c] == 'L') {
				visited[p.r-1][p.c] = true; 
				dq.add(new Point(p.r - 1, p.c, p.value + 1));
			}
			
			// 서
			if(p.c - 1 >= 0 && !visited[p.r][p.c-1] && map[p.r][p.c - 1] == 'L') {
				visited[p.r][p.c-1] = true; 
				dq.add(new Point(p.r, p.c - 1, p.value + 1));
			}
		} // end of que play
		
		return maxVal;
		
		
	} // end of func
	
	
} // end of class




















