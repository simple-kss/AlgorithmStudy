
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution_5986_새샘이와세소수_김성식 {
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<Integer> getChe(int num) {
		int[] arr = new int[num + 1];
		ArrayList<Integer> prime = new ArrayList<Integer>(); 
		
		for(int i = 2; i <= num ; i++) {
			arr[i] = i;
		}
		
		int sq = (int)Math.sqrt(num);
		// N이하의 소수를 구하려면 루트 N까지 반복하면된다.
		// 이유 : ??
		for(int i = 2; i <= sq; i++) {
			// 이미 배수로 체크되었다면 continue
			if( arr[i] == 0) continue;
			for(int j = i + i; j <= num; j += i) {
				// 방문했다고 함
				arr[j] = 0 ;
			}
		}
		
		for(int i = 2; i <= num; i++) {
			if(arr[i] != 0)
				prime.add(arr[i]);
		}
		return prime;
		
	} // end of func
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder pr = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		
		// N이하의 소수 찾자.
		// 최대 N이 1000
		ArrayList<Integer> pri = getChe(1000);
		
		for(int t = 1; t <= tc; t++) {
			int num = Integer.parseInt(br.readLine());
			int caseCnt = 0;
			

			HashSet<String> hs = new HashSet<String>();
			/*StringBuilder temp = new StringBuilder();*/
			
			// 이제 97 - s1이 s2에 있는지
			// 97 - s1 - s2가 소수에 있는지를 검사한다.
			
			// case check
			int len = pri.size();
			for(int i = 0; i < len; i++ ) {
				// 순열 탐색으로 간다.
				int n1 = pri.get(i);
				int n2 = 0;
				int n3 = 0;
				for(int j = i; j < len; j++) {
					n2 = pri.get(j);
					if(n1 + n2 >= num) continue;
					for(int k = j; k < len; k++) {
						n3 = pri.get(k);
						if( n1 + n2 + n3 == num) {
							int[] temp = new int[3];
							temp[0] = n1;
							temp[1] = n2;
							temp[2] = n3;
							for(int i1 = 0; i1 < 2; i1++) {
								for(int j1 = i1+1 ; j1 < 3; j1++) {
									if(temp[i1] > temp[j1]) {
										int te = temp[i1];
										temp[i1] = temp[j1];
										temp[j1] = te;
										
									}
								}
							}
//							System.out.println(Arrays.toString(temp) + num);
							hs.add(Arrays.toString(temp));
							
						}
					}
				}
				
			}
			pr.append('#').append(t).append(' ').append(hs.size()).append('\n');
		} // end of tc
		
		System.out.println(pr);
	} // end of main
	
	static int checkPrime(ArrayList<Integer> prime, int N) {
		int len = prime.size();
		boolean check = false;
		
		for(int i = 0; i < len; i++)
			if( N == prime.get(i)) return prime.get(i);
		return -1;
		
	}
} // end of class





















