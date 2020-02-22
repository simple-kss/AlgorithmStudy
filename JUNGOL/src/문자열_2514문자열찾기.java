import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_2514문자열찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		int cnt[] = new int[3];
		
		// 끝에서 2글자 뒤까지만 해야함 .... KOI아면 K까지만
		for (int i = 0; i < len - 2; i++) {
			// K와 I인 경우에만 실행
			if( s.charAt(i) == 'K' || s.charAt(i) == 'I') {
				if ( s.charAt(i+1) == 'O') {
					if(s.charAt(i+2) == 'I') {
						cnt['K' - s.charAt(i)]++;
					}
				}
			}
		}
		System.out.println(cnt[0]); // KOI
		System.out.println(cnt[2]); // IOI
	}
}
