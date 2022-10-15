import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int e, w;

		public Edge(int e, int w) {
			this.e = e;
			this.w = w;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		ArrayList<Edge>[] edge = new ArrayList[N + 1];
		for (int i = 0; i < edge.length; i++) {
			edge[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge[s].add(new Edge(e, w));
		}

		StringTokenizer st = new StringTokenizer(bf.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		boolean[] v = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[A] = 0;

		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for (int j = 0; j < dist.length; j++) {
				if (min > dist[j] && !v[j]) {
					min = dist[j];
					idx = j;
				}
			}

			v[idx] = true;

			for (int j = 0; j < edge[idx].size(); j++) {
				dist[edge[idx].get(j).e] = Math.min(dist[edge[idx].get(j).e], dist[idx] + edge[idx].get(j).w);
			}
		}

		System.out.println(dist[B]);
	}
}