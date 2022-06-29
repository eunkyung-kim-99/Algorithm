import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] cal = new int[N][2];

		for (int i = 0; i < cal.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < cal[i].length; j++) {
				cal[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] memo = new int[N + 1];

		for (int i = N-1; i >= 0; i--) {
			if (i + cal[i][0] > N)
				memo[i] = memo[i + 1];
			else {
				memo[i] = Math.max(memo[i + 1], cal[i][1] + memo[i + cal[i][0]]);
			}
		}
		System.out.println(memo[0]);

	}

}
