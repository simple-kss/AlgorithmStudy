package algo2;

import java.util.Arrays;
import java.util.Scanner;

//2.20
/**
 * 
 * MST(Minimum Spanning Tree) 최소 신장 트리
 * 	1.Prim		: 선택한 정점에서 인접한 간선중에 최소 가중치의 정점을 선택해 나간다.
 * 		-Greedy 설계기법, 우선순위큐를 구현해야함(힙을 구현)
 * 	2.KRUSKAL 	: 최소 가중치의 간선을 선택해 나간다.
 * 		-서로소 집합(DisjointSet)을 구현 해야한다. 그래야 성능이 좋아. 그렇다고 성능안좋게하면 알고리즘자체가 무쓸모!
 * 
<input data> 정점의 개수 V, 간선의 개수 E, E개의 간선 정보  // 정점1 정점2 가중치
7 11
5 3 18
1 2 21
0 6 51
2 6 25
0 2 31
0 5 60
3 4 34
2 4 46
4 6 51
5 4 40
0 1 32

2
3 3
1 2 1
2 3 2
1 3 3
7 11
5 3 18
1 2 21
0 6 51
2 6 25
0 2 31
0 5 60
3 4 34
2 4 46
4 6 51
5 4 40
0 1 32
 *
 */
public class Solution_3124_최소스패닝트리_김성식 {
	private static int[] p;	
	private static int[] rank;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int V = sc.nextInt();	//정점의 개수
			int E = sc.nextInt();	//간선의 개수
			
			p = new int[V+1];
			rank = new int[p.length];
			
			// 자기자신을 부모로 만든다.
			for (int i = 1; i <= V; i++) {
				p[i] = i;
			}
			
			Edge[] G = new Edge[E];	//간선의 정보를 저장할 배열 = 간선 배열
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int val = sc.nextInt();
				Edge e = new Edge(a,b,val);
				G[i] = e;
			}
			
			//#KRUSKAL : 서로소 집합을 활용 
			//모든 정점들을 원소 1개 짜리의 집합으로 만든다.
			for (int i = 0; i < p.length; i++) {
				makeSet(i);
			}
			//가중치를 기준으로 간선 배열을 정렬 
			Arrays.sort(G);	//compareTo 구현해야돼*****************
			
			long total = 0;
			
			//반복(간선이 V-1개 선택할 때까지)
			for (int i = 0,cnt =0; i < E && cnt < V; i++) {
				//가중치가 낮은 간선은 선택, 사이클이 발생하지 않는 정점을 선택
				Edge e = G[i];
				int pa = findSet(e.a);	//a의 부모
				int pb = findSet(e.b);	//b의 부모
				
				if(pa!=pb) {	//다를 때만 합해
					cnt++;
					union(pa,pb);
//					System.out.println(e.a+ "-"+e.b+" : "+e.val);
					total += e.val;
				}
			}
			sb.append("#").append(t).append(" ").append(total).append('\n');
		}
		
		System.out.println(sb);
		
		//두 정점의 집합을 하나의 같은 집합으로 합침
//		printSet();
		
	}//end of main
	
	/** 멤버 x,y를 포함하는 두 집합을 통합(서로 다른 집할일 때만 합쳐야함) */
	public static void union(int x, int y) {
		int px = findSet(x);	//서로 다른값이여야함.
		int py = findSet(y);
		
		// link(px,py);	//문제점 해결2 
		
		p[py]=px;	//px:대표자, 
	}//end of union()

	/** x대표자와 y대표자의 집합을 합침, 누굴 대표자로 할꺼냐 */
	public static void link(int px, int py) {	//문제점 해결2: rank를 이용한 union
		if(rank[px] > rank[py]) {//큰놈을 부모로 해준다.
			p[py]=px;
		}
		else {
			p[px]=py;
			if(rank[px] == rank[py]) {
				rank[py]++;	//두 대표자의 랭크 값이 같을 경우 랭크 값이 증가한다.
			}
		}
	}//end of link()

	/** 멤버 x를 포함하는 집합을 찾아서 대표자를 리턴*/
	public static int findSet(int x) {
		if(p[x] == x) {
			return x;
		}
		p[x] = findSet(p[x]);	//문제점 해결1 : path Compression 대표자를 찾으면 저장 하자 ******
		return p[x];	//내가 부모가 아닌 경우 재귀적으로 다시 나를 호출
	}//end of findSet()

	/** p배열을 출력하는 메소드*/
	public static void printSet() {
		//인덱스 출력
		System.out.print("인덱스 : ");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d ",i);
		}
		System.out.println();
		
		//부모 출력
		System.out.print("부   모 : ");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d ",p[i]);
		}
		System.out.println();
		
		//랭크 출력
		System.out.print("랭   크 : ");
		for (int i = 0; i < rank.length; i++) {
			System.out.printf("%2d ",rank[i]);
		}
		System.out.println("\n");
		
	}//end of printSet()

	public static void makeSet(int x) {
		p[x] = x; //나의 부모는 나다, 부모를 저장, 자기자신의 index of -1 저장
//		rank[x]=0;	초기화,자바에서는 의미없음
	}//end of makeSet()
	
	public static class Edge implements Comparable<Edge>{//원래 class에 static안되는데 inner class엔 static을 붙일 수 있어 **********
		
		int a;	//정점 1
		int b;	//정점 2
		int val;//가충치
		public Edge(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}
		public int compareTo(Edge o) {	//간선의 가중치를 기준으로 정렬한다.
			return this.val - o.val;	//내께 크면 양수(오름차순)
		}
		
	}//end of Edge{}
}//end of class



























