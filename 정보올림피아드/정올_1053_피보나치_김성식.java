package algo0314;

import java.util.Scanner;

public class 정올_1053_피보나치_김성식 {
	// 행렬을 만들자
	static int[][] mat = {
		{1, 1},
		{1, 0}
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = sc.nextInt();
			if(n < 0) break;
			if( n == 0) { 
				sb.append('0').append('\n');
				continue;
			}
			int result = calc(n);
			sb.append(result).append('\n');
		}
		System.out.println(sb);

	} // end of main

	private static int calc(int n) {
		
		int[][] re = pow(mat ,n);
		
		return re[0][1] % 10000;
	}

	private static int[][] pow(int[][] mat, int n) {
		if(n == 0) {
			int[][] E = {
					{1, 0},
					{0, 1}
			};
			return E;
		}
		else if( n == 1) {
			return mat;
		}
		// 짝수일 경우
		else if(n % 2 ==0) {
			int[][] temp = pow(mat ,n/2);
			return multi(temp,temp);
		}
		// 홀수 일 경우
		else {
			int[][] temp = pow(mat ,n/2);
			return multi(multi(temp, temp), mat);
		}
	}

	private static int[][] multi(int[][] t1, int[][] t2) {
		int[][] temp = new int[2][2];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k < 2; k++) {
					temp[i][j] += (t1[i][k] * t2[k][j]) % 10000;
				}
			}
		}
		return temp;
	}
	
	// n승 구하기
	
	
	
} // end of main