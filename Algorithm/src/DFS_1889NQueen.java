import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFS_1889NQueen {
	private static int N;
	private static int[][] map;
	private static int sum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+2][N+2];
		
		for (int i = 0; i < N+2; i++) {
			map[0][i] = -1;
			map[N+1][i] = -1;
			map[i][0] = -1;
			map[i][N+1] = -1;
		}
		recur(1);
		System.out.println(sum);

	}

	private static void recur(int i) {
		if(i == N+1) sum ++;
		for (int j = 1; j <= N; j++) {
			if(check(i,j)) {
				map[i][j] = 1;
				recur(i+1);
			}
			
		}
		
	}

	private static boolean check(int i, int j) {
		boolean result = true;
		// j가만히
		for (int t = 1; t <= N; t++) {
			if(abs(j-1) + t > N || j+i-t <= 0)
				continue;
			// 가로
			if(map[i][t] == 1) {
				result = false;
				break;
			}
			// 세로
			else if(map[t][j] == 1) {
				result = false;
				break;
			}
			// 좌상 우하 대각선
			else if(map[t][abs(j-i) + t] == 1) {
				result = false;
				break;
			}
			// 좌하 우상 대각선
			else if(map[j+i-t][t] == 1) {
				result = false;
				break;
			}
		}
		return result;
		

	}

	private static int abs(int i) {
		if(i < 0) return -1*i;
		return i;
	}

}
