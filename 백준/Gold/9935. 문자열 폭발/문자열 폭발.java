import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static String str, bomb;
	static Stack<Character> s;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		str = bf.readLine();
		bomb = bf.readLine();
		s = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));

			// 마지막글자가 같으면
			if (s.get(s.size() - 1) == bomb.charAt(bomb.length() - 1)) {
				if (s.size() - bomb.length() >= 0) {
					check();
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if (s.size() > 0) {
			for (int i = 0; i < s.size(); i++) {
				sb.append(s.get(i));
			}
			System.out.println(sb);
		} else {
			System.out.println("FRULA");
		}
	}

	private static void check() {
		int index = 0;
		for (int j = s.size() - bomb.length(); j < s.size(); j++) {
			if (s.get(j) != bomb.charAt(index++))
				return;
		}

		for (int j = 0; j < bomb.length(); j++) {
			s.pop();
		}
	}
}
