import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_1210_SW문제해결기본2일차_Ladder1_김성식{
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// ���� �� �б�
		Scanner scan = new Scanner(System.in);
		
		int[][] arr = new int[102][102];
		// �����¿쾿 2ĭ�� �ø���~
		
		// 0��
		for (int i = 0; i < 102; i++) {
			arr[0][i] = -1;
			
		}
		// ����		
		for (int i = 0; i < 102; i++) {
			arr[101][i] = -1;
		}
		
		// 0��
		for (int i = 0; i < 102; i++) {
			arr[i][0] = -1;
		}
		
		// ����
		for (int i = 0; i < 102; i++) {
			arr[i][101] = -1;
			
		}
		
		for(int i = 1; i <= 10; i++ ) {
			int test_case = bf.read();
			bf.readLine();
			String str;
//			String str = bf.readLine();
//			int test_case = Integer.parseInt(str);
			for (int j = 1; j <= 100; j++) {
				str = bf.readLine();
				String[] ss = str.split(" ");
				int k = 1;
				for (String string : ss) {
					arr[j][k++] = Integer.parseInt(string);
				}		
			}
	
			
			// �ϴ� 2 ã��
			int twoJ = 0;
			int twoI = 100;
			for(int m = 1; m <= 100; m++) {
				if ( arr[100][m] == 2) {
					twoJ = m;
				}
			}
			
			// ��� �ݺ��Ұ���!
			while(true) {
				//System.out.println(twoI + " " + twoJ);
				if(twoI == 1) break;
				
				// ��/�� 1�� �ִ��� ���� �� ���� �� �ö󰡱�
				
				// �� 1�ִ��� ������
				if(arr[twoI][twoJ+1] == 1 ) {
					while(true) {
						// ���������� ��� �̵�
						// ���� ���� �� ����
						twoJ++;
						
						// ���� �� ���� 0�̰ų� -1�̸� break;
						if(arr[twoI][twoJ+1] == 0 || arr[twoI][twoJ+1] == -1) {
							if(arr[twoI+1][twoJ] != -1 ) {
								twoI--;								
							}
							break;
						}
					}
					
				}
				// �� 1�ִ��� ������
				else if(arr[twoI][twoJ-1] == 1) {
					while(true) {
						// �������� ��� �̵�
						// ���� ���� �� ����
						twoJ--;
						
						// ���̶��
						if(arr[twoI][twoJ-1] == 0 || arr[twoI][twoJ-1] == -1) {
							if(arr[twoI+1][twoJ] != -1 ) {
								twoI--;								
							}
							break;
							
						}
					}
					
				}
				// �ƴϸ� �� �ö󰡱�
				else
					twoI--;

			}

			System.out.printf("#%d %d\n", test_case,(twoJ - 1));
		}		
	}
}


