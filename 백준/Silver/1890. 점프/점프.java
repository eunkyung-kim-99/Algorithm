import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static long[][] dp;
	static int[][] dir = { { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		dp = new long[N][N];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1L);
		}

		System.out.println(dfs(0, 0));
	}

	private static long dfs(int r, int c) {
		if (r == N - 1 && c == N - 1) {
			return 1;
		}
		if (dp[r][c] != -1) {
			return dp[r][c];
		}

		dp[r][c] = 0L;
		for (int d = 0; d < dir.length; d++) {
			int nr = r + dir[d][0] * map[r][c];
			int nc = c + dir[d][1] * map[r][c];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				dp[r][c] += dfs(nr, nc);
			}
		}

		return dp[r][c];

	}
}
