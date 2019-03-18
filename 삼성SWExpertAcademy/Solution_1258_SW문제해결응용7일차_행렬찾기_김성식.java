import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


//9
//1 1 3 2 0 0 0 0 0
//3 2 5 2 0 0 0 0 0
//2 3 3 1 0 0 0 0 0
//0 0 0 0 4 5 5 3 1
//1 2 5 0 3 6 4 2 1
//2 3 6 0 2 1 1 4 2
//0 0 0 0 4 2 3 1 1
//0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0

// #1 3 2 3 3 4 4 5

class Poin implements Comparable<Poin>{
	int r;
	int c;
	int val;
	public Poin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Poin(int r, int c, int val) {
		super();
		this.r = r;
		this.c = c;
		this.val = val;
	}
	
	
	@Override
	public int compareTo(Poin o) {
		// TODO Auto-generated method stub
		if(this.val == o.val) return this.r - o.r;
		return this.val - o.val;
	}
	
	
}

public class Solution_1258_SW문제해결응용7일차_행렬찾기_김성식 {
	static char[][] map;
	static boolean[][] visited;
	static int N;
	
	static int wCnt = 1;
	static int hCnt = 1;
	static int squareCnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(" ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			ArrayList<Poin> ar = new ArrayList<Poin>();
			
			// 변수 생성
			N = Integer.parseInt(br.readLine());
			map = new char[N+2][N+2];
			boolean[][] visited = new boolean[N+2][N+2];
			
			// 변수 쵝화
			squareCnt = 0;
			
			
			// 이거 초기화 꼭 해주기...
			for(int i = 0; i < N+2; i++) {
				for(int j = 0; j < N+2; j++) {
					map[i][j] = '0';
				}
			} // end of for
			
			for(int i = 1; i <= N; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j <= N; j++) {
					map[i][j] = stk.nextToken().charAt(0);
				}
			} // end of for
			
			// -> 동, -> 남 순으로 DFS ->동으로 갈때 cnt ++
			// -> 남으로 갈떄 cnt++
			// 0이 아닌 지점만 하면 ㄷ뇜
			
			sb1.append('#').append(t).append(' ');
			// visited 쓴다.
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					wCnt = 0;
					hCnt = 0;
					if(map[i][j] != '0' && !visited[i][j]) {
						squareCnt++;
//					System.out.println("excute" + i + j + " ");
						dfs(i, j);
//					System.out.println("wCnt, hCnt :" + wCnt + " "+ hCnt);
						// i 부터 i+ wCnt, j부터 h+Cnt까지 visitied true로 만든다
						for(int k = i; k <= i + hCnt; k++) {
							for(int l = j; l <= j + wCnt; l++) {
								visited[k][l] = true;
							}
						} // end of for
						
						ar.add(new Poin(hCnt+1,wCnt+1,(hCnt+1)*(wCnt+1)));
//					sb2.append(hCnt+1).append(' ').append(wCnt+1).append(' ');
						
						wCnt = 0;
						hCnt = 0;
					}
					
//				br.readLine();
//				System.out.println("------------");
//				for(int z = 1; z <= N; z++) {
//					for(int x = 1; x <= N; x++) {
//						if(visited[z][x])
//							System.out.print("1");
//						else
//							System.out.print("0");
//							
//					}
//					System.out.println();
//				}
//				System.out.println("------------");
				}
			} // end of 2 degree refer
			
			Collections.sort(ar);
			
			
			sb1.append(squareCnt).append(' ').append(sb2);
			for(int i = 0; i < ar.size(); i++ ) {
				sb1.append(ar.get(i).r).append(' ').append(ar.get(i).c).append(' ');
			}
			sb1.append('\n');
			
		}
		System.out.println(sb1);
//		sb1.append(squareCnt).append(' ').append(sb2);
//		System.out.println(sb1);

	} // end of main

	private static void dfs(int i, int j) {
		// 1인 경우 탐색하지 않는다.
		
		if(j <= N && map[i][j+1] != '0') {
			wCnt++;
//			System.out.println("동"+ i + " " + (j + 1) + " ");
			dfs(i  , j+1);
		}
		// 0이라면 즉 탐색 j+1이 벽이라면
		// 그때 아래쪽 탐색한다.
		else if(i <= N && map[i+1][j] != '0') {
			hCnt++;
//			System.out.println("남"+ (i+1) + " " + j + " ");
			dfs(i+1, j);
		}
		// 아래쪽도 0이라면
//		System.out.println("-=------");
		
		
		
	} // end of function
} // end of class












