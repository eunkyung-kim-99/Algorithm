import java.util.Scanner;

public class Main {
	static int min = 987654321;
	static boolean state = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = { 3, 5 };

		recursive(arr, 0, 0, new int[N / 3 + 1], N);
		if (state)
			System.out.println(min);
		else
			System.out.println(-1);
	}

	private static void recursive(int[] arr, int idx, int k, int[] sel, int n) {
		if (n == 0) {
			min = Math.min(min, k);
			state = true;
			return;
		}
		if (n < 0) {
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			recursive(arr, i, k + 1, sel, n - arr[i]);
		}
	}
}
