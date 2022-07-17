import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(bf.readLine());
			if (!list.contains(n % 42))
				list.add(n % 42);
		}

		System.out.println(list.size());
	}
}
