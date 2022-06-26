import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		int[][] adj = new int[N][N];

		for (int i = 0; i < adj.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < adj.length; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < adj.length; k++) {
			for (int i = 0; i < adj.length; i++) {
				if (i == k || adj[i][k] != 1)
					continue;
				for (int j = 0; j < adj.length; j++) {
					if (k == j || adj[i][j] == 1) continue;
					if (adj[k][j] == 1) {
						adj[i][j] = 1;
					}
				}
			}
		}

		print(adj);

	}

	private static void print(int[][] adj) {
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}
}
