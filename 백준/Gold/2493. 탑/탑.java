import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());

		Stack<int[]> s = new Stack<>();

		for (int i = 0; i < N; i++) {
			int[] arr = {Integer.parseInt(st.nextToken()), i + 1};

			while (!s.isEmpty()) {

				if (s.peek()[0] < arr[0]) {
					s.pop();
				} else {
					System.out.print(s.peek()[1]+" ");
					break;
				}
			}
			if(s.isEmpty()) {
				System.out.print("0 ");
			}
			s.push(arr);
		}
	}
}
