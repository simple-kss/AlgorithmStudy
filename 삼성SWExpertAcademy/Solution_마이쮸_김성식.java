import java.util.Scanner;

class Person {
	int num;
	int cnt;
	public Person(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

public class Solution_마이쮸_김성식 {

	public static void main(String[] args) {
		//Queue<Integer> q = new Queue<Integer>();
		Scanner scan = new Scanner(System.in);
		
		int mi = 20;
		int numCount = 1;
		int pre = 0; // 현재 방문할 사람
		
		Person[] q = new Person[1000];
		int rear = -1;
		int front = -1;
		
		q[++rear] = new Person(1,1);

		int result = 0;
		while(mi >= 0) {
			scan.nextLine();
			
			
			
			// ************* 출력
			// 큐에 있는 사람의 수
			System.out.println("큐에 있는 사람의 수 :" + (rear - front));
			
			// 현재 일인당 나눠주는 사탕의 수
			for (int i = front + 1; i <= rear; i++) {
				System.out.println(q[i].num + "번 :" + q[i].cnt + "개");
				
			}
			
			// 현재까지 나눠준 사탕의 수
			System.out.println("현재까지 나눠준 사탕 갯수 :" + (20 - mi));
			// ************* 출력
			
			

			// 사탕을 준다
			mi -= q[++front].cnt;
			if(mi <= 0) {
				result = q[front].num;
				break;
			}
			
			// 주고나서 다시 줄세운다
			q[front].cnt++; // 하나를 증가시킨다음
			q[++rear] = q[front]; // 사람 넣기
			
			// 그리고 그 다음사람 추가			
			numCount++; // 그다음 사람 넣기, 1로 cnt준다
			q[++rear] = new Person(numCount,1); // 사람 넣기
		}
		System.out.println(result + "번이 가져간다!");
	}
}
