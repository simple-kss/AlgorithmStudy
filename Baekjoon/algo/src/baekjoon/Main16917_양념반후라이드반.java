package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16917_양념반후라이드반 {

	public static void main(String[] args) throws IOException {
		System.out.println(" ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		
		int seasoning = Integer.parseInt(stk.nextToken());
		int fry = Integer.parseInt(stk.nextToken());
		int mixed = Integer.parseInt(stk.nextToken());
		
		int sN = Integer.parseInt(stk.nextToken());
		int fN = Integer.parseInt(stk.nextToken());
		
		int total1 = Integer.MAX_VALUE; // case 1
		int total2 = Integer.MAX_VALUE; // case 2
		
		
		
		// 처음에 반반 마리가격이 합당한지 구한다.
		// 그게 합당하면 그냥 그거 다사면됌.
		if(mixed * 2 < (seasoning + fry)) {
			total1 = 2 * ( sN > fN ? sN : fN) * mixed;
		}
		
		
		// sN과 fN의 차이가 0인지 확인한다
		// 만약 차이가 난다면 그만큼은 무조건 양념이던 후라이던 사야한다.
		if(sN != fN) {
			if(sN > fN) {
				int e = sN - fN;
				sN = fN;
				total2 = e * seasoning;
			}
			else if(fN > sN) {
				int e = fN - sN;
				fN = sN;
				total2 = e * fry;
			}
		}
		
		// 다샀으면
		// 따로사는게 좋은지 다사는게 좋은지 체크한다.
		// 그건 1마리씩 가격을 비교하면됨
		if(mixed * 2 < (seasoning + fry)) {
			total2 += 2 * sN * mixed;
		}
		else {
			total2 += sN * seasoning + fN * fry;
		}
		
		System.out.println(total1 > total2 ? total2 : total1);
		
		
		
		
		
		
		
		
		

	} // end of main
}
