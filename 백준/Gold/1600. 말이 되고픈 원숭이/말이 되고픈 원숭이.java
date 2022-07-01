import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, W, H, min = Integer.MAX_VALUE;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0, -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dy = { 0, 1, 0, -1, -1, 1, 2, 2, 1, -1, - 2, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0, 0);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][][] v = new boolean[H][W][K + 1];
		v[r][c][K] = true;
		q.offer(new int[] { r, c, 0, K });
		while (!q.isEmpty()) {
			int[] point = q.poll();
			if (point[0] == H - 1 && point[1] == W - 1) {
				min = Math.min(min, point[2]);
				break;
			}
			int dlen = point[3] > 0 ? 12 : 4;
			for (int d = 0; d < dlen; d++) {
				int nr = point[0] + dx[d];
				int nc = point[1] + dy[d];
				int nk = d > 3 ? point[3] - 1 : point[3];
				if (nr < 0 || nr >= H || nc < 0 || nc >= W)
					continue;
				if (!v[nr][nc][nk] && map[nr][nc] != 1) {
					v[nr][nc][nk] = true;
					q.add(new int[] { nr, nc, point[2] + 1, nk });
				}
			}

		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
}
