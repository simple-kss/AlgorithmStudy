package algo0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Number implements Comparable<Number>{
	int start;
	int end;
	
	public Number() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Number(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Number o) {
		// TODO Auto-generated method stub
		if(this.start == o.start)
			return this.end - o.end;
		return this.start - o.start;
	}
}

public class 정올_2247_도서관_김성식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Number[] arr = new Number[N];
		
		// 시작과 끝값을 저장하는 배열!
		// 입력받은 수로부터 합쳐진 시간을 계산한다.
		int arrange[][] = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			arr[i] = new Number();
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			arr[i].start = Integer.parseInt(stk.nextToken());
			arr[i].end = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(arr);
		
		arrange[0][0] = arr[0].start;
		arrange[0][1] = arr[0].end;
		
		// 만약 이전 max가
		// 현재 start보다 크다면 갱신하자!
		// 이전을 저장하는 변수를 선언하자!
		int cnt = 0;
		int ondiff = arrange[0][1] - arrange[0][0];
		int ofdiff = arr[0].start;
		for (int i = 1; i < N; i++) {
			if(arrange[cnt][1] >= arr[i].start) {
				// 바로 하는게 아니라 클때만 한다
				if(arrange[cnt][1] < arr[i].end)
					arrange[cnt][1] = arr[i].end;
				int temp = arrange[cnt][1] - arrange[cnt][0] ;
				if(temp > ondiff) {
					ondiff = temp;
				}
				// 갱신!
			}
			// 그게 아니면 새로만든다!
			else {
				cnt++;
				arrange[cnt][0] = arr[i].start;
				arrange[cnt][1] = arr[i].end;
				// 새로만들떄... 그떄 빈 시간을 구하자!
				int temp = arrange[cnt][0] - arrange[cnt-1][1];
				if(temp > ofdiff) {
					ofdiff = temp;
				}
			}
		}
		
		System.out.println("123");
		
		// 합치자!
		System.out.println(ondiff + " " + ofdiff);
		
		
	} // end of main
} // end of class