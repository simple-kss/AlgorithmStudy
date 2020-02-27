import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀_1309팩토리얼 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		fact(N, 1);
		

	}

	private static void fact(int n, long sum) {
		if(n == 1) {
			System.out.println("1! = 1");
			System.out.println(sum);
		}
		else {
			System.out.println(n + "! = " + n + " * " + (n-1) + "!");
			fact(n-1, sum*n);
		}
	}

}
