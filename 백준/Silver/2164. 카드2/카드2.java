import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		int last = 0;

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		while (true) {
			last = queue.poll();
			if (!queue.isEmpty()) {
				queue.offer(queue.poll());
			} else {
				System.out.println(last);
				break;
			}
		}
	}
}