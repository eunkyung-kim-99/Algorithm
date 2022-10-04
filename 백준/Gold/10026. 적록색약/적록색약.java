import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N, cnt1, cnt2;
	static boolean state = false;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		while (!state) {
			boolean[][] v = new boolean[N][N];
			state = false;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (!v[i][j]) {
						bfs(map, v, i, j);
						cnt1++;
					}
				}
			}
		}

		state = false;
		while (!state) {
			boolean[][] v = new boolean[N][N];
			state = false;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (!v[i][j]) {
						bfs2(map, v, i, j);
						cnt2++;
					}
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
	}

	private static void bfs(char[][] map, boolean[][] v, int r, int c) {
		Queue<Point> q = new LinkedList<>();

		q.offer(new Point(r, c));
		v[r][c] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = p.x + dx[d];
				int nc = p.y + dy[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
					if (map[p.x][p.y] == map[nr][nc]) {
						q.offer(new Point(nr, nc));
						state = true;
						v[nr][nc] = true;
					}
				}
			}
		}
	}
	private static void bfs2(char[][] map, boolean[][] v, int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		v[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = p.x + dx[d];
				int nc = p.y + dy[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
					if (map[p.x][p.y] == map[nr][nc]) {
						q.offer(new Point(nr, nc));
						state = true;
						v[nr][nc] = true;
					} else if (map[p.x][p.y] != 'B' && map[nr][nc] != 'B') {
						q.offer(new Point(nr, nc));
						state = true;
						v[nr][nc] = true;
					}
				}
			}
		}

	}
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
