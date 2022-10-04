import java.util.Scanner;

public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();
		int[][] map = new int[R][C];
		int r = 0;
		int c = 0;
		int d = 0;
		int cnt = 1;
		map[r][c] = 1;

		if (R * C < K) {
			System.out.println(0);
		} else {
			while (d < 4) {
				if (cnt == K) {
					System.out.println((c + 1) + " " + (r + 1));
					break;
				}
				int nr = r + dx[d];
				int nc = c + dy[d];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
					map[nr][nc] = ++cnt;
					r = nr;
					c = nc;
				} else {
					if (d == 3)
						d = 0;
					else
						d++;
				}
			}
		}
	}

}
