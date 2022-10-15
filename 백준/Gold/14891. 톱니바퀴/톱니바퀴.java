import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] top = new ArrayList[4];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < top.length; i++) {
			top[i] = new ArrayList<>();
		}
		for (int i = 0; i < top.length; i++) {
			String str = bf.readLine();
			for (int j = 0; j < str.length(); j++) {
				top[i].add(str.charAt(j) - '0');
			}
		}

		int K = Integer.parseInt(bf.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			dfs(n, d, 0);
		}

		int sum = 0;
		for (int i = 0; i < top.length; i++) {
			if (top[i].get(0) == 1) {
				sum += Math.pow(2, i);
			}
		}
		System.out.println(sum);
	}

	private static void dfs(int n, int d, int td) {
		if (td != 1) {// 전으로
			if (n - 1 >= 0 && top[n].get(6) != top[n - 1].get(2)) {
				dfs(n - 1, d == 1 ? -1 : 1, -1);
			}
		}
		if (td != -1) {// 앞으로
			if (n + 1 < 4 && top[n].get(2) != top[n + 1].get(6)) {
				dfs(n + 1, d == 1 ? -1 : 1, 1);
			}
		}
		if (d == 1) {// 시계방향
			top[n].add(0, top[n].get(top[n].size() - 1));
			top[n].remove(top[n].size() - 1);
		} else {
			top[n].add(top[n].get(0));
			top[n].remove(0);
		}
	}
}