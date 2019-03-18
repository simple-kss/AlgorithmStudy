import java.util.Arrays;
import java.util.Scanner;

public class Solution_1204_SW문제해결기본1일차_최빈수구하기_김성식{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int test_case = scan.nextInt();
		
		for (int t = 1; t <= test_case; t++) {
			int[] arr = new int[101];
			
			int te = scan.nextInt();
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = 0;			
			}
			
			for (int i = 0; i < 1000; i++) {
				int input = scan.nextInt();
				arr[input]++;
			}
			
			int maxIndex = 0;
			int max = arr[0];
			for (int i = 100; i >= 0; i--) {
				if(max < arr[i] ) {
					max = arr[i];
					maxIndex = i;
				}
			}
			System.out.printf("#%d %d\n",te,maxIndex);
		}
	}
}
