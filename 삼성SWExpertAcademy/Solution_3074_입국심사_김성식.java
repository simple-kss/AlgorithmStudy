package algo0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution_3074_입국심사_김성식 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= tc ; t++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(stk.nextToken()); // 심사대 개수, 1 <= N <= 10^5
            int M = Integer.parseInt(stk.nextToken()); // 입국심사할 인원, 1 <= M <= 10^9
            long[] tester = new long[N];
            long time = 0;
            for(int i = 0; i < N; i++) {
                tester[i] = Integer.parseInt(br.readLine()); // 1 <= tk <= 10^9 걸림
            }
            Arrays.sort(tester);
             
            // N 입국심사대 갯수
            // M 사람명
             
             
             
            time = 0;
            long min = 0;
            long max = tester[N-1] * M + 1; // 시간
            // 그 result값으로 부합하는지 본다.
            while(min <= max) {
                time = (min + max) / 2;
                // result가 부합하는지 본다. (M과 비교한다)
                long personCnt = 0;
                // 그 반으로 쪼갠 시간에 몇명이나 수용할 수 있는지 검사한다.
                for(int i = 0; i < N; i++) {
                    personCnt += time / tester[i];
                }
                 
                // 수용할수 있는게 더 적다면 이전게 정답이다.
                if(M > personCnt) {
                    min = time + 1;
                }
                // 그 시간안에 수용할수 수 있는 인원이 M보다 크다면
                else {
                    // 앞ㅉ에 있는것이다.
                    max = time - 1;
                }
//              System.out.println(personCnt + " " + min + " " + max + "time : " + time);
                 
            } // end of tc
            sb.append('#').append(t).append(' ').append(min).append('\n');
        }
        System.out.println(sb);
         
         
         
 
    } // end of main
} // end of class
