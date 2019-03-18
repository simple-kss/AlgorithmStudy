import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1240_SW문제해결응용1일차_단순2진암호코드_김성식 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= testcase; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());

			String code = "";
			String read = "";

			for (int i = 0; i < n; i++) {
				read = br.readLine();
				// 마지막으로 1이 등장했다면
				if (read.lastIndexOf("1") != -1) {
					code = read; // 그 문장 저장
				}
			}

			int index = code.lastIndexOf("1"); // 끝에 번지부터 검사한다.
			int[] num = new int[8];

			int sum = 0;
			for (int i = 0; i < num.length; i++) {
				// 암호 공식
				// code를 추출한다.
				String check = code.substring(index - ((i + 1) * 7 - 1), index - ((i) * 7 - 1));
				switch (check) {
				case "0001101":
					num[7 - i] = 0;
					break;
				case "0011001":
					num[7 - i] = 1;
					break;
				case "0010011":
					num[7 - i] = 2;
					break;
				case "0111101":
					num[7 - i] = 3;
					break;
				case "0100011":
					num[7 - i] = 4;
					break;
				case "0110001":
					num[7 - i] = 5;
					break;
				case "0101111":
					num[7 - i] = 6;
					break;
				case "0111011":
					num[7 - i] = 7;
					break;
				case "0110111":
					num[7 - i] = 8;
					break;
				case "0001011":
					num[7 - i] = 9;
					break;
				}
				sum += num[7 - i];
			}

			int result = ((num[0] + num[2] + num[4] + num[6]) * 3 + num[1] + num[3] + num[5] + num[7]) % 10;
			sb.append("#").append(tc).append(" ");

			if (result == 0) {
				sb.append(sum);
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
