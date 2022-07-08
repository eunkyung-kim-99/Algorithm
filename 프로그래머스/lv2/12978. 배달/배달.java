import java.util.Arrays;
class Solution {
public int solution(int N, int[][] road, int K) {
		int answer = 0;
		int[][] adj = new int[N][N];
		for (int i = 0; i < road.length; i++) {
			if (adj[road[i][0] - 1][road[i][1] - 1] != 0) {
				int min = Math.min(adj[road[i][0] - 1][road[i][1] - 1], road[i][2]);
				adj[road[i][0] - 1][road[i][1] - 1] = min;
				adj[road[i][1] - 1][road[i][0] - 1] = min;
			} else {
				adj[road[i][0] - 1][road[i][1] - 1] = road[i][2];
				adj[road[i][1] - 1][road[i][0] - 1] = road[i][2];
			}
		}

		int[] dist = new int[N];
		boolean[] v = new boolean[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;

		for (int i = 0; i < N - 1; i++) {
			int min_index = 0;
			int min = Integer.MAX_VALUE;
			for (int j = 1; j < dist.length; j++) {
				if (dist[j] < min && !v[j]) {
					min = dist[j];
					min_index = j;
				}
			}

			v[min_index] = true;

			for (int j = 0; j < adj.length; j++) {
				if (adj[min_index][j] != 0 && !v[j]) {
					dist[j] = Math.min(dist[j], dist[min_index] + adj[min_index][j]);
				}
			}

		}
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] <= K)
				answer++;
		}
		return answer;
	}
}