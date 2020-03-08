package kakao2019blind;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] str = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		String[] result = s.solution(str);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
