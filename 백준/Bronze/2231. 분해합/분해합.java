import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i < N; i++) {
			if (d(i) == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}

	private static int d(int i) {
		int sum = i;
		while (i > 0) {
			sum += i % 10;
			i /= 10;
		}
		return sum;
	}

}
