package algo0305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x;
	int y;
	int val;
	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Point(int r, int c, int val) {
		super();
		this.x = r;
		this.y = c;
		this.val = val;
	}
	
	@Override
	public int compareTo(Point o) {
		if ((this.x + this.y ) == (o.x + o.y)) return this.x - o.x;
		return (this.x + this.y ) - (o.x + o.y);
	}
	
}



public class 정올_2634_사냥꾼_김성식 {
	
	public static void main(String[] args) throws IOException {
		// 사대의 수, 동물의 수, 사정거리
		// 사대의 위치
		// 동물의 위치
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		// 변수 초기화부 =--------------------------------
		int pan = Integer.parseInt(stk.nextToken());	// 사대의 수
		int animalCnt = Integer.parseInt(stk.nextToken()); // 동물의 수
		int range = Integer.parseInt(stk.nextToken()); // 사정거리
		
		int[] saArr = new int[pan]; // 사대를 저장할 배
		Point[] aniArr = new Point[animalCnt];
		int[] aniDeadArr = new int[animalCnt];
		int count = 0;
		// --------------------------------
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < pan; i++) {
			// 상관없으면 정렬 안해도됨
			saArr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(saArr);
		
		// 동물이 사냥꾼 범위 안에 들어가는지 확인하자!
		
		for(int i = 0; i < animalCnt; i++) {
			aniArr[i] = new Point();
			stk = new StringTokenizer(br.readLine(), " ");
			int aniX = Integer.parseInt(stk.nextToken());
			int aniY = Integer.parseInt(stk.nextToken());
			
			if(aniY > range) {
				continue;
			}
			
			
			int len = saArr.length; 		// 사수대의 길이
			
			int first = 0;					// 사수대배열 첫번째 번지
			int end = saArr.length;		// 사수대배열 마지막 번지
			
			while(true) {
				int middle = (first + end) / 2;		// 중간 번지
				// 다 하고나서 없다면 break;

				// sa의 X번지를 찾는다.
				
				// 만약 중간이라면 continue
				// 중간이거나 범위안에 들어간다면 continue 사살
				if(getDis(saArr[middle], aniX, aniY) <= range) {
					count++;
					break; // 범위에 들어갔으면 break, 다음 사수번지 찾는다.
				}
				if(first == middle || middle == end)
					break;
				
				//그 번지가 크다면
				// 동물이 더 작음
				else if(saArr[middle] > aniX) {
					end = middle; // 끝을 middle로 만듬
				}
				// 그 번지가 작다면
				else {
					first = middle;
				}
				
			} // end of while
			
			
			
		}
		
		//음
		// 사수에서와 ani와의 distance를 구해서
		// 맞으면 cnt ++
		
		
		System.out.println(count);
		
		
		
		

	} // end of main

/*	private static void shot(int x) {
		boolean changed = false;
		// 자꾸 발견이 안됬을 때
		// 그 사대와 animal과 거리가 맞는지 비교후 맞으면 ++
		for(int i = 0; i < animalCnt; i++) {
			if(x + range < aniArr[i].x) break;
			if(aniDeadArr[i] == 1 || x - range > aniArr[i].x) continue;
			// 그게 사수 + range 보다 클경우 break;
			
			// 여기서 다 검사할 필요는 없다.
			// 추가해보기
			
			int dis = getDis(x, aniArr[i]);
			if(dis <= range) {
				aniDeadArr[i] = 1; // 죽었다고 알ㄹ림
				count++;
			}
		}
		
	}
*/	
	private static int getDis(int x, int px, int py) {
		int result = Math.abs(x - px) + py; 
		return result;
	}

/*	private static int getDis(int x, Point pos) {
		int result = Math.abs(x - pos.x) + pos.y; 
		return result;
	}*/
	
	
} // end of class

























