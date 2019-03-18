package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3053_택시기하학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		double d1 = n * n * Math.PI;
		double d2 = 2 * n * n * 1.0;
		
		System.out.printf("%.6f\n",d1);
		System.out.printf("%.6f",d2);
	} // end of main
} // end of class