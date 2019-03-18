import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_SW문제해결기본9일차_사칙연산유효성검사_김성식 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			int vCnt = Integer.parseInt(br.readLine());
			int[] numArr = new int[vCnt+1];
			N = vCnt;
			
			// 다 배열에 저장
			for (int i = 1; i <= vCnt; i++) {
				
				String[] temp = new String[4];
				int cnt = 0;
				StringTokenizer stk = new StringTokenizer(br.readLine()," ");
				while(stk.hasMoreTokens()) {
					temp[cnt++] = stk.nextToken();					
				}
				int first = Integer.parseInt(temp[0]);
				int second = temp[1].charAt(0)-'0';
				numArr[first] = second;
				//System.out.println(numArr[first]);
			}
			//----------------------------------
//			int len =
			int result = 1;
			// 두개가 숫자이면 0
			if( numArr[2] >= 0 || numArr[3] >= 0 ) result = 0;
			
			for (int i = 2; i <= vCnt; i++) {
				// 내가 연산자이면
				// 2개의 자식을 갖고 있어야 하고, 2개의 자식들이 다 숫자여야한다
				int left = 2 * i;
				int right = 2 * i+1;
				if(numArr[i] < 0) {
					// 2개가 범위를 넘으면 안된다. 연산자인데
					// 자식들이 넘었다는건 숫자가 없단얘기다.
					// 그럼 끝
					if( left > vCnt || right > vCnt ) {
						result = 0;
						break;
					}
					// 내 자식들이 비어있으면 무효
					else if (numArr[left] == 0 || numArr[right] == 0 ) {
						result = 0;
						break;
					}
				}
				// 내가 숫자이면
				else {
					// 자식들이 없어야 한다.
					if( left <= vCnt && right <= vCnt ) {
						// 범위 안이고 비어있지 않다면
						if( numArr[left] != 0 || numArr[right] != 0) {
							result = 0;
							break;
						}
					}
				}
			}
			
			// 루트 2번과 3번은 연산자 이어야 한다.
			// 숫자면 무효
			
			
			
			// 계속 전위 체크해서
			// 후위 순회해서
			sb.append("#").append(t).append(" ").append(result).append("\n");
		} // end of testCase
		
		System.out.println(sb);
		System.out.println('*'-'0');
		System.out.println('/'-'0');
		System.out.println('+'-'0');
		System.out.println('-'-'0');
	} // end of main
	

} // end of class

/**
 * 
#1 0
#2 0
#3 0
#4 1
#5 0
#6 1
#7 1
#8 0
#9 0
#10 0

 */

//int result = 1;
//// 루트 2번과 3번은 연산자 이어야 한다.
//// 숫자면 무효
//if( numArr[2] >= 0 || numArr[3] >= 0 ) result = 0;
//for (int i = 2; i <= vCnt; i++) {
//	// 배열 저장 끝
//	// 부모와 자식들이 타입이 달라야함
//	// 부모가 숫자인 경우
//
////	if(vCnt > 2*i ) break;
//	if(numArr[i] >= 0) {
//		// 자식들이 타입이 다른지 확인
//		// 같으면 계산 불가
//		// 자식들도 숫자면 안됨
//		if(numArr[2*i] >=0 || numArr[2*i+1] >= 0) {
//			result = 0;
//			break;
//		}
//	}
//	// 부모가 연산자인경우
//	else {
//		if(numArr[2*i] <0 || numArr[2*i+1] < 0) {
//			result = 0;
//			break;
//		}
//	}
//}

/**
 * 
 *
171
1 - 2 3
2 - 4 5
3 + 6 7
4 / 8 9
5 - 10 11
6 + 12 13
7 - 14 15
8 - 16 17
9 * 18 19
10 7 20 21
11 * 22 23
12 - 24 25
13 * 26 27
14 / 28 29
15 + 30 31
16 - 32 33
17 / 34 35
18 * 36 37
19 * 38 39
20 3 40 41
21 + 42 43
22 - 44 45
23 / 46 47
24 * 48 49
25 * 50 51
26 / 52 53
27 - 54 55
28 - 56 57
29 + 58 59
30 / 60 61
31 / 62 63
32 * 64 65
33 / 66 67
34 / 68 69
35 - 70 71
36 / 72 73
37 + 74 75
38 - 76 77
39 * 78 79
40 + 80 81
41 2 82 83
42 * 84 85
43 / 86 87
44 - 88 89
45 - 90 91
46 - 92 93
47 * 94 95
48 / 96 97
49 * 98 99
50 + 100 101
51 * 102 103
52 + 104 105
53 * 106 107
54 / 108 109
55 * 110 111
56 - 112 113
57 / 114 115
58 * 116 117
59 - 118 119
60 * 120 121
61 * 122 123
62 * 124 125
63 * 126 127
64 + 128 129
65 - 130 131
66 * 132 133
67 - 134 135
68 / 136 137
69 + 138 139
70 / 140 141
71 / 142 143
72 - 144 145
73 * 146 147
74 * 148 149
75 - 150 151
76 - 152 153
77 * 154 155
78 + 156 157
79 * 158 159
80 / 160 161
81 - 162 163
82 9 164 165
83 3 166 167
84 / 168 169
85 * 170 171
86 4
87 2
88 8
89 3
90 6
91 3
92 6
93 8
94 1
95 9
96 4
97 4
98 3
99 3
100 7
101 7
102 2
103 2
104 7
105 9
106 7
107 1
108 8
109 3
110 9
111 3
112 6
113 3
114 1
115 7
116 2
117 1
118 7
119 9
120 2
121 7
122 9
123 3
124 7
125 1
126 9
127 3
128 6
129 9
130 1
131 9
132 7
133 8
134 1
135 6
136 8
137 9
138 1
139 7
140 2
141 3
142 4
143 4
144 2
145 2
146 8
147 8
148 3
149 1
150 6
151 6
152 7
153 4
154 3
155 1
156 6
157 9
158 4
159 3
160 4
161 1
162 4
163 -
164 -
165 *
166 -
167 *
168 -
169 7
170 4
171 2

*/
