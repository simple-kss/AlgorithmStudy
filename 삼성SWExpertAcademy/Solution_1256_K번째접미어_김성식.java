import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1256_K번째접미어_김성식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= tc ; t++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			
			// s 문자열의 모든 접미사 생성
			int[] sa = new int[s.length()]; // Suffix Array : index 번째에서 시작하는 s문자열의 접미사
			for(int i = 0; i < sa.length; i++) {
				sa[i] = i; // 초기화
			}
			
			// s 문자열의 접미사를 정렬
			// 선택 정렬

			for(int i = 0; i < sa.length; i++) {
				int minIndex = i;
				for (int j = i; j < sa.length; j++) {
					// s.substring(sa[minIndex]) ~~~ s.substring(j); 이 2개를 비교
					// minIndex가 더 크면, 즉 j가 더 작으면
					if(s.substring(sa[minIndex]).compareTo(s.substring(sa[j])) > 0) {
						minIndex = j;
					}
				}
				//minIndex <-> i 	swap
				int temp = sa[minIndex];
				sa[minIndex] = sa[i];
				sa[i] = temp;
			}
			sb.append('#').append(t).append(' ');
			// N번째 번지부터 다 출력하면 된다.
			int start = sa[N-1]; 
			for(int i = start; i < s.length(); i++) {
				sb.append(s.charAt(i));
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
		

	} // end of main
} // end of class