import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1223_SW문제해결기본6일차_계산기2_김성식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 연산자는 +와 *뿐
		// *면 바로계산
		// +면 스택에 저장
		String s;
		for(int t = 1; t <= 10; t++) {
			int size = Integer.parseInt(br.readLine());
			s = br.readLine();
		
			// 선언부
			char[] stackOp = new char[size];
			int[] stackNum = new int[size];
			int oTop = -1;
			int nTop = -1;
			
			// 처음엔 무조건 숫자
			char c = s.charAt(0);
			stackNum[++nTop] = c - '0';
			for (int i = 1; i < s.length(); i+=2) {
				char op = s.charAt(i);
				char n = s.charAt(i+1);
				
				// stackNum에서 하나 꺼내와서
				// 계산 후에 다시 넣는다
				if(op == '*') {
					stackNum[nTop] = stackNum[nTop] * (n - '0');
				}
				else if(op == '+') {
					stackOp[++oTop] = op;
					stackNum[++nTop] = n - '0';
				}
			}
			
			// 하나씩 다더함
			int sum = 0;
			for(int i = 0; i <= nTop; i++) {
				sum += stackNum[i];
			}
			System.out.printf("#%d %d\n",t,sum);
		}
	}
}
