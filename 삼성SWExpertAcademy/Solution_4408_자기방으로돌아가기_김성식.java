import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4408_자기방으로돌아가기_김성식 {
	
	public static int second = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] bridge = new boolean[200];
		int[] now = new int[N];
		int[] after = new int[N];
		boolean[] visited = new boolean[N];
		
		int max = 0;
		
		// 일단 가장 큰 브릿지 부터 찾자
		int bSize = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			now[i] = Integer.parseInt(stk.nextToken());
			after[i] = Integer.parseInt(stk.nextToken());
			if(after[i] > max) 
				max = after[i];
			
		} // end of for
		
		// 조합을 만드는 문제!
		// 조합 번지를 만들자
		
		combi();
		
		
		
		
		
		// 다리의 마지막 번지
		int bNum = (max + 1) / 2;
		
		// dfs로 돌리기
		dfs(now, after, bridge, bNum, visited, N, 0);
		
		
		
	} // end of main
	
	private static void combi() {
		// TODO Auto-generated method stub
		
	}

	private static void dfs(int[] now, int[] after, boolean[] bridge, int bNum, boolean[] visited, int size, int step) {
		
		// 다 돌았으면 
		if(step == size) {
			
		}
		
		// 하나씩 bfs돌릴예정.
		// 백트래킹 해야할 수도
		
		// 각자에 대해서 dfs 돌려야함
		// 방문했는지 안했는지 여부에 따라서
		for(int i = 0 ; i < size; i++) {
			if(visited[i]) continue;
			// 일단 다 방문하게 해놓고
			visited[i] = true;
			// 갈 수 있으면 가고 못가면 + 1 해준다
			boolean check = setVisited(now[i], after[i], bridge);
			if(!check) second++;
			dfs(now, after, bridge, bNum, visited, size, step + 1);
			
			visited[i] = false;
			
		}
		
	}

	public static boolean setVisited(int now, int after, boolean[] bridge) {
		int start = (now - 1) / 2;
		int end = (after + 1) / 2;
		
		for(int i = start; i < end; i++) {
			// 이미 갔던대라면 false
			if(bridge[i] == true) return false;
		}
		
		for(int i = start; i < end; i++) {
			// 이미 갔던대라면 false
			bridge[i] = true;
		}
		return true;
	}
} // end of class