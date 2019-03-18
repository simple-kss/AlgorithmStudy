import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드_김성식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1 ; t <= tc; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			char[][] map = new char[r][c];
			
			for(int i = 0; i < r; i++) {
				String str = br.readLine();
				map[i] = str.toCharArray();
			}
			
			int comLen = Integer.parseInt(br.readLine());
			String comStr = br.readLine();
			
			int dir = 0;
			// ^, v , <, >
			// . 평지
			// * 벽돌
			// # 강철
			// - 물
			
			// 먼저 전차의 방향과 번지를 찾는다.
			int tankR = 0;
			int tankC = 0;
			
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(map[i][j] == '^') {
						dir = 1;
						tankR = i;
						tankC = j;
					}
					else if(map[i][j] == '>') {
						dir = 2;
						tankR = i;
						tankC = j;
					}
					else if(map[i][j] == 'v') {
						dir = 3;
						tankR = i;
						tankC = j;
					}
					else if(map[i][j] == '<') {
						dir = 4;
						tankR = i;
						tankC = j;
					}
					
				} // end of for1
			} // end of for2
			
			
			for(int i = 0; i < comLen; i++) {
				switch(comStr.charAt(i)) {
				case 'U':
					// 갈 수 있는지 없는지 벽돌, 강철, 물, 맵밖 유효한지 검사
					if(isValid(r, c, tankR - 1, tankC, map)) {
						map[tankR][tankC] = '.';
						tankR--;
					}
					map[tankR][tankC] = '^';
					dir = 1;
					break;
				case 'R':
					if(isValid(r, c, tankR, tankC + 1, map)) {
						map[tankR][tankC] = '.';
						tankC++;
					}
					map[tankR][tankC] = '>';
					dir = 2;
					break;
				case 'D':
					if(isValid(r, c, tankR + 1, tankC, map)) {
						map[tankR][tankC] = '.';
						tankR++;
					}
					map[tankR][tankC] = 'v';
					dir = 3;
					break;
				case 'L':
					if(isValid(r, c, tankR, tankC - 1, map)) {
						// 이동
						map[tankR][tankC] = '.';
						tankC--;
					}
					map[tankR][tankC] = '<';
					dir = 4;
					break;
				case 'S':
					// 맵 내에서 그쪽 방향 벽들을 .로 만들면 된다.
					// 시작점은 tankR, tankC
					// 방향은 dir
					shoot(tankR, tankC, dir, map, r, c);
					
					break;
				}
			} // end of for shoot and move
			
			sb.append('#').append(t).append(' ');
			
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
		} // end of test
		System.out.println(sb);
		
	} // end of main
	
	private static void shoot(int tankR, int tankC, int dir, char[][] map, int R, int C) {
		switch(dir) {
		case 1:
			// 탱크 좌표로부터 북쪽에 있는
			// 벽돌을 찾아 없애버린다
			for(int i = tankR; i >= 0; i--) {
				if(map[i][tankC] == '#' ) {
					break;
				}
				if(map[i][tankC] == '*' ) {
					map[i][tankC] = '.';
					break;
				}
			}
			break;
		case 2:
			// 오른
			for(int i = tankC; i < C; i++) {
				if(map[tankR][i] == '#' ) {
					break;
				}
				if(map[tankR][i] == '*' ) {
					map[tankR][i] = '.';
					break;
				}
			}
			break;
		case 3:
			// 남
			for(int i = tankR; i < R; i++) {
				if(map[i][tankC] == '#' ) {
					break;
				}
				if(map[i][tankC] == '*' ) {
					map[i][tankC] = '.';
					break;
				}
			}
			break;
		case 4:
			// 서
			for(int i = tankC; i >= 0; i--) {
				if(map[tankR][i] == '#' ) {
					break;
				}
				if(map[tankR][i] == '*' ) {
					map[tankR][i] = '.';
					break;
				}
			}
			break;		
		}
	}

	static boolean isValid(int R, int C,int r, int c, char[][] map) {
		return r >= 0 && r < R && c >= 0 && c < C && map[r][c] != '*' && map[r][c] != '#' && map[r][c] != '-';
	}
} // end of class
