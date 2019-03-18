import java.util.Scanner;

public class Solution_2063_중간값찾기_김성식 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();			
		}
		
		for(int k = arr.length - 1 ; k >= 0 ; k--) {
			for (int i = 0; i < k; i++) {
				if(arr[i] >= arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}		
		}
		
		System.out.println(arr[arr.length/2]);
	}

}
