import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1224_SW문제해결기본6일차_계산기3_김성식 {
	
	
	static int calc(int rTop, char[] re) {

		int[] cal = new int[rTop];
		int top = -1;
		
		//System.out.println(rTop);

		for (int i = 0; i <= rTop; i++) {

			// 연산자이면
			if (re[i] == '*' || re[i] == '+' || re[i] == '-' || re[i] == '/') {
				// 전, 전전꺼 계산
				if (re[i] == '*') {
					cal[top - 1] = cal[top - 1] * cal[top];
					// re[i] == ;

				} else if (re[i] == '+') {
					cal[top - 1] = cal[top - 1] + cal[top];
				} else if (re[i] == '-') {
					cal[top - 1] = cal[top - 1] - cal[top];
				} else if (re[i] == '/') {
					cal[top - 1] = cal[top - 1] / cal[top];
				}
				top--;
			}
			// 피연산자이면
			else {
				cal[++top] = re[i] - '0';

			}
		}

		return cal[0];
	}

	public static void main(String[] args) throws IOException {
		
		// 매커니즘
		// 항상 다음연산자 비교
		// 우선순위가 더 큰걸 실행한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int t = 1; t <= 10; t++) {
			String sTemp = br.readLine();
			int len = Integer.parseInt(sTemp);
			String str = br.readLine(); // str은 읽어들인 문자열
			
			// 선언부
			char[] stackOp = new char[len];
			char[] stackNum = new char[len]; // 후위표기식이 들어갈 배열
			int oTop = -1;
			int nTop = -1;
			
			// 초기 설정  처음엔 숫자이니까
			//stackOp[++oTop] = str.charAt(0);
			
			// 입력된 문자열 다 하나씩 읽어들이기!
			int strLen = str.length();
			for(int i = 0; i < strLen ; i++) {
				char c = str.charAt(i);
				
				// 우선순위 별로 처리
				
				// (가 우선순위가 높기 떄문에
				// *나타났더라도 ()를 먼저 처리 해주어야한다.
				
				
				switch(c) {
				// 우선순위가 작을 때 까지 pp
				case '(': // 우선순위 3
					stackOp[++oTop] = c;
					break;					
				case '*': // 우선순위 2
				case '/': // 우선순위 2
					// 나보다 우선순위가 높거다 같은 애들 배열에 넣기
					while( oTop >= 0 && ( stackOp[oTop] == '*' || stackOp[oTop] == '/' ) ) {
						stackNum[++nTop] = stackOp[oTop];
						oTop--;
					}
					// 그다음에 내 연산자 추가
					stackOp[++oTop] = c;
					break;
					
				case '+': // 우선순위 1
				case '-': // 우선순위 1
					// 나보다 우선순위가 높은 애들먼저 식 배열에 넣는다.
					// 같아도 식 배열에 넣는다. 먼저 계산하라고 한다.
					while( oTop >= 0 && ( stackOp[oTop] == '*' || stackOp[oTop] == '/' ||
							stackOp[oTop] == '+' || stackOp[oTop] == '-' ) ) {
						stackNum[++nTop] = stackOp[oTop];
						oTop--;
					}
					stackOp[++oTop] = c;
					break;

				// (를 만날떄 까지 pop후 처리
				case ')':
					// (를 만날떄 까지 
					while( oTop >= 0 && stackOp[oTop] != '(') {
						stackNum[++nTop] = stackOp[oTop--];					
					}
					// (도 빼주어야한다
					if( oTop >= 0 && stackOp[oTop] == '(') {
						oTop--;
					}
					break;			
					
				//숫자일 경우
				default:
					stackNum[++nTop] = c;
					break;
					
					
				} // end of switch
				

				
				
			} // end of strLen
			
			while(oTop > -1 ) {
				stackNum[++nTop] = stackOp[oTop--];
			}
			//System.out.println(Arrays.toString(stackNum));
			
			int result = calc(nTop, stackNum);
			System.out.printf("#%d %d\n",t,result);
			
		} // end of for(test_case)
		

	}

}
