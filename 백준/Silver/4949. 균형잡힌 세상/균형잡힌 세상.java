import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//균형잡힌 세상
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		while (true) {
			String str = bf.readLine();
			if (str.equals("."))
				break;
			stack.clear();
			boolean state = true;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty()) {
						state = false;
						break;
					} else {
						if (stack.peek() == '(') {
							stack.pop();
						} else {
							state = false;
							break;
						}
					}
				} else if (c == ']') {
					if (stack.isEmpty()) {
						state = false;
						break;
					} else {
						if (stack.peek() == '[') {
							stack.pop();
						} else {
							state = false;
							break;
						}
					}
				}
			}
			if (state && stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
