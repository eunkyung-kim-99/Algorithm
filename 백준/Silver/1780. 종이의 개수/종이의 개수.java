import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] count = new int[3];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check(map, N);
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}

	}

	private static void check(int[][] map, int n) {
		if (n == 1) {
			count[map[0][0] + 1]++;
			return;
		}
		int C = map[0][0];
		boolean state = true;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] != C) {
					state = false;
					break;
				}
			}
		}

		if (state) {
			count[C + 1]++;
		} else {
			n /= 3;
			int[][] tmp = new int[n][n];
			for (int i = 0; i < map.length; i += n) {
				for (int j = 0; j < map.length; j += n) {
					for (int r = i; r < i + tmp.length; r++) {
						for (int c = j; c < j + tmp.length; c++) {
							tmp[r - i][c - j] = map[r][c];
						}
					}
					check(tmp, n);
				}

			}
		}
	}

}
