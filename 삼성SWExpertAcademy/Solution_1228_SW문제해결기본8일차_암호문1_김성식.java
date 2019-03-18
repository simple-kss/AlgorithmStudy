import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1228_SW문제해결기본8일차_암호문1_김성식 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = 100;
		
		for(int t = 1; t <= 10; t ++) {
			int oLen = Integer.parseInt(br.readLine()); // 본 암호문 길이
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder();
			String[] crp = new String[N];
			int cnt = 0;
			while (stk.hasMoreTokens()) {
				crp[cnt++] = stk.nextToken();
			}

			int comCnt = Integer.parseInt(br.readLine()); // 명령어개수

			stk = new StringTokenizer(br.readLine(), " ");
			String[] com = new String[stk.countTokens()];
			cnt = 0;
			while (stk.hasMoreTokens()) {
				com[cnt++] = stk.nextToken();
			}

			// 명령어 갯수만큼 돌거임
			for (int i = 0; i < cnt;) {
				if (com[i].equals("I")) {
					// I 찾았으니 그 다음 데이터 읽기
					i++;
					// 먼저 인덱스 찾기
					int index = Integer.parseInt(com[i]);
					i++;
					// String 갯수 읽기
					int count = Integer.parseInt(com[i]);
					i++;
					// 그 index부터 count만큼 뒤로 이동시켜줘야함
					String[] tempCrp = new String[N - index - count];
					
					// 요 2줄 작업 필수
					System.arraycopy(crp, index, tempCrp, 0, N - index - count); // 먼저 임시로 원래 암호문 index부터 index+count까지 복사하여 tempCrp에 저장
					System.arraycopy(tempCrp, 0, crp, index+count, N - index - count - count); // 뒤로 복사 사이에 공간만들기
					// 그다음에 복사, 사이에 쏙 놓기
					System.arraycopy(com, i, crp, index, count);
					i += count;
				}
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(crp[i]).append(" ");
			}

			System.out.println(sb);
		} // end of testcase
	} // end of main
}
