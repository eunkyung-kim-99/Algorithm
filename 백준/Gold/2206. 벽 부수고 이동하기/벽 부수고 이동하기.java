import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			String str = bf.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0, 0);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][][] v = new boolean[N][M][2];
		v[r][c][1] = true;
		q.offer(new int[] { r, c, 1, 1 });
		int n = 1;
		while (!q.isEmpty()) {
			int[] point = q.poll();
			if (point[0] == N - 1 && point[1] == M - 1) {
				System.out.println(point[2]);
				return;
			}
			for (int d = 0; d < dx.length; d++) {
				int nr = point[0] + dx[d];
				int nc = point[1] + dy[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc] == 0 && !v[nr][nc][point[3]]) {
					v[nr][nc][point[3]] = true;
					q.offer(new int[] { nr, nc, point[2] + 1, point[3] });
				}
				if (map[nr][nc] == 1 && point[3] == 1 && !v[nr][nc][point[3]]) {
					v[nr][nc][point[3]] = true;
					q.offer(new int[] { nr, nc, point[2] + 1, point[3] - 1 });
				}
			}

		}
		System.out.println(-1);
		return;
	}
}
