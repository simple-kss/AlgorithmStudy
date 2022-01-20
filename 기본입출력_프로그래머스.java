import java.util.Arrays;

public class K번매수 {

	public static void main(String[] args) {
		int array[] = {1, 5, 2, 6, 3, 7, 4};
		int commands[][] = {
				{2, 5, 3},
				{4, 4, 1},
				{1, 7, 3}
			};
		
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.solution(array, commands)));
	}
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[20];
        
        int r = commands.length;
        for (int i = 0; i < r; i++ ) {
        	int c = commands[i].length; 	
        	for (int j = 0; j < c; j++ ) {
            	answer[j + c * i] = commands[i][j];
            }
        }
        
        return answer;
    }
}
